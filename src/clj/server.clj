(ns server
  (:require [cemerick.austin.repls :refer (browser-connected-repl-js
                                           cljs-repl
                                           browser-repl-env)]
            [cemerick.austin :refer (repl-env)]
            [me.raynes.laser :as laser]
            [compojure.route :refer (resources)]
            [compojure.core :refer (GET defroutes ANY)]
            ring.adapter.jetty
            [clojure.java.io :as io]
            compojure.handler))

(defn repl-page []
  (laser/document
   (laser/parse (io/resource "public/dots.html"))
   (laser/element= :body)
   #(update-in % [:content] conj
               (laser/node
                :script
                :content (browser-connected-repl-js)))
   (laser/id= :dotsjs)
   #(update-in % [:attrs] assoc :src "js/compiled/pigrep.js")))

(defn page []
  (io/resource "public/dots.html"))

(defroutes site
  (resources "/")
  (GET "/repl" req (repl-page))
  (GET "/*" req (page)))

(def app
  (-> site
      (compojure.handler/site)))

(defn run
  []
  (defonce ^:private server
    (ring.adapter.jetty/run-jetty #'app {:port 8080 :join? false}))
  server)

(defn brepl []
  (cljs-repl (reset! browser-repl-env (repl-env))))
