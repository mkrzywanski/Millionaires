package example

import org.scalajs.dom

import scalatags.JsDom.all._
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import dom.ext._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.control.Breaks._;

object ScalaJSExample extends js.JSApp {

  var currentLevel = 1;
  val winningValueSeq = Seq(500, 1000, 2000, 5000, 10000, 20000, 40000, 75000, 125000, 250000, 500000, 1000000);
  val chars = Seq("A", "B" , "C", "D");
  val host = "http://localhost:9000"
  var currentQuestion : js.Dynamic = _

  var isFiftyFiftyAvailable = true;
  var isQuestionToAudienceAvailable = true;
  var isQuestionToFriendAvailable = true;

  def main(): Unit = {
    dom.document.getElementById("pageContent").appendChild(
      div(
        createCurrentQuestionValueDiv,
        createQuestionDiv,
        createAnswerOneDiv,
        createAnswerTwoDiv,
        createAnswerThreeDiv,
        createAnswerFourDiv,
        br.render,
        br.render,
        createHintsRow
      ).render
    )

    this.donwloadNewQuestion;
  }

  def createCurrentQuestionValueDiv = {
    div(`class`:="col-md-12", `id` := "questionValue", p(`class`:= "text-center", `id` := "currentLevelWinnings", "Pytanie za " + winningValueSeq(currentLevel - 1) + " zł")).render
  }

  def createQuestionDiv = {
    div(`class`:="col-md-12", p(`class`:= "text-center",`id` := "question", "Question")).render
  }

  def createAnswerOneDiv = {
      div(`class`:="col-md-6", button(`class` :="btn-block btn btn-primary", `id` := "answer1", `onclick`:="answerOneClicked()", "Answer1")).render
  }
  def createAnswerTwoDiv = {
    div(`class`:="col-md-6", button(`class` :="btn-block btn btn-primary", `id` := "answer2", `onclick`:="answerTwoClicked()", "Answer2")).render
  }
  def createAnswerThreeDiv = {
    div(`class`:="col-md-6", button(`class` :="btn-block btn btn-primary", `id` := "answer3", `onclick`:="answerThreeClicked()", "Answer3")).render
  }
  def createAnswerFourDiv = {
    div(`class`:="col-md-6", button(`class` :="btn-block btn btn-primary", `id` := "answer4", `onclick`:="answerFourClicked()", "Answer4")).render
  }

  def createHintsRow = {
    div(
      div(`class`:="col-md-12", p(`class`:= "text-center", "Hints")),
      div(`class`:="col-md-4", button(`class`:="btn-block btn btn-info", `id`:= "hintHalfOnHalf", "50 : 50")),
      div(`class`:="col-md-4", button(`class`:="btn-block btn btn-info", `id`:= "hintAudience", `onclick`:="questionToAudience()", "Zapytaj publiczności")),
      div(`class`:="col-md-4", button(`class`:="btn-block btn btn-info", `id`:= "hintFriend", `onclick`:="questionToFriend()", "Ask a friend"))
    ).render
  }

  @JSExportTopLevel("answerOneClicked")
  def answerOneClicked(): Unit = {
    val id = currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](0).id.toString;
    checkAnswer(id);
  }

  @JSExportTopLevel("answerTwoClicked")
  def answerTwoClicked(): Unit = {
    val id = currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](1).id.toString;
    checkAnswer(id);
  }

  @JSExportTopLevel("answerThreeClicked")
  def answerThreeClicked(): Unit = {
    val id = currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](2).id.toString;
    checkAnswer(id);
  }

  @JSExportTopLevel("answerFourClicked")
  def answerFourClicked(): Unit = {
    val id = currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](3).id.toString;
    checkAnswer(id);
  }

  def checkAnswer(id: String) = {
    val url = host + "/answers/correct/" + id

    Ajax.get(url).onSuccess { case xhr =>
      if (xhr.status == 200) {
        val json = js.JSON.parse(
          xhr.responseText
        )
        if(json.isCorrect == true) {
          scala.scalajs.js.Dynamic.global.alert("Odpowiedź poprawna")
          currentLevel += 1;
          donwloadNewQuestion;
          updateLevelUI;
        } else {
          scala.scalajs.js.Dynamic.global.alert("Odpowiedź błędna")
        }
      }
    }
  }

  def donwloadNewQuestion = {
    val url = host + "/questions/random/" + currentLevel

    Ajax.get(url).onSuccess { case xhr =>
      if (xhr.status == 200) {
        val json = js.JSON.parse(
          xhr.responseText
        )
        currentQuestion = json;
        updateQuestionUI;
      }
    }
  }

  def updateQuestionUI = {
    dom.document.getElementById("question").innerHTML = currentQuestion.content.toString();
    dom.document.getElementById("answer1").textContent = "A : " + currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](0).content.toString;
    //dom.document.getElementById("answer1")[0].value = currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](0);
    dom.document.getElementById("answer2").textContent = "B : " + currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](1).content.toString;
    dom.document.getElementById("answer3").textContent = "C : " + currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](2).content.toString;
    dom.document.getElementById("answer4").textContent = "D : " + currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](3).content.toString;
  }

  def updateLevelUI = {
    dom.document.getElementById("currentLevelWinnings").innerHTML = "Pytanie za " + winningValueSeq(currentLevel - 1) + "zł";
  }

  @JSExportTopLevel("questionToAudience")
  def proceedQuestionToAudienceHint() = {
    val url = host + "/questions/audience/" + currentQuestion.id;

    Ajax.get(url).onSuccess { case xhr =>
      if (xhr.status == 200) {
        val json = js.JSON.parse(
          xhr.responseText
        )
        var message = "Wyniki publiczności :\n"
        for(i <- 0 to 3) {
          message +=  chars(i) + " : " + json.asInstanceOf[js.Array[js.Dynamic]](i).percentage + " %\n";
        }
        dom.document.getElementById("hintAudience").setAttribute("disabled", true.toString);
        scala.scalajs.js.Dynamic.global.alert(message);

      }
    }
  }

  @JSExportTopLevel("questionToFriend")
  def proceedQuestionToAFriend() = {
    val url = host + "/questions/toFriend/" + currentQuestion.id;

    Ajax.get(url).onSuccess { case xhr =>
      if (xhr.status == 200) {
        val json = js.JSON.parse(
          xhr.responseText
        )
        val correctAnswerIndex = findAnswerIndex(json.correctAnswerId.toString());
        scala.scalajs.js.Dynamic.global.alert(json.content + chars(correctAnswerIndex));
        dom.document.getElementById("hintFriend").setAttribute("disabled", true.toString);
      }
    }
  }

  def findAnswerIndex(answerId : String) : Int = {
    var index = 0;
    for(i <- 0 to 3) {
      if(currentQuestion.answers.asInstanceOf[js.Array[js.Dynamic]](i).id.toString == answerId.toString) {
        index = i;
        break;
      }
    }
    return index;
  }


}
