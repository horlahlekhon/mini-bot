package controllers

import akka.actor.{ActorRef, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import javax.inject.{Inject, Singleton}
import models.{Message, MessageRepository, Response, ResponseRepo}
import play.api.Configuration
import play.api.data.Form
import play.api.data.Forms.single
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}
import services.MessageActor

import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future}
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
  val dataPath: Option[String] = configuration.getOptional[String]("dataPath")
  val random: Int = Random.nextInt(100)
  val responseActor: ActorRef = actorSystem.actorOf(MessageActor.props(dataPath, messageRepository,  responseRepo ), s"message-response-actor-$random")
  val messageForm: Form[String] = Form(
    single(
      "message" -> play.api.data.Forms.text
    )
  )

  def reply: Action[AnyContent] = authAction.async { implicit request: Request[AnyContent] =>
    import scala.concurrent.ExecutionContext.Implicits.global
    val data = messageForm.bindFromRequest.data.get("message")
    data match {
      case Some(value) =>
        val username = request.session.data.getOrElse("username", "")
        (responseActor ? MessageActor.GetMessage).mapTo[Response].map{e =>
          messageRepository.createMessage(Message(username = username, reply = e.msg, message = value))
          Redirect(routes.MessagesController.chatHome())
        }
      case None =>
        Future( Redirect(routes.MessagesController.chatHome()))
    }
  }

  def chatHome: Action[AnyContent] = authAction.async { implicit request: Request[AnyContent] =>
    import scala.concurrent.ExecutionContext.Implicits.global
    val user = request.session.data.getOrElse("username", "")
     messageRepository.getForUser(user) map { msgs =>
     Ok(views.html.messages(msgs, messageForm, routes.MessagesController.reply()))
   }

  }
}
