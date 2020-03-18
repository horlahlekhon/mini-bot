// @GENERATOR:play-routes-compiler
// @SOURCE:/home/lekan/Documents/workspace/personal_projects/MiniBot/conf/routes
// @DATE:Wed Mar 18 11:55:42 WAT 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_2: controllers.HomeController,
  // @LINE:8
  UserController_3: controllers.UserController,
  // @LINE:18
  MessagesController_0: controllers.MessagesController,
  // @LINE:24
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_2: controllers.HomeController,
    // @LINE:8
    UserController_3: controllers.UserController,
    // @LINE:18
    MessagesController_0: controllers.MessagesController,
    // @LINE:24
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_2, UserController_3, MessagesController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_2, UserController_3, MessagesController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/login""", """controllers.UserController.login"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/register""", """controllers.UserController.serveRegister"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/register""", """controllers.UserController.register"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chat/messages""", """controllers.MessagesController.chatHome"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chat/messages""", """controllers.MessagesController.reply"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_2.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_UserController_login1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/login")))
  )
  private[this] lazy val controllers_UserController_login1_invoker = createInvoker(
    UserController_3.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "login",
      Nil,
      "POST",
      this.prefix + """users/login""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_UserController_serveRegister2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/register")))
  )
  private[this] lazy val controllers_UserController_serveRegister2_invoker = createInvoker(
    UserController_3.serveRegister,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "serveRegister",
      Nil,
      "GET",
      this.prefix + """users/register""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_UserController_register3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/register")))
  )
  private[this] lazy val controllers_UserController_register3_invoker = createInvoker(
    UserController_3.register,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "register",
      Nil,
      "POST",
      this.prefix + """users/register""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_MessagesController_chatHome4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chat/messages")))
  )
  private[this] lazy val controllers_MessagesController_chatHome4_invoker = createInvoker(
    MessagesController_0.chatHome,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesController",
      "chatHome",
      Nil,
      "GET",
      this.prefix + """chat/messages""",
      """POST /users/messages/               controllers""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_MessagesController_reply5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chat/messages")))
  )
  private[this] lazy val controllers_MessagesController_reply5_invoker = createInvoker(
    MessagesController_0.reply,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesController",
      "reply",
      Nil,
      "POST",
      this.prefix + """chat/messages""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_2.index)
      }
  
    // @LINE:8
    case controllers_UserController_login1_route(params@_) =>
      call { 
        controllers_UserController_login1_invoker.call(UserController_3.login)
      }
  
    // @LINE:9
    case controllers_UserController_serveRegister2_route(params@_) =>
      call { 
        controllers_UserController_serveRegister2_invoker.call(UserController_3.serveRegister)
      }
  
    // @LINE:10
    case controllers_UserController_register3_route(params@_) =>
      call { 
        controllers_UserController_register3_invoker.call(UserController_3.register)
      }
  
    // @LINE:18
    case controllers_MessagesController_chatHome4_route(params@_) =>
      call { 
        controllers_MessagesController_chatHome4_invoker.call(MessagesController_0.chatHome)
      }
  
    // @LINE:19
    case controllers_MessagesController_reply5_route(params@_) =>
      call { 
        controllers_MessagesController_reply5_invoker.call(MessagesController_0.reply)
      }
  
    // @LINE:24
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
