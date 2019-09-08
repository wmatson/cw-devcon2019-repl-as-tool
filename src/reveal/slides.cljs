(ns reveal.slides
  (:require [reveal.example-data :as ed]
            [reveal.klipse :as rk]))

(def slide-1
  [:section
   [:h1 "reveal-cljs"]
   [:h3 "The ClojureScript-Wrapper for reveal.js"]
   [:p "Based on "
    [:a {:href "http://lab.hakim.se/reveal-js/"} "reveal.js"]]])

(def slide-2
  [:section
   [:section
    [:h2 "Finding duplicates"]
    (rk/klipse-snippet {:hidden-code `(def ~'data ~(vec ed/shuffled-data-with-duplicates))
                        :code 'data})
    [:footer.attribution "Names lifted from " [:a {:href "https://gist.github.com/ruanbekker/a1506f06aa1df06c5a9501cb393626ea"}
                                               "https://gist.github.com/ruanbekker/a1506f06aa1df06c5a9501cb393626ea"]]]])

(defn all
  "Add here all slides you want to see in your presentation."
  []
  [slide-1
   slide-2])
