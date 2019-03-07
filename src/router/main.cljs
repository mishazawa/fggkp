(ns router.main
  (:require ["express" :refer (Router)]
            [controller.user :refer (get-user)]))


(defn index-route [req res]
  (. res (send "index route")))

(def router
  (let [r (Router)]
    (. r (get "/:id?" get-user))))
