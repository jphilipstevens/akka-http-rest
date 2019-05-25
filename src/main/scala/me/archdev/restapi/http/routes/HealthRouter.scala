package me.archdev.restapi.http.routes

import akka.http.scaladsl.server.Directives.{complete, get, pathPrefix}
import akka.http.scaladsl.server.Route

class HealthRouter {
  val route: Route = pathPrefix("healthcheck") {
    get {
      complete("OK")
    }
  }
}
