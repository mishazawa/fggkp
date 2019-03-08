(ns main
  (:require ["log-timestamp"]
            ["dotenv" :rename { config dotenv }]
            ["express" :as express]
            ["body-parser" :as body-parser]
            [controller.database :as db]
            [router.main :refer (router)]
            [mw.main :refer (cljs-session hide-powered-by)]
            ))

(defn shutdown-server []
  (db/close))

(.on js/process "SIGINT" shutdown-server)
(.on js/process "SIGTERM" shutdown-server)
(.on js/process "exit" shutdown-server)

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
    (. app (use (.json body-parser)))
    (. app (use router))

    (. app (listen (.. js/process -env -PORT) (fn []
      (println (map #(.toUpperCase %) ["app" "listen" (.. js/process -env -PORT)])))))))

(defn reload! []
  (shutdown-server)
  (println "Code updated. Reload"))


