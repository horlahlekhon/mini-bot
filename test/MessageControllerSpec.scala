import akka.actor.ActorSystem
import controllers.MessagesController
import models.{Global, RegisterUser, UserRepository}
import org.scalatest.mock.MockitoSugar
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.{GuiceOneAppPerSuite, GuiceOneAppPerTest}
import play.api.test.CSRFTokenHelper._
import play.api.test.Helpers._
import play.api.test.{FakeRequest, Helpers, Injecting}
import reactivemongo.play.json.collection.JSONCollection
import controllers.AuthAction

import scala.concurrent.{ExecutionContext, Future}


class MessageControllerSpec extends TestSpec with MockitoSugar{
  val controller = new MessagesController(cc = Helpers.stubMessagesControllerComponents(),
    messageRepository = messageRepo, authAction = authAction, ec = ex,
    actorSystem = system, responseRepo = responseRepo, configuration = configuration )

  "MessageController GET /chat/messages" should {
    "serve chat homepage with existing messages" in {

      val chatHome = controller.chatHome().apply(FakeRequest(GET, "/chat/messages").withSession(Global.SESSION_USERNAME_KEY -> "lekan").withCSRFToken)
      status(chatHome) mustBe 200
      contentType(chatHome) mustBe Some( "text/html")
      contentAsString(chatHome)must include ("Welcome to MiniMicroBot lekan, pardon the username, if you will... Enter a text and let the bot respond like a boss")
    }
  }

  "MessageController POST /chat/messages" should {
    "post message successfully" in {
      val chatPost = controller.reply().apply(FakeRequest(POST, "/chat/messages").withFormUrlEncodedBody("message" -> "Testing testing 1 2").withSession(Global.SESSION_USERNAME_KEY -> "lekan").withCSRFToken)
      status(chatPost) mustBe 303
      redirectLocation(chatPost) mustBe Some("/chat/messages")
    }
  }

  "MessageController GET /chat/messages" should {
    "redirect back to home if user is not authenticated" in {

      val chatHome = controller.chatHome().apply(FakeRequest(GET, "/chat/messages").withCSRFToken)
      status(chatHome) mustBe 303
      redirectLocation(chatHome) mustBe Some("/")
    }
  }

  "MessageController POST /chat/messages" should {
    "redirect back to home if user is not authenticated" in {

      val chatHome = controller.chatHome().apply(FakeRequest(POST, "/chat/messages").withCSRFToken)
      status(chatHome) mustBe 303
      redirectLocation(chatHome) mustBe Some("/")
    }
  }

}
