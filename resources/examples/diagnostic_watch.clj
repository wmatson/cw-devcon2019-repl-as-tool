(ns scratchpad.one-offs.przo-3223-diagnostic-endpoint-diagnostics
  (:require [clojure.java.jdbc :as jdbc]
            [clj-http.client :as http]
            [clojure.core.async :as async :refer [>! go <!]]
            [cheshire.core :as json]))

(def db-conn
  {:classname "com.microsoft.sqlserver.jdbc.SQLServerDriver"
   :connection-uri "jdbc:sqlserver://dev-pricing-db;database=Regression;integratedSecurity=true"})

(defn get-most-recent []
  (-> (jdbc/query db-conn ["SELECT TOP 1 result FROM DiagnosticHits ORDER BY tsHit DESC"])
      first :result json/decode))

(defn get-diags []
  (:body (http/get "http://prod-boi-intake-prezo-app2:8084/prezo-ws/status/diagnostics"
                   {:as :json-string-keys})))

(defn- component-same [most-recent new component]
  (= (set (keys (get-in most-recent ["components" component])))
     (set (keys (get-in new ["components" component])))))

(defn- changed? [most-recent new]
  (not-every? #(component-same most-recent new %) ["ok" "warning" "critical"]))

(defn persist-changes! []
  (let [new (get-diags)]
    (when (changed? (get-most-recent) new)
      (jdbc/insert! db-conn "DiagnosticHits" ["result"] [(json/encode new)]))))

(async/go-loop []
  (<! (async/timeout 5000))
  (try
    (persist-changes!)
    (catch Exception e
      (.printStackTrace e)))
  (recur))
