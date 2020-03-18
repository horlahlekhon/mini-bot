package controllers

import javax.inject._
import models.{Global, User, UserRepository}
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.mvc._
import views.html.helper.form
import play.api.data.Forms._

import scala.concurrent.{ExecutionContext, Future}


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(c: MessagesControllerComponents, userRepository: UserRepository) extends MessagesAbstractController(c) {



  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  private val formSubmitUrl = routes.UserController.login

  def index = Action { implicit request: MessagesRequest[AnyContent] =>
    Ok(views.html.index(formSubmitUrl, User.loginForm))
  }

}
