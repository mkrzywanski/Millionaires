
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/michal/Pulpit/scala2017_02/server/conf/routes
// @DATE:Thu May 25 22:08:53 CEST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_1: controllers.Application,
  // @LINE:16
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_1: controllers.Application,
    // @LINE:16
    Assets_0: controllers.Assets
  ) = this(errorHandler, Application_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hello""", """controllers.Application.hello"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """answers""", """controllers.Application.answers"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """questions""", """controllers.Application.questions"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """questions/random/""" + "$" + """level<[^/]+>""", """controllers.Application.getRandomQuestionForLevel(level:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """questions/toFriend/""" + "$" + """questionId<[^/]+>""", """controllers.Application.questionToAFriend(questionId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """answers/correct/""" + "$" + """answerId<[^/]+>""", """controllers.Application.chceckIfAnswerIsCorrect(answerId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """questions/audience/""" + "$" + """questionId<[^/]+>""", """controllers.Application.questionForAudience(questionId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_hello1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hello")))
  )
  private[this] lazy val controllers_Application_hello1_invoker = createInvoker(
    Application_1.hello,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "hello",
      Nil,
      "GET",
      """""",
      this.prefix + """hello"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_answers2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("answers")))
  )
  private[this] lazy val controllers_Application_answers2_invoker = createInvoker(
    Application_1.answers,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "answers",
      Nil,
      "GET",
      """""",
      this.prefix + """answers"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_questions3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("questions")))
  )
  private[this] lazy val controllers_Application_questions3_invoker = createInvoker(
    Application_1.questions,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "questions",
      Nil,
      "GET",
      """""",
      this.prefix + """questions"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_getRandomQuestionForLevel4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("questions/random/"), DynamicPart("level", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getRandomQuestionForLevel4_invoker = createInvoker(
    Application_1.getRandomQuestionForLevel(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getRandomQuestionForLevel",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """questions/random/""" + "$" + """level<[^/]+>"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_questionToAFriend5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("questions/toFriend/"), DynamicPart("questionId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_questionToAFriend5_invoker = createInvoker(
    Application_1.questionToAFriend(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "questionToAFriend",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """questions/toFriend/""" + "$" + """questionId<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Application_chceckIfAnswerIsCorrect6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("answers/correct/"), DynamicPart("answerId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_chceckIfAnswerIsCorrect6_invoker = createInvoker(
    Application_1.chceckIfAnswerIsCorrect(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "chceckIfAnswerIsCorrect",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """answers/correct/""" + "$" + """answerId<[^/]+>"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Application_questionForAudience7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("questions/audience/"), DynamicPart("questionId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_questionForAudience7_invoker = createInvoker(
    Application_1.questionForAudience(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "questionForAudience",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """questions/audience/""" + "$" + """questionId<[^/]+>"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Assets_versioned8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned8_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_1.index)
      }
  
    // @LINE:7
    case controllers_Application_hello1_route(params) =>
      call { 
        controllers_Application_hello1_invoker.call(Application_1.hello)
      }
  
    // @LINE:8
    case controllers_Application_answers2_route(params) =>
      call { 
        controllers_Application_answers2_invoker.call(Application_1.answers)
      }
  
    // @LINE:9
    case controllers_Application_questions3_route(params) =>
      call { 
        controllers_Application_questions3_invoker.call(Application_1.questions)
      }
  
    // @LINE:10
    case controllers_Application_getRandomQuestionForLevel4_route(params) =>
      call(params.fromPath[Int]("level", None)) { (level) =>
        controllers_Application_getRandomQuestionForLevel4_invoker.call(Application_1.getRandomQuestionForLevel(level))
      }
  
    // @LINE:11
    case controllers_Application_questionToAFriend5_route(params) =>
      call(params.fromPath[Int]("questionId", None)) { (questionId) =>
        controllers_Application_questionToAFriend5_invoker.call(Application_1.questionToAFriend(questionId))
      }
  
    // @LINE:12
    case controllers_Application_chceckIfAnswerIsCorrect6_route(params) =>
      call(params.fromPath[Int]("answerId", None)) { (answerId) =>
        controllers_Application_chceckIfAnswerIsCorrect6_invoker.call(Application_1.chceckIfAnswerIsCorrect(answerId))
      }
  
    // @LINE:13
    case controllers_Application_questionForAudience7_route(params) =>
      call(params.fromPath[Int]("questionId", None)) { (questionId) =>
        controllers_Application_questionForAudience7_invoker.call(Application_1.questionForAudience(questionId))
      }
  
    // @LINE:16
    case controllers_Assets_versioned8_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned8_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
