package me.archdev.restapi.http

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import ch.megard.akka.http.cors.scaladsl.CorsDirectives._
import me.archdev.restapi.http.routes.HealthRouter

import scala.concurrent.ExecutionContext

class HttpRoute(routes: List[Route])(implicit executionContext: ExecutionContext) {

  private val healthRouter = new HealthRouter()

  val route: Route =
    logRequestResult("sample") {
      cors() {
        pathPrefix("v1")(routes.reduce((a, b) => a ~ b)) ~ healthRouter.route
      }
    }

}
