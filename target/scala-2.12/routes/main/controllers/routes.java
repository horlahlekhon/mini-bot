// @GENERATOR:play-routes-compiler
// @SOURCE:/home/lekan/Documents/workspace/personal_projects/MiniBot/conf/routes
// @DATE:Wed Mar 18 11:55:42 WAT 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseMessagesController MessagesController = new controllers.ReverseMessagesController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseMessagesController MessagesController = new controllers.javascript.ReverseMessagesController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
  }

}
