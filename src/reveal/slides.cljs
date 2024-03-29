(ns reveal.slides
  (:require-macros [reveal.macros :refer [slurp-resource]])
  (:require [reveal.example-data :as ed]
            [reveal.klipse :as rk]
            [reveal.vendored-medley :as vm]
            [clojure.pprint :as pp]))

(defn- stringify-code [quoted-code]
  (with-out-str
    (pp/with-pprint-dispatch
      pp/code-dispatch
      (pp/pprint quoted-code))))

(def live-coding
  [:section
   [:p "There are duplicate IDs in this data!"]
   (rk/klipse-snippet {:height "400px"
                       :hidden-code `(do (def ~'data ~(vec ed/shuffled-data-with-duplicates))
                                         ~vm/medley)
                       :code 'data})
   [:footer.attribution "Names lifted from " [:a {:href "https://gist.github.com/ruanbekker/a1506f06aa1df06c5a9501cb393626ea"}
                                              "https://gist.github.com/ruanbekker/a1506f06aa1df06c5a9501cb393626ea"]]
   [:p.fragment "Are there duplicate names?"]])

;;Dial in audience better
;;More Clojure-specifc vs Java and whatnot

(def intro
  [:section
   [:section
    [:h2 "Coding Convenient Clojure Contraptions"]
    [:h5 "Wesley Matson"]
    [:footer.attribution "Clearwater Developer Conference 2019"]]
   [:section
    [:h2 "About Me"]
    [:ul
     [:li "~7 years Clearwater Tenure"]
     [:li "35+ Programming Languages"]
     [:li "Non-programming Hobbies"]]]
   live-coding
   [:section
    [:h2 "Agenda"]
    [:ul
     [:li "Context"]
     [:li "Case Studies"]
     [:li "Challenges"]]
    [:p.fragment "Interrupt me!"]]])

(def context-establishment
  [:section
   [:section
    [:h2 "Definitions"]
    [:ul
     [:li "REPL"]
     [:li "Scratchpad Project"]]]
   [:section
    [:h2 "Scratchpad Projects"]
    [:ul
     [:li.fragment "Why?"]
     [:li.fragment "Why Clojure?"]
     [:li.fragment
      [:div "Directory Structure"]
      [:pre 
       "project.clj
/src/&lt;project-name&gt;
    /protos
    /services
    /one_offs"]]
     [:li.fragment "Share!"]]]
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
     
   
(def endpoint-performance
  [:section
   [:section
    [:h2 "Case Study"]
    [:p "Endpoint Performance"]]
   [:section
    [:pre.stretch {:style "font-size: .4em;"}
     [:code {:data-line-numbers ""}
      (slurp-resource "examples/endpoint-performance.clj")]]]
   [:section
    [:pre {:style "font-size: .31em; width: 100%;"}
     [:code (slurp-resource "examples/endpoint-performance-output.txt")]]]
   [:section
    [:h4 "Similar Applications"]
    [:ul
     [:li "Regression testing"
      [:span " ("
       [:a {:href "https://clojuredocs.org/clojure.data/diff"} "clojure.data/diff"]
       ")"]]
     [:li "Stress testing"
      [:span " (" [:a {:href "https://github.com/TheClimateCorporation/claypoole"} "claypoole"]
       ")"]]
     [:li "Smoke testing"]]]])
     
(def diagnostic-watch
  [:section
   [:section
    [:h2 "Case Study"]
    [:p "Diagnostic Watching"]]
   [:section
    [:pre.stretch {:style "font-size: .33em;"}
     [:code {:data-line-numbers ""}
      (slurp-resource "examples/diagnostic_watch.clj")]]]
   [:section
    [:h3 "Diagnostic Watch Results"]
    [:img.stretch {:src "img/diagnostic-results.png"}]]])
    
(def legacy-client
  [:section
   [:section
    [:h2 "Case Study"]
    [:p "Legacy Java Client"]]
   [:section
    [:pre.stretch {:style "font-size: .42em;"}
     [:code.clojure {:data-line-numbers ""}
      (slurp-resource "examples/java_client.clj")]]]])

(def other-cases
  [:section
   [:h2 "Other Possibilities"]
   [:ul
    [:li "Endpoint Scraping"]
    [:li "Migrating between data models"]
    [:li "Seeding " [:a {:href "https://cucumber.io/docs/guides/10-minute-tutorial/"} "cucumber"]
     "ish tests"]
    [:li "Admin Tools (e.g. "
     [:a {:href "https://github.com/FundingCircle/jackdaw/blob/master/src/jackdaw/admin.clj"} "for Kafka"]
     ") "]]])

(def adoption-difficulties
  [:section
   [:section
    [:h2 "Adoption Nontrivial"]
    [:ul.fragment
     [:li "Clojure Resistance"]
     [:li "Tooling"]]]
   [:section
    [:h2 "Coping Strategies"]
    [:ul
     [:li "Call to authority"]
     [:li "Build something useful"]
     [:li "Outlearn and outteach"]]]])
    
(def conclusion
  [:section
   [:section
    [:h2 "Additional Resources"]
    [:ul
     [:li [:a {:href "https://www.youtube.com/watch?v=Qx0-pViyIDU"} "Running with Scissors by Stuart Halloway"]]
     [:li [:a {:href "https://www.braveclojure.com"} "Clojure for the Brave and True"]]
     [:li [:a {:href "https://www.reddit.com/r/Clojure/"} "/r/Clojure"]]
     [:li [:a {:href "https://github.com/den1k/zeal"} "Zeal"] " (REPL meets clipboard manager)"]]]
   [:section
    [:h2 "Summing Up"]
    [:p "Scratchpad projects augment teams"]
    [:p "Clojure helps"]]
   [:section
    [:h2 "Questions?"]
    [:footer.attribution
     [:div "Slides Source: " [:a {:href "https://github.com/wmatson/cw-devcon2019-repl-as-tool"} "https://github.com/wmatson/cw-devcon2019-repl-as-tool"]]
     [:div "Created with "  [:a {:href "https://github.com/n2o/reveal-cljs"} "reveal-cljs"]
      " and " [:a {:href "https://github.com/viebel/klipse"} "klipse"]]]]])
     
(defn all
  "Add here all slides you want to see in your presentation."
  []
  [intro
   context-establishment
   endpoint-performance
   diagnostic-watch
   legacy-client
   other-cases
   adoption-difficulties
   conclusion])
