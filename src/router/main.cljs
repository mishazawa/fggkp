(ns router.main
  (:require ["express" :refer (Router)]))


(defn index-route [req res]
  (. res (send "index route")))

(def router
  (let [r (Router)]
    (. r (get "/" index-route))))
