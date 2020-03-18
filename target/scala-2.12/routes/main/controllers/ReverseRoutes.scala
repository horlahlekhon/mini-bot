// @GENERATOR:play-routes-compiler
// @SOURCE:/home/lekan/Documents/workspace/personal_projects/MiniBot/conf/routes
// @DATE:Wed Mar 18 11:55:42 WAT 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:18
  class ReverseMessagesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def reply(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "chat/messages")
    }
  
    // @LINE:18
    def chatHome(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "chat/messages")
    }
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:24
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:8
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def serveRegister(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/register")
    }
  
    // @LINE:10
    def register(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users/register")
    }
  
    // @LINE:8
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users/login")
    }
  
  }


}
