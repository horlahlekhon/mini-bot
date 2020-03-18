package models

import javax.inject.Inject
import play.api.libs.json._
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.api.bson.Macros.Annotations.Key
import reactivemongo.bson.{BSONDocument, BSONObjectID, document}
import reactivemongo.play.json.collection.JSONCollection
import reactivemongo.api.{Cursor, ReadPreference}
import reactivemongo.play.json._
import reactivemongo.api.commands.WriteResult
import play.api.libs.json.{JsObject, Json}
import javax.inject.Inject
import play.api.data.Form
import play.api.data.Forms.mapping
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.bson.{BSONDocument, BSONObjectID}
import play.api.libs.json.{JsObject, Json}
import reactivemongo.api.bson.Macros.Annotations.Key
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.{ExecutionContext, Future}
import reactivemongo.api.{Cursor, ReadPreference}
import reactivemongo.api.commands.WriteResult
import reactivemongo.play.json._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

case class Response(@Key("_id") id: BSONObjectID = BSONObjectID.generate(), msg: String)

object ResponseFormat {
  implicit val responseFormat = Json.format[Response]
}

class ResponseRepo @Inject()(implicit ec: ExecutionContext, reactiveMongoApi: ReactiveMongoApi){

  import ResponseFormat._
  val responseCollection:  Future[JSONCollection] = reactiveMongoApi.database.map(_.collection("responses"))

  def create(resp: Response) = {
    responseCollection.flatMap(_.update(document("msg" -> resp.msg), resp, upsert = true))
  }

  def getAll() =  {
    responseCollection.flatMap {
      _.find(
        selector = Json.obj(),
        projection = Option.empty[JsObject])
        .cursor[Response](ReadPreference.primary)
        .collect[Seq](maxDocs = 100, err = Cursor.FailOnError[Seq[Response]]())
    }
  }
  def getResponse = {
    for {
      data <- getAll
      randomInt = Random.nextInt(data.length)
    }yield data.zipWithIndex.filter(e => e._2 == randomInt).head._1
  }
}
