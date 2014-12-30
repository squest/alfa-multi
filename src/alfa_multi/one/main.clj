(ns alfa-multi.one.main
	(:require [immutant.web :refer :all]
						[compojure.core :refer :all]
						[compojure.route :refer [not-found resources]]
						[ring.middleware.defaults :refer [wrap-defaults site-defaults]]
						[ring.middleware.resource :refer [wrap-resource]]
						[selmer.parser :refer [render-file]]))

(defn homepage
	[]
	(render-file "/templates/base.html"
							 {:site "Alfa two"}))

(defonce web-server (atom nil))

(defroutes
	one-home
	(GET "/" req
			 (homepage))
	(resources "/public/")
	(not-found "Error from one"))

(defn start-one
	[port]
	(let [handler (-> one-home
										(wrap-resource "public")
										(wrap-defaults site-defaults))]
		(do (reset! web-server (run handler {:port port}))
				(println "Immutant web undertow runs on port " port))))

(defn stop-one
	[]
	(do (stop @web-server)
			(reset! web-server nil)))