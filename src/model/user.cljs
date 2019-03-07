(ns model.user
  (:require [controller.database :refer (query)]))

(defn create-user [data] nil)

(defn read-user [id]
  (if (nil? id)
    (query "SELECT * FROM users;" [])
    (query "SELECT * FROM users WHERE user_id = ?;" [id])))

(defn update-user [id data] nil)

(defn delete-user [id] nil)
