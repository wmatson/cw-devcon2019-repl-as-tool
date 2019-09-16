(ns reveal.macros
  (:require [clojure.java.io :as io]))

(def html-escapes
  {\< "&lt;"
   \> "&gt;"})

(defmacro slurp-resource [file]
  (clojure.string/escape (slurp (io/resource file))
                         html-escapes))
