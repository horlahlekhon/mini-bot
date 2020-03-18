import akka.actor.ActorSystem
import akka.testkit.{TestKit, TestProbe}
import models.{MessageRepository, Response, ResponseRepo}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import services.MessageActor
import org.scalatest.mock.MockitoSugar
import services.MessageActor.GetMessage
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._


class MessageActorSpec extends TestKit(ActorSystem("message-response-actorsystem"))with WordSpecLike with Matchers with BeforeAndAfterAll
                                              with MockitoSugar {

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }
  implicit val timeout: Timeout = 5.seconds

  val messageRepository = mock[MessageRepository]
  val responseRepo = mock[ResponseRepo]
  val actor = system.actorOf(MessageActor.props(None, messageRepository, responseRepo), "message-response-actor")

  "MessageResponseActor " must {
    "return a messagresponse when a GetMessage is asked" in {
      import scala.concurrent.ExecutionContext.Implicits.global
      (actor ? GetMessage).mapTo[Response].map {
        _ should be theSameInstanceAs(Response)
      }
    }
  }


}
