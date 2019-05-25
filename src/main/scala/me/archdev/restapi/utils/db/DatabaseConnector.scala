package me.archdev.restapi.utils.db

import com.zaxxer.hikari.{ HikariConfig, HikariDataSource }
import slick.jdbc.PostgresProfile

class DatabaseConnector(jdbcUrl: String, dbUser: String, dbPassword: String) {

  private val dataSource = {
    val hikariConfig = new HikariConfig()
    hikariConfig.setJdbcUrl(jdbcUrl)
    hikariConfig.setUsername(dbUser)
    hikariConfig.setPassword(dbPassword)

    new HikariDataSource(hikariConfig)
  }

  val profile: PostgresProfile.type = slick.jdbc.PostgresProfile
  import profile.api._

  val db: profile.backend.DatabaseDef = Database.forDataSource(dataSource, None)
  db.createSession()

}
