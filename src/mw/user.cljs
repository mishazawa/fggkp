(ns mw.user
  (:require [helper.response :refer (send-500-error)]))


(defn validate-user-id [req res nxt]
  (if (nil? (.. req -params -id)) (send-500-error res "Bad request => no user_id") (nxt)))

(defn validate-new-user [req res nxt]
  (if (nil? (.. req -body -username)) (send-500-error res "No username") (nxt)))

(defn validate-update-user [req res nxt]
  (if (nil? (.. req -body)) (send-500-error res "Bad request => no body") (nxt)))
