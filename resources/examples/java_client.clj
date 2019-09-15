(ns clj2018-scratchpad.one-offs.fx.client
  (:import [com.ca.fx FxClient]))

(def fx-client (FxClient.))

(defn- get-bs-rates [currency-ids sources]
  (let [repo (.getSpotRateRepository fx-client)]
    (.getBsRates repo currency-ids sources)))
