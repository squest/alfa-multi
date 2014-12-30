(defproject
  alfa-multi
  "0.1.0"
  :dependencies
  [[org.clojure/clojure "1.6.0"]
   [zenedu/zenpack "0.1.11"]
   [org.immutant/immutant "2.0.0-beta1"]
   [com.cemerick/url "0.1.1"]
   [clj-time "0.9.0"]
   [enlive "1.1.5"]
   [org.clojure/core.async "0.1.338.0-5c5012-alpha"]
   [org.clojure/clojurescript "0.0-2511"]
   [reagent "0.4.3"]
   [cljs-ajax "0.3.3"]
   [kioo "0.4.0"]
   [com.ashafa/clutch "0.4.0"]
   [garden "1.2.5"]
   [com.taoensso/carmine "2.9.0"]]

  :cljsbuild
  {:builds
   [{:source-paths ["src-cljs"],
     :compiler {:pretty-print false,
                :closure-warnings {:non-standard-jsdoc :off},
                :output-to "resources/public/includes/app.js",
                :output-wrapper false,
                :optimizations :simple}}]}
  :profiles
  {:uberjar {:aot :all},
   :production
            {:ring
             {:open-browser? false
              :stacktraces? false
              :auto-reload? false}}}
  :url "http://example.com/FIXME"
  :main alfa-multi.core
  :jvm-opts ["-server"]
  :plugins [[lein-ring "0.8.13"]
            [codox "0.8.10"]
            [lein-expectations "0.0.8"]
            [lein-environ "1.0.0"]
            [lein-cljsbuild "1.0.3"]
            [lein-autoexpect "1.4.2"]]
  :description "FIXME: write description"
  :min-lein-version "2.0.0")
