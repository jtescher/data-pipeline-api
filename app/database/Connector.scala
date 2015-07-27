package database

import com.websudos.phantom.connectors.{KeySpace, ContactPoints}
import play.api.Play

trait Keyspace {
  val config = Play.current.configuration
  implicit val space: KeySpace = new KeySpace(config.getString("cassandra.keyspace").get)
}

object Defaults extends Keyspace {
  val hosts = Seq(config.getString("cassandra.host").get)
  val Connector = ContactPoints(hosts).keySpace(space.name)
}

trait Connector extends Defaults.Connector.Connector with Keyspace
