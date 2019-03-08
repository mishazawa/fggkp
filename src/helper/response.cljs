(ns helper.response)

(defn send-200-json [response data]
  (-> response
    (.status 200)
    (.json (clj->js data))))

(defn send-500-error [response err]
  (-> response
    (.status 500)
    (.json err)))
