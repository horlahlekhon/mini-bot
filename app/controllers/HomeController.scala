package controllers

import javax.inject._
import models.{User, UserRepository}
import play.api.mvc._



@Singleton
class HomeController @Inject()(c: MessagesControllerComponents, userRepository: UserRepository) extends MessagesAbstractController(c) {


  private val formSubmitUrl = routes.UserController.login

  def index: Action[AnyContent] = Action { implicit request: MessagesRequest[AnyContent] =>
    Ok(views.html.index(formSubmitUrl, User.loginForm))
  }

}
