package controllers

import akka.actor.ActorSystem
import javax.inject.Inject
import models.{Global, User, UserRepository}
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
class UserController @Inject()(cc: MessagesControllerComponents, actorSystem: ActorSystem, userRepository: UserRepository)(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  private val formSubmitUrl = routes.UserController.login

  def login: Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    val data = User.loginForm.bindFromRequest.data
    userRepository.auth(data.getOrElse("username", ""), data.getOrElse("password", "")).map {
      case Some(value: User) =>
        Redirect(routes.MessagesController.chatHome())
          .withSession(Global.SESSION_USERNAME_KEY -> value.name)
      case None =>
        Redirect(routes.HomeController.index())
          .withNewSession.flashing("Login failed" -> "Invalid username or password combo, kindly register if you dont have an account already.")
    }
  }

  def register: Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    User.registerForm.bindFromRequest.fold(
      error => {
        Future.successful{
          BadRequest(views.html.register(error, routes.UserController.register() ))
            .withNewSession
            .flashing("Login failed" -> "Invalid username or password combo, kindly register if you dont have an account already.")
        }
      },
      success => {
        val user = User(name = success.name,title = success.title, password = success.password )
        userRepository.createUser(user).map {
          case Some(value) =>
            Redirect(routes.UserController.register()).withNewSession
              .flashing("Login failed" -> "user already exist, either log in or use another name")
          case None =>
            Redirect(routes.MessagesController.chatHome())
              .withSession(Global.SESSION_USERNAME_KEY -> success.name)
        }
      }
    )
  }

    def serveRegister: Action[AnyContent] = Action { implicit request: MessagesRequest[AnyContent] =>
    Ok(views.html.register(User.registerForm, routes.UserController.register() ))
  }
}
