package controllers

import com.google.inject.Inject
import play.api.mvc.Results._
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
class AuthAction @Inject() (parser: BodyParsers.Default)(implicit ec: ExecutionContext)
  extends ActionBuilderImpl(parser) {

  private val logger = play.api.Logger(this.getClass)

  override def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
    logger.info("Invoking user authentication::invokeBlock ...")
    val nameOption = request.session.get(models.Global.SESSION_USERNAME_KEY)
    nameOption match {
      case None => {
        Future.successful(Redirect(routes.HomeController.index())
          .withSession().flashing("Unauthorized user" -> "Please kindly login"))
      }
      case Some(u) => {
        val res: Future[Result] = block(request)
        res
      }
    }
  }
}