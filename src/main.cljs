(ns main
  (:require ["log-timestamp"]
            ["dotenv" :rename { config dotenv }]
            ["express" :as express]
            [controller.database :as db]
            [router.main :refer (router)]
            [mw.main :refer (cljs-session hide-powered-by)]
            ))


(defn main! []
  (dotenv)

  (db/init {
      :host (.. js/process -env -DB_HOST)
      :database (.. js/process -env -DB_NAME)
      :user (.. js/process -env -DB_USER)
      :password (.. js/process -env -DB_PASSWORD)
      :charset "utf8mb4"
    })

  (let [app (express)]

    (. app (use hide-powered-by))
    (. app (use cljs-session))
    (. app (use router))

    (. app (listen 3000 (fn []
      (println (map #(.toUpperCase %) ["app" "listen" "3000" (.. js/process -env -TEST)])))))))

(defn reload! []
  (db/close)
  (println "Code updated. Reload"))


