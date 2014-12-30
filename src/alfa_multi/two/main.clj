(ns alfa-multi.two.main
	(:require [org.httpkit.server :refer [run-server]]
						[compojure.core :refer :all]
						[compojure.route :refer [not-found resources]]
						[ring.middleware.defaults :refer [wrap-defaults site-defaults]]
						[ring.middleware.resource :refer [wrap-resource]]
						[selmer.parser :refer [render-file]]))

(defn homepage
	[]
	(render-file "templates/base.html"
							 {:site "Alfa two"}))

(defonce server (atom nil))

(defroutes
	two-home
	(GET "/" req
			 (homepage))
	(resources "/public/")
	(not-found "Error from two"))

(defn start-two
	[port]
	(let [handler (-> two-home
										(wrap-resource "public")
										(wrap-defaults site-defaults))]
		(do (reset! server (run-server handler {:port port}))
				(println "http-kit server runs on port" port))))

(defn stop-two
	[]
	(do (@server)
			(reset! server nil)))
