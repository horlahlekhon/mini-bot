package models
import javax.inject.Inject
import play.api.libs.json._
import reactivemongo.api.ReadPreference
import reactivemongo.api.bson.Macros.Annotations.Key
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.api.Cursor
import reactivemongo.api.commands.WriteResult
import reactivemongo.bson.{BSONDocument, BSONObjectID, document}
import reactivemongo.play.json._
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.{ExecutionContext, Future}

case class Message(message: String, @Key("_id") id: BSONObjectID = BSONObjectID.generate(), username: String, reply: String)

object MessageFormat {

  implicit val messageFormat: OFormat[Message] = Json.format[Message]
}

class MessageRepository @Inject()(implicit ec: ExecutionContext, reactiveMongoApi: ReactiveMongoApi){

  import MessageFormat._

  val messageCollection: Future[JSONCollection] = reactiveMongoApi.database.map(_.collection("message"))

  def createMessage(message: Message): Future[WriteResult] =
    messageCollection.flatMap(_.insert(ordered = false).one(message))

  def getMessage(id: BSONObjectID): Future[Option[Message]] =
  messageCollection.flatMap(_.find(
    selector = BSONDocument("_id" -> id),
    projection = Option.empty[BSONDocument])
    .one[Message])

  def getAllMessages: Future[Seq[Message]] = {
    messageCollection.flatMap {
      _.find(
        selector = Json.obj(),
        projection = Option.empty[JsObject])
        .cursor[Message](ReadPreference.primary)
        .collect[Seq](maxDocs = 100, err = Cursor.FailOnError[Seq[Message]]())
    }
  }

  def getForUser(username: String): Future[List[Message]] = {
    messageCollection.flatMap(_.find(
      document("username" -> username))
        .cursor[Message]()
        .collect[List](maxDocs = 100, Cursor.FailOnError[List[Message]]())
    )
  }
}




