(ns reveal.macros
  (:require [clojure.java.io :as io]))

(defmacro slurp-resource [file]
  (slurp (io/resource file)))
