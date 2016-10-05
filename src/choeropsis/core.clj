(ns choeropsis.core
  (:require [gitwellsoon.core :as gws]
            [environ.core     :refer [env]]
            [rethinkdb.query  :as r]))

(def username (env :gituser))
(def password (env :gitpassword))
(def opts {:auth (str username ":" password)})

(def gh (gws/github-connector opts))

(defn make-url [user repo]
  (str user "/" repo))

(defn coupling [conn user repo]
  (let [data (-> (r/table "github")
                 (r/get (make-url user repo))
                 (r/run conn)
                 :data)]
    (gws/get-coupling data)))

(defn make-rethink-session []
  (r/connect :db "test"))

(defn download-commits [conn user repo]
  (let [data {:url (make-url user repo)
              :data (gws/get-data-for gh user repo)}]
    (-> (r/table "github")
        (r/insert data {:conflict :replace})
        (r/run conn))))
