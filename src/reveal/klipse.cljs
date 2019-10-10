(ns reveal.klipse
  (:require-macros [hiccups.core :as hiccups :refer [html]])
  (:require [hiccups.runtime :as hiccupsrt]
            [reveal.example-data :as ed]))

(defn- code-html [hidden-quoted-code quoted-code]
  (html [:div {:style "font-size: 33px;"}
         [:pre {:hidden true}
          [:code.klipse (str hidden-quoted-code)]]
         [:pre [:code.klipse (str quoted-code)]]
         [:link {:rel "stylesheet" :type "text/css" :href "https://storage.googleapis.com/app.klipse.tech/css/codemirror.css"}]
         [:script "window.klipse_settings = {selector: '.klipse',
codemirror_options_in: {autoCloseBrackets: true}};"]
         [:script {:src "https://storage.googleapis.com/app.klipse.tech/plugin/js/klipse_plugin.js"}]]))

(defn klipse-snippet
  "Code parameters must be quoted"
  [{:keys [hidden-code code height]
    :or {height "200px"}}]
  [:iframe {:sandbox "allow-scripts" :height height :width "100%"
            :srcdoc (code-html hidden-code code)}])
   

