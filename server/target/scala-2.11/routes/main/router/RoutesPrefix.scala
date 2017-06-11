
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/scalaproj/scala2017_02/server/conf/routes
// @DATE:Sat Jun 10 23:47:33 CEST 2017


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
