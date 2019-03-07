(ns controller.database
  (:require ["mysql" :as mysql]))

(defonce connection (atom {}))

(defn init [config]
  (swap! connection #(.createConnection mysql (clj->js config)))
  (.connect @connection #(println "MySQL connected.")))

(defn close []
  (println "MySQL closed.")
  (.end @connection))

(defn query [q args]
  (js/Promise. (fn [res rej]
    (.query @connection q (clj->js args) (fn [error, results, fields]
      (if (nil? error) (res results) (rej error)))))))

