
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/scalaproj/scala2017_02/server/conf/routes
// @DATE:Sat Jun 10 23:47:33 CEST 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:17
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def versioned(file:Asset): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def eliminateTwoWrongAnswers(questionId:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "questions/eliminate/" + implicitly[PathBindable[Int]].unbind("questionId", questionId))
    }
  
    // @LINE:8
    def answers(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "answers")
    }
  
    // @LINE:7
    def hello(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "hello")
    }
  
    // @LINE:12
    def chceckIfAnswerIsCorrect(answerId:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "answers/correct/" + implicitly[PathBindable[Int]].unbind("answerId", answerId))
    }
  
    // @LINE:11
    def questionToAFriend(questionId:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "questions/toFriend/" + implicitly[PathBindable[Int]].unbind("questionId", questionId))
    }
  
    // @LINE:13
    def questionForAudience(questionId:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "questions/audience/" + implicitly[PathBindable[Int]].unbind("questionId", questionId))
    }
  
    // @LINE:9
    def questions(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "questions")
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:10
    def getRandomQuestionForLevel(level:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "questions/random/" + implicitly[PathBindable[Int]].unbind("level", level))
    }
  
  }


}
