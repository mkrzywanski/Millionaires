package example

import org.scalajs.dom

import scalatags.JsDom.all._
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import dom.ext._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.control.Breaks._
import org.scalajs.dom.html._;

object ScalaJSExample extends js.JSApp {

  var currentLevel = 1
  val winningValueSeq = Seq(500, 1000, 2000, 5000, 10000, 20000, 40000, 75000, 125000, 250000, 500000, 1000000)
  val chars = Seq("A", "B" , "C", "D")
  val host = "http://localhost:9000"
  var currentQuestion : js.Dynamic = _

  def main(): Unit = {
    dom.document.getElementById("pageContent").appendChild(
      div(
        createCurrentQuestionValueDiv(),
        createQuestionDiv(),
        createAnswerOneDiv(),
        createAnswerTwoDiv(),
        createAnswerThreeDiv(),
        createAnswerFourDiv(),
        br.render,
        br.render,
        createHintsRow()
      ).render
    )

    this.donwloadNewQuestion()
  }

  def createCurrentQuestionValueDiv() : Div = {
    div(`class`:="col-md-12", `id` := "questionValue", p(`class`:= "text-center", `id` := "currentLevelWinnings", "Pytanie za " + winningValueSeq(currentLevel - 1) + " zł")).render
  }

  def createQuestionDiv() : Div = {
    div(`class`:="col-md-12", p(`class`:= "text-center",`id` := "question", "Question")).render
  }

  def createAnswerOneDiv() : Div = {
      div(`class`:="col-md-6", button(`class` :="btn-block btn btn-primary", `id` := "answer1", `onclick`:="answerOneClicked()", "Answer1")).render
  }
  def createAnswerTwoDiv() : Div = {
    div(`class`:="col-md-6", button(`class` :="btn-block btn btn-primary", `id` := "answer2", `onclick`:="answerTwoClicked()", "Answer2")).render
  }
  def createAnswerThreeDiv() : Div = {
    div(`class`:="col-md-6", button(`class` :="btn-block btn btn-primary", `id` := "answer3", `onclick`:="answerThreeClicked()", "Answer3")).render
  }
  def createAnswerFourDiv() : Div = {
    div(`class`:="col-md-6", button(`class` :="btn-block btn btn-primary", `id` := "answer4", `onclick`:="answerFourClicked()", "Answer4")).render
  }

  def createHintsRow() : Div = {
    div(
      div(`class`:="col-md-12", p(`class`:= "text-center", "Koła Ratunkowe")),
      div(`class`:="col-md-4", button(`class`:="btn-block btn btn-info", `id`:= "hintFiftyFifty", `onclick`:= "fiftyFiftyHint()", "50 : 50")),
      div(`class`:="col-md-4", button(`class`:="btn-block btn btn-info", `id`:= "hintAudience", `onclick`:="questionToAudience()", "Zapytaj publiczności")),
      div(`class`:="col-md-4", button(`class`:="btn-block btn btn-info", `id`:= "hintFriend", `onclick`:="questionToFriend()", "Ask a friend"))
    ).render
  }

  @JSExportTopLevel("answerOneClicked")
  def answerOneClicked(): Unit = {
    val id = currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](0).id.toString
    checkAnswer(id)
  }

  @JSExportTopLevel("answerTwoClicked")
  def answerTwoClicked(): Unit = {
    val id = currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](1).id.toString
    checkAnswer(id)
  }

  @JSExportTopLevel("answerThreeClicked")
  def answerThreeClicked(): Unit = {
    val id = currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](2).id.toString
    checkAnswer(id)
  }

  @JSExportTopLevel("answerFourClicked")
  def answerFourClicked(): Unit = {
    val id = currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](3).id.toString
    checkAnswer(id)
  }

  def checkAnswer(id: String) : Unit = {
    val url = host + "/answers/correct/" + id

    Ajax.get(url).onSuccess { case xhr =>
      if (xhr.status == 200) {
        val json = js.JSON.parse(
          xhr.responseText
        )
        if(json.isCorrect == true) {
          scala.scalajs.js.Dynamic.global.alert("Odpowiedź poprawna")
          if(currentLevel < 12) {
            currentLevel += 1
            donwloadNewQuestion()
            updateLevelUI()
          } else {
            scala.scalajs.js.Dynamic.global.alert("Wygrałeś milion! Restart gry.")
            dom.window.location.reload()
          }
        } else {
          if(currentLevel == 1)
            scala.scalajs.js.Dynamic.global.alert("Odpowiedź błędna. Przegrałeś. Twoja wygrana to: 0")
          else
            scala.scalajs.js.Dynamic.global.alert("Odpowiedź błędna. Przegrałeś. Twoja wygrana to: " + winningValueSeq(currentLevel - 2))
          dom.window.location.reload()
        }
      }
    }
  }

  def donwloadNewQuestion() : Unit = {
    val url = host + "/questions/random/" + currentLevel

    Ajax.get(url).onSuccess { case xhr =>
      if (xhr.status == 200) {
        val json = js.JSON.parse(
          xhr.responseText
        )
        currentQuestion = json
        updateQuestionUI()
      }
    }
  }

  def updateQuestionUI() : Unit = {
    dom.document.getElementById("question").innerHTML = currentQuestion.content.toString

    for(i <- 0 to 3) {
      dom.document.getElementById("answer" + (i + 1)).textContent = chars(i) + " : " + currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](i).content.toString;
      dom.document.getElementById("answer" + (i + 1)).removeAttribute("disabled")
    }
  }

  def updateLevelUI() : Unit = {
    dom.document.getElementById("currentLevelWinnings").innerHTML = "Pytanie za " + winningValueSeq(currentLevel - 1) + "zł"
  }

  @JSExportTopLevel("questionToAudience")
  def proceedQuestionToAudienceHint() : Unit = {
    val url = host + "/questions/audience/" + currentQuestion.id

    Ajax.get(url).onSuccess { case xhr =>
      if (xhr.status == 200) {
        val json = js.JSON.parse(
          xhr.responseText
        )
        var message = "Wyniki publiczności :\n"
        for(i <- 0 to 3) {
          message +=  chars(i) + " : " + json.asInstanceOf[js.Array[js.Dynamic]](i).percentage + " %\n"
        }
        dom.document.getElementById("hintAudience").setAttribute("disabled", true.toString)
        scala.scalajs.js.Dynamic.global.alert(message)

      }
    }
  }

  @JSExportTopLevel("questionToFriend")
  def proceedQuestionToAFriend() : Unit = {
    val url = host + "/questions/toFriend/" + currentQuestion.id

    Ajax.get(url).onSuccess { case xhr =>
      if (xhr.status == 200) {
        val json = js.JSON.parse(
          xhr.responseText
        )
        val correctAnswerIndex = findAnswerIndex(json.answerId.toString)
        scala.scalajs.js.Dynamic.global.alert(json.content + " " + chars(correctAnswerIndex))
        dom.document.getElementById("hintFriend").setAttribute("disabled", true.toString)
      }
    }
  }

  def findAnswerIndex(answerId : String) : Int = {
    var index = 0
    for(i <- 0 to 3) {
      if(currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](i).id.toString == answerId) {
        index = i
        //break; tu pytanie - jeżeli dojdzie do trójki to rzuca wyjątek
      }
    }
    index
  }

  @JSExportTopLevel("fiftyFiftyHint")
  def proceedFiftyFiftyHint() : Unit = {
    val url = host + "/questions/eliminate/" + currentQuestion.id

    Ajax.get(url).onSuccess { case xhr =>
      if (xhr.status == 200) {
        val json = js.JSON.parse(
          xhr.responseText
        )
        val firstAnswerIndex = findAnswerIndex(json.asInstanceOf[js.Array[js.Dynamic]](0).id.toString())
        disableAnswerButton(firstAnswerIndex)
        val secondAnswerIndex = findAnswerIndex(json.asInstanceOf[js.Array[js.Dynamic]](1).id.toString())
        disableAnswerButton(secondAnswerIndex)
        dom.document.getElementById("hintFiftyFifty").setAttribute("disabled", true.toString)
      }
    }
  }

  def disableAnswerButton(buttonIndex: Int) : Unit = {
    dom.document.getElementById("answer" + (buttonIndex+1)).setAttribute("disabled", true.toString)
    dom.document.getElementById("answer" + (buttonIndex+1)).textContent = "-----------"
  }


}
