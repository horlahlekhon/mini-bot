import models.{Message, Response, User}

import scala.concurrent.Future
import scala.util.Success

class RepositorySpec extends TestSpec {


  val mesgs = List(
    Message(message = "Testd Ok", username = "Olalekan", reply = "MaybeNot"),
    Message(message = "Testd Ok", username = "Olalekan", reply = "MaybeNot") ,
    Message(message = "Testd Ok", username = "Oluwaseun", reply = "MaybeNot")
  )

  val resps = List(
    Response(msg = "World come together against Corona"),
    Response(msg = "World come together against Corona"),
    Response(msg = "World come together against Corona"),

  )

  "UserRepository.getAllUser" should {
    "returns all users in the system" in {
      userRepository.getAllUsers.onComplete {
        case Success(value) =>
          value mustBe asInstanceOf[Seq[User]]
        case _ => ()
      }
    }

    "Create a new user"in {
      val user = User(name = "Olalekan", title = "Mr", password = "Olalekan")
      userRepository.createUser(user)
      val userr = userRepository.getUser("Olalekan")
      userr.onComplete {
        case Success(value) =>
          value mustBe asInstanceOf[User]
        case _ => ()
      }
    }
    "Authenticate a user" in {
      val user = User(name = "Olalekan", title = "Mr", password = "Olalekan")
      userRepository.createUser(user)
      val userr = userRepository.auth(user.name, pass = user.password)
      userr.onComplete {
        case Success(value) =>
          value mustBe asInstanceOf[Option[User]]
        case _ => ()
      }
    }
  }

  "MessageRepository" should {

    "Return all messages" in {
      mesgs.map { msg =>
        messageRepo.createMessage(msg)
      }
      messageRepo.getAllMessages.onComplete{
        case Success(value) =>
          value mustBe mesgs
        case _ => ()
      }
    }

    "Return messages specific to a user " in  {
      val specific = List(
        Message(message = "Testd Ok", username = "Olalekan", reply = "MaybeNot"),
        Message(message = "Testd Ok", username = "Olalekan", reply = "MaybeNot")
      )
      mesgs.map { msg =>
        messageRepo.createMessage(msg)
      }
      messageRepo.getForUser("Oluwaseun").onComplete{
        case Success(value) =>
          value mustBe specific
        case _ => ()
      }
    }
  }

  "ResponseRepository" should {

    "Returns all responses" in  {
      resps.map { resp =>
        responseRepo.create(resp)
      }
      responseRepo.getAll.onComplete{
        case Success(value) =>
          value mustBe resps
        case _ => ()
      }
    }

    "Return a random response" in {

      responseRepo.getResponse.onComplete{
        case Success(value) =>
          value mustBe asInstanceOf[Response]
        case _ => ()
      }
    }
    }


}
