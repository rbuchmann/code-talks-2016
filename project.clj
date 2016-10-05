(defproject choeropsis "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [metosin/compojure-api "1.1.8"]
                 [environ "1.1.0"]
                 [com.apa512/rethinkdb "0.15.26"]
                 [gitwellsoon "0.1.0-SNAPSHOT"]]
  :ring {:handler choeropsis.handler/app}
  :uberjar-name "server.jar"
  :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]]
                   :plugins [[ikitommi/lein-ring "0.9.8-FIX"]]}})
