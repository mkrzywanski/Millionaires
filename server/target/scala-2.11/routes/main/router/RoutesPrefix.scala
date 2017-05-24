
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/michal/Pulpit/scala2017_02/server/conf/routes
// @DATE:Wed May 24 16:51:34 CEST 2017


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
