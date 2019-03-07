(ns mw.main
  (:require [constants :refer (HEADER_POWERED_BY)]))

(defn hide-powered-by [req res nxt]
  (. res (set "X-Powered-By" HEADER_POWERED_BY))
  (nxt))

(defn cljs-session [req res nxt]
  (. res (set "X-Session" (. js/Math (random))))
  (nxt))
