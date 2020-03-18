package models

import javax.inject.Inject
import play.api.libs.json.{JsObject, Json, OFormat}
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.api.bson.Macros.Annotations.Key
import reactivemongo.api.commands.UpdateWriteResult
import reactivemongo.api.{Cursor, ReadPreference}
import reactivemongo.bson.{BSONObjectID, document}
import reactivemongo.play.json._
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

case class Response(@Key("_id") id: BSONObjectID = BSONObjectID.generate(), msg: String)

object ResponseFormat {
  implicit val responseFormat: OFormat[Response] = Json.format[Response]
}

class ResponseRepo @Inject()(implicit ec: ExecutionContext, reactiveMongoApi: ReactiveMongoApi){

  import ResponseFormat._
  val responseCollection:  Future[JSONCollection] = reactiveMongoApi.database.map(_.collection("responses"))

  def create(resp: Response): Future[UpdateWriteResult] = {
    responseCollection.flatMap(_.update(document("msg" -> resp.msg), resp, upsert = true))
  }

  def getAll: Future[Seq[Response]] =  {
    responseCollection.flatMap {
      _.find(
        selector = Json.obj(),
        projection = Option.empty[JsObject])
        .cursor[Response](ReadPreference.primary)
        .collect[Seq](maxDocs = 100, err = Cursor.FailOnError[Seq[Response]]())
    }
  }
  def getResponse: Future[Response] = {
    for {
      data <- getAll
      randomInt = Random.nextInt(data.length)
    }yield data.zipWithIndex.filter(e => e._2 == randomInt).head._1
  }
}
