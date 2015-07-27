package models

import com.websudos.phantom.dsl._
import database.Connector
import play.api.libs.json._
import scala.concurrent.Future

case class EventRevenueReport(id: Int, total: BigDecimal)

object EventRevenueReport {
  implicit val eventRevenueReportsFormat = Json.format[EventRevenueReport]
}

class EventRevenueReports extends CassandraTable[EventRevenueReports, EventRevenueReport] {
  override val tableName = "event_totals"

  object id extends IntColumn(this) with PrimaryKey[Int]
  object total extends BigDecimalColumn(this)

  def fromRow(row: Row): EventRevenueReport = {
    EventRevenueReport(
      id(row),
      total(row)
    )
  }

}

object EventRevenueReports extends EventRevenueReports with Connector {

  def all: Future[Seq[EventRevenueReport]] = {
    select.limit(5000).fetch()
  }

}
