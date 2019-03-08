(ns model.user
  (:require [helper.sql :refer (esc)]
            [controller.database :refer (query)]))

(defn create-user [data]
  (query "INSERT INTO users SET ?;" [data]))

(defn read-user [id]
  (if (nil? id)
    (query "SELECT * FROM users;" [])
    (query "SELECT * FROM users WHERE user_id = ?;" [id])))

(defn update-user [id data]
  (query (str "UPDATE users SET" (esc data) "WHERE user_id = " (esc id)) []))

(defn delete-user [id]
  (query "DELETE FROM users WHERE user_id = ?;" [id]))
