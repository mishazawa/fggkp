(ns controller.user
  (:require [model.user :as User]
            [help.response :refer (send-200-json send-500-error)]))

(defn get-user [req res]
  (-> (User/read-user (.. req -params -id))
    (.then #(send-200-json res %))
    (.catch #(send-500-error res %))))
