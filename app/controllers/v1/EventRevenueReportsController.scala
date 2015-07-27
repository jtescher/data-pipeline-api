package controllers.v1

import models.EventRevenueReports
import play.api.libs.json.Json
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.{Action, Controller}

class EventRevenueReportsController extends Controller {

  def index = Action.async {
    EventRevenueReports.all.map { eventRevenueReports =>
      Ok(Json.obj(
        "eventRevenueReports" -> eventRevenueReports
      ))
    }
  }

}
