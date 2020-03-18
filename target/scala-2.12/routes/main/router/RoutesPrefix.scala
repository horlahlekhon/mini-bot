// @GENERATOR:play-routes-compiler
// @SOURCE:/home/lekan/Documents/workspace/personal_projects/MiniBot/conf/routes
// @DATE:Wed Mar 18 11:55:42 WAT 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
