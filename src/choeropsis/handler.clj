(ns choeropsis.handler
  (:require [compojure.api.sweet     :refer :all]
            [ring.util.http-response :refer :all]
            [choeropsis.core         :as core]
            [schema.core             :as s]))

(s/defschema Entity
  {:entity s/Str
   :coupled s/Str
   :degree s/Int
   :average-revs s/Int})

(defn make-app [conn]
  (api
    {:swagger
     {:ui "/"
      :spec "/swagger.json"
      :data {:info {:title "Choeropsis"
                    :description "Compojure Api example"}
             :tags [{:name "api", :description "some apis"}]}}}

    (context "/api" []
             :tags ["api"]

             (GET "/coupling/:user/:repo" []
                  :return [Entity]
                  :path-params [user :- s/Str
                                repo :- s/Str]
                  (ok (core/coupling conn user repo)))
             (PUT "/download/:user/:repo" []
                  :return {:success s/Bool}
                  :path-params [user :- s/Str
                                repo :- s/Str]
                  (ok (if-let [result (core/download-commits conn user repo)]
                        true
                        false))))))

(def app (make-app (core/make-rethink-session)))
