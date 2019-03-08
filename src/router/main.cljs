(ns router.main
  (:require ["express" :refer (Router)]
            [controller.user :as user]
            [mw.user :as user-mw]))


(defn index-route [req res]
  (. res (send "index route")))

(def router
  (let [r (Router)]
    (. r (get "/user/:id?" user/get-user))
    (. r (post "/user" user-mw/validate-new-user user/create-user))
    (. r (put "/user/:id" (array user-mw/validate-user-id user-mw/validate-update-user) user/update-user))
    (. r (delete "/user/:id" user-mw/validate-user-id user/delete-user))
    ))
