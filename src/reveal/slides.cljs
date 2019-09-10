(ns reveal.slides
  (:require [reveal.example-data :as ed]
            [reveal.klipse :as rk]
            [reveal.vendored-medley :as vm]
            [clojure.pprint :as pp]))

(defn- stringify-code [quoted-code]
  (with-out-str
    (pp/with-pprint-dispatch
      pp/code-dispatch
      (pp/pprint quoted-code))))
                 

(def slide-1
  [:section
   [:h2 "REPL Eases Programmer Lives"]
   [:h5 "Wesley Matson"]
   [:footer.attribution "Clearwater Developer Conference 2019"]])
   
(def slide-2
  [:section
   [:section
    [:h2 "Finding duplicates"]
    (rk/klipse-snippet {:hidden-code `(do (def ~'data ~(vec ed/shuffled-data-with-duplicates))
                                          ~vm/medley)
                        :code 'data})
    [:footer.attribution "Names lifted from " [:a {:href "https://gist.github.com/ruanbekker/a1506f06aa1df06c5a9501cb393626ea"}
                                               "https://gist.github.com/ruanbekker/a1506f06aa1df06c5a9501cb393626ea"]]]])

(def slide-3
  [:section
   [:section
    [:h2 "Useful Libs"]
    [:ul
     [:li [:a {:href "https://github.com/weavejester/medley"} "weavejester/medley"]]
     [:li [:a {:href "https://github.com/dakrone/clj-http"} "clj-http"]]
     [:li [:a {:href "https://github.com/dakrone/cheshire"} "cheshire"]]
     [:li [:a {:href "https://github.com/TheClimateCorporation/claypoole"} "claypoole"]]
     [:li [:a {:href "https://github.com/ptaoussanis/tufte"} "tufte"]]]]
   [:section
    [:pre
     [:code.hljs {:data-line-numbers "" :data-trim "true"}
      (stringify-code '(ns scratcpad.one-offs.some-endpoint-investigation
                         (:require [cheshire.core :as json]
                                   [clj-http.client :as http]
                                   [medley.core :as medley])))]]]])
 
(defn all
  "Add here all slides you want to see in your presentation."
  []
  [slide-1
   slide-2
   slide-3])
