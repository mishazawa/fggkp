(ns model.message
  (:require [controller.database :refer (query)]))

(defn create-message [data]
  (query "INSERT INTO messages SET ?;" [data]))

(defn read-messages [chat-id page limit]
  (query "SELECT * FROM messages WHERE chat_id = ? ORDER BY id DESC LIMIT ?, ?;" [id page limit]))

(defn update-message [id data]
  (query "UPDATE messages SET value = ? WHERE id = ?;" [data id]))

(defn delete-user [id]
  (query "DELETE FROM messages WHERE id = ?;" [id]))

