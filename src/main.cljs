(ns main
  (:require ["express" :as express]
            [router.main :refer (router)]
            [mw.main :refer (cljs-session hide-powered-by)]))

(defn main! []
  (let [app (express)]

    (. app (use hide-powered-by))
    (. app (use cljs-session))
    (. app (use router))

    (. app (listen 3000 (fn []
      (println (map #(.toUpperCase %) ["app" "listen" "3000"])))))))

(defn reload! []
  (println "Code updated. Reload"))


