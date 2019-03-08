(ns controller.user
  (:require [helper.uuid :refer (gen-uuid)]
            [model.user :as User]
            [helper.response :refer (send-200-json send-500-error)]))

(defn- gen-plain-user [id username]
  { :username username
    :user_id id
    :created (js/Date.) })

(defn- user-body-keys [body]
  (select-keys (js->clj body :keywordize-keys true) [:username :userpic :f_name :l_name :info]))

(defn get-user [req res]
  (-> (User/read-user (.. req -params -id))
    (.then #(send-200-json res %))
    (.catch #(send-500-error res %))))

(defn create-user [req res]
  (let [username (.. req -body -username) id (gen-uuid)]
    (-> (User/create-user (gen-plain-user id username))
      (.then #(send-200-json res {:user_id id}))
      (.catch #(send-500-error res %)))))

(defn update-user [req res]
  (let [k (user-body-keys (.. req -body))]
    (if (empty? k)
      (send-500-error res "Bad request => no data")
      (-> (User/update-user (.. req -params -id) k)
        (.then #(send-200-json res %))
        (.catch #(send-500-error res %))))))

(defn delete-user [req res]
  (-> (User/delete-user (.. req -params -id))
    (.then #(send-200-json res %))
    (.catch #(send-500-error res %))))
