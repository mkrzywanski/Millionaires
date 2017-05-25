
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/michal/Pulpit/scala2017_02/server/conf/routes
// @DATE:Thu May 25 22:08:53 CEST 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:16
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def answers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.answers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "answers"})
        }
      """
    )
  
    // @LINE:7
    def hello: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.hello",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hello"})
        }
      """
    )
  
    // @LINE:12
    def chceckIfAnswerIsCorrect: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.chceckIfAnswerIsCorrect",
      """
        function(answerId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "answers/correct/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("answerId", answerId0)})
        }
      """
    )
  
    // @LINE:11
    def questionToAFriend: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.questionToAFriend",
      """
        function(questionId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "questions/toFriend/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("questionId", questionId0)})
        }
      """
    )
  
    // @LINE:13
    def questionForAudience: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.questionForAudience",
      """
        function(questionId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "questions/audience/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("questionId", questionId0)})
        }
      """
    )
  
    // @LINE:9
    def questions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.questions",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "questions"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:10
    def getRandomQuestionForLevel: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getRandomQuestionForLevel",
      """
        function(level0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "questions/random/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("level", level0)})
        }
      """
    )
  
  }


}
