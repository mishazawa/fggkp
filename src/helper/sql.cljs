(ns helper.sql
  (:require ["mysql" :refer (escape)]))

(defn esc [data]
  (escape (clj->js data)))
