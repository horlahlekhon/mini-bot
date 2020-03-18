package services

import akka.actor.{Actor, Props}
import akka.stream.Materializer
import models.{Message, MessageRepository, Response, ResponseRepo}
import services.MessageActor.{GetMessage, LoadResponse}

import scala.io.Source
import scala.reflect.io.File


object MessageActor {
  case object GetMessage
  case class LoadResponse(msg: String)

  def props(messagesFile: Option[String], messageRepo: MessageRepository, responseRepo: ResponseRepo): Props = Props(new MessageActor(messagesFile, messageRepo, responseRepo))
}

class MessageActor(messagesFile: Option[String], messageRepo: MessageRepository, responseRepo: ResponseRepo) extends Actor {


  override def preStart(): Unit = {
    super.preStart()

    println(s" Messages Actor Starting -> Loading response data to database from file $messagesFile")
    messagesFile match {
      case Some(value) =>
        val source = Source.fromFile(value)
       for(data <- source.getLines()){
         self ! LoadResponse(data.trim)
       }
        source.close()
      case _ =>
        ()
    }
  }

  override def receive: Receive = {
    case msg :LoadResponse =>
      responseRepo.create(Response(msg = msg.msg))
    case GetMessage =>
      import scala.concurrent.ExecutionContext.Implicits.global
      val replyTo = sender()
     responseRepo.getResponse.foreach(replyTo ! _)
  }



}
