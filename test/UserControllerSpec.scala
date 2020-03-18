import akka.actor.ActorSystem
import controllers.{HomeController, UserController}
import models.{RegisterUser, User, UserRepository}
import org.scalatest.mock.MockitoSugar
import org.scalatestplus.play.PlaySpec
import play.api.test.CSRFTokenHelper._
import play.api.test.Helpers._
import play.api.test.{FakeRequest, Helpers, Injecting}
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.{ExecutionContext, Future}

class UserControllerSpec extends TestSpec with MockitoSugar  {


  "HomeController Index" should {
    "render the index page" in  {
      val controller = new HomeController(Helpers.stubMessagesControllerComponents(), userRepository)
      val home = controller.index().apply(FakeRequest(GET, "/").withCSRFToken)

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include (" Welcome to Minibot Kindly log in to chat with the bot ")
    }
  }

  "UserController GET /users/register " should {
    "render registeration form" in {
      val actorSystem = mock[ActorSystem]
      val controller = new UserController(Helpers.stubMessagesControllerComponents(),actorSystem, userRepository)
      val register = controller.serveRegister().apply(FakeRequest(GET, "/users/register").withCSRFToken)

      status(register) mustBe OK
      contentType(register) mustBe Some("text/html")
      contentAsString(register) must include ("Title(Mr/Mrs/Ms)")
    }
  }

  "UserController POST /users/register " should {
    "accept registeration post form with valid data" in {
      val actorSystem = mock[ActorSystem]
      val controller = new UserController(Helpers.stubMessagesControllerComponents(),actorSystem, userRepository)
      val user = RegisterUser(title = "Mrs", name = "Sayo", password = "Encore")
      val postRegister = controller.register().apply(FakeRequest(POST, "/users/register").withFormUrlEncodedBody("username" -> "lekan", "password" -> "1234455", "title" -> "Mr").withCSRFToken)
      val redr = redirectLocation(postRegister)
      status(postRegister) mustBe 303
      redirectLocation(postRegister) mustBe Some("/chat/messages")
    }
    }
//  "UserControler POST /users/login" should {
//    "Log a valid user in" in {
//      val actorSystem = mock[ActorSystem]
//      val controller = new UserController(Helpers.stubMessagesControllerComponents(), actorSystem, userRepository)
//      userRepository.createUser(User(name = "lekan", password = "123456", title = "Mr"))
//      val postLogin = controller.register().apply(FakeRequest(POST, "/users/login").withFormUrlEncodedBody("username" -> "lekan", "password" -> "123456").withCSRFToken)
//      status(postLogin) mustBe 303
//      redirectLocation(postLogin) mustBe Some("/chat/messages")
//
//    }
//  }

  "UserControler POST /users/login" should {
    "reject an valid user in" in {
      val actorSystem = mock[ActorSystem]
      val controller = new UserController(Helpers.stubMessagesControllerComponents(),actorSystem, userRepository)
      val postLogin = controller.register().apply(FakeRequest(POST, "/users/login").withFormUrlEncodedBody("username" -> "kan", "password" -> "34455").withCSRFToken)
      status(postLogin) mustBe 400
//      redirectLocation(postRegister) mustBe "/users/login"
    }
  }

}
