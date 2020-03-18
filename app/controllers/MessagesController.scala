package controllers

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import javax.inject.{Inject, Singleton}
import models.{Message, MessageRepository, Response, ResponseRepo}
import play.api.data.Form
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, MessagesAbstractController, MessagesControllerComponents, MessagesRequest, Request}
import play.api.data.Form._
import play.api.data.Forms.{nonEmptyText, single}
import controllers.AuthAction
import play.api.Configuration
import play.mvc.Security.AuthenticatedAction
import services.MessageActor
import akka.pattern.ask
import akka.util.Timeout
import services.MessageActor._

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.duration._
import scala.util.Random

@Singleton
class MessagesController @Inject()(configuration: Configuration,
                                   cc: ControllerComponents,
                                   authAction: AuthAction,
                                   ec: ExecutionContext,
                                   messageRepository: MessageRepository,
                                   actorSystem: ActorSystem,
                                   responseRepo: ResponseRepo)
      extends AbstractController(cc) with play.api.i18n.I18nSupport{

  implicit val timeout: Timeout = 5.seconds
  val dataPath = configuration.getOptional[String]("dataPath")
  val random = Random.nextInt(100)
  val responseActor = actorSystem.actorOf(MessageActor.props(dataPath, messageRepository,  responseRepo ), s"message-response-actor-$random")
  val messageForm = Form(
    single(
      "message" -> nonEmptyText
    )
  )

  def reply = authAction.async { implicit request: Request[AnyContent] =>
    import scala.concurrent.ExecutionContext.Implicits.global
    val data = messageForm.bindFromRequest.data.get("message")
    data match {
      case Some(value) =>
        var username = request.session.data.get("username").getOrElse("")
        (responseActor ? MessageActor.GetMessage).mapTo[Response].map{e =>
          messageRepository.createMessage(Message(username = username, reply = e.msg, message = value))
          Redirect(routes.MessagesController.chatHome())
        }
      case None =>
        Future( Redirect(routes.MessagesController.chatHome()))
    }
  }

  def chatHome = authAction.async { implicit request: Request[AnyContent] =>
    import scala.concurrent.ExecutionContext.Implicits.global
    val user = request.session.data.getOrElse("username", "")
     messageRepository.getForUser(user) map { msgs =>
     Ok(views.html.messages(msgs, messageForm, routes.MessagesController.reply()))
   }

  }
}
