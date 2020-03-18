
import akka.actor.ActorSystem
import controllers.AuthAction
import models.{MessageRepository, ResponseRepo, UserRepository}
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.Configuration
import play.api.inject.guice.GuiceApplicationBuilder
import play.modules.reactivemongo.ReactiveMongoApi

import scala.concurrent.ExecutionContext

trait TestSpec extends PlaySpec with GuiceOneAppPerSuite  {

  override def fakeApplication = new GuiceApplicationBuilder()
    .configure(
      "mongodb.uri" -> "mongodb://localhost:27017/minibot-test"
    )
    .build()

  implicit def  reactiveMongoApi = app.injector.instanceOf[ReactiveMongoApi]


  val authAction = app.injector.instanceOf[AuthAction]
  val system = app.injector.instanceOf[ActorSystem]
  val ex = app.injector.instanceOf[ExecutionContext]
  implicit val ec = ex
  val configuration = app.injector.instanceOf[Configuration]
  def  userRepository = new UserRepository()
  def responseRepo = new ResponseRepo()
  def messageRepo = new MessageRepository()

}
