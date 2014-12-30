(ns alfa-multi.core
  (:require [alfa-multi.one.main :refer [start-one]]
            [alfa-multi.two.main :refer [start-two]])
  (:gen-class))

(defn -main []
  (do (start-one 3000)
      (start-two 3001)))