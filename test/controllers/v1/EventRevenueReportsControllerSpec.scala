import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
import play.api.test.Helpers._
import play.api.test._

@RunWith(classOf[JUnitRunner])
class EventRevenueReportsControllerSpec extends Specification {

  "EventRevenueReportsController#index" should {
    "render the index page" in new WithApplication{
      val home = route(FakeRequest(GET, "/v1/event-revenue-reports")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/plain")
      contentAsString(home) must contain ("Hello World")
    }
  }

}
