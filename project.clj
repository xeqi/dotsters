(defproject dots "0.1.0-SNAPSHOT"
  :description "A game written using ClojureScript and core.async"
  :url ""
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/core.async "0.1.242.0-44b1e3-alpha"]
                 [org.clojure/clojurescript "0.0-1913"]
                 [crate "0.2.4"]
                 [jayq "2.4.0"]]
  :profiles
  {:dev {:dependencies [[ring "1.2.0"]
                        [compojure "1.1.5"]
                        [me.raynes/laser "1.1.1"]]
         :source-paths ["src/clj"]
         :repl-options {:init-ns server}
         :plugins [[com.cemerick/austin "0.1.0"]
                   [lein-cljsbuild "0.3.3"]]
         :cljsbuild {:builds [{:source-paths ["src/dots"]
                               :compiler {
                                          :output-to "resources/public/js/compiled/dots.js"
                                          :externs ["resources/public/js/externs/jquery-1.9.js"]
                                          :optimizations :simple
                                          :pretty-print true}}
                              {:id "pigrep"
                               :source-paths ["src/pigrep"]
                               :compiler {:output-to "resources/public/js/compiled/pigrep.js"
                                          :optimizations :simple
                                          :pretty-print true}}]}}})
