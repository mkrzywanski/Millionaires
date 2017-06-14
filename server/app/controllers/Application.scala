package controllers

import javax.inject.Inject

import service.protocols.MyJsonProtocol._
import persistance.model.QuestionWithAnswers
import play.api.mvc.{Action, Controller}
import service.QuestionService
import service.jsonmodels.{AnswerAudiencePercentageJsonModel, AnswerCorrectJsonModel, QuestionToFriendJsonModel}
import shared.SharedMessages
import shared.Utils
import spray.json._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Random


class Application @Inject()(questionService: QuestionService) extends Controller {

  private val sessionInvalidText : String = "Session is invalid";

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
      .withSession("question1" -> "false",
        "question2" -> "false",
        "question3" -> "false",
        "question4" -> "false",
        "question5" -> "false",
        "question6" -> "false",
        "question7" -> "false",
        "question8" -> "false",
        "question9" -> "false",
        "question10" -> "false",
        "question11" -> "false",
        "question12" -> "false",
        "friendHint" -> "false",
        "audienceHint" -> "false",
        "fiftyFiftyHint" -> "false");
  }

  def hello = Action {
    Ok("hello")
  }

  def answers = Action.async { implicit request =>
    val answers = questionService.listAllAnswers;
    answers.map { answersSeq =>
      Ok(answersSeq.toJson.compactPrint)
    }
  }

  def questions = Action.async { implicit request =>
    val questionss = questionService.listAll;
    questionss.map { q =>
      val q2 = q.map{ case (question, answersList) => QuestionWithAnswers(question.id, question.content, question.level, answersList) }
      Ok(q2.toJson.compactPrint)
    }
  }

  def getRandomQuestionForLevel(level: Int) = Action.async { implicit request =>
    request.session.get("question" + level).map { questionForLevel =>
      if(questionForLevel == "true") {
         Future.successful(Forbidden("Question already sent"))
      } else {
        val randomQuestion = questionService.getRandomQuestionForLevel(level);

        randomQuestion.map { q =>
          val index = Utils.getRandomNumber(0, q.size - 1)
          val q2 = q.map{ case (question, answersList) => QuestionWithAnswers(question.id, question.content, question.level, answersList) }
          Ok(q2(index).toJson.compactPrint).withSession(request.session + ("question" + level -> "true"))
        }
      }
    }.getOrElse {
      Future.successful(Forbidden(sessionInvalidText))
    }
  }

  def chceckIfAnswerIsCorrect(answerId : Int) = Action.async { implicit request =>
    val result = questionService.checkIfAnswerIsCorrect(answerId)

    result.map { r =>
      Ok(AnswerCorrectJsonModel(r.isCorrect).toJson.compactPrint)
    }
  }

  def questionToAFriend(questionId : Int) = Action.async { implicit request =>
    request.session.get("friendHint").map { friendHint =>
      if(friendHint == "true") {
        Future.successful(Forbidden("Question to a friend already used"))
      } else {
        val correctAnswer = questionService.getCorrectAnswerForQuestion(questionId)

        correctAnswer.map { r =>
          Ok(QuestionToFriendJsonModel("Myślę, że odpowiedź to", r.id).toJson.compactPrint).withSession(request.session + ("friendHint" -> "true"))
        }
      }
    } getOrElse {
      Future.successful(Forbidden(sessionInvalidText))
    }
  }

  def eliminateTwoWrongAnswers(questionId : Int) = Action.async { implicit request =>
    request.session.get("fiftyFiftyHint").map {fiftyFiftyHint =>
      if(fiftyFiftyHint == "true") {
        Future.successful(Forbidden("Fifty fifty hint already used"))
      } else {
        val answers = questionService.getAllAnswersForQuestion(questionId)

        answers.map { r =>
          val wrongAnswerSeq = r.filter(i => i.isCorrect == false)
          val randomSeq = Random.shuffle(wrongAnswerSeq.toList)
          Ok(randomSeq.take(2).toJson.compactPrint).withSession(request.session + ("fiftyFiftyHint" -> "true"))
        }
      }
    } getOrElse {
      Future.successful(Forbidden(sessionInvalidText))
    }
  }

  def questionForAudience(questionId : Int) = Action.async { implicit request =>
    request.session.get("audienceHint").map { audienceHint =>
      if(audienceHint == "true") {
        Future.successful(Forbidden("Question for audience already used"))
      } else {
        val answers = questionService.getAllAnswersForQuestion(questionId)

        answers.map { r =>
          this.synchronized {
            var audienceAnswerPercentageSeq = scala.collection.mutable.ArraySeq.empty[AnswerAudiencePercentageJsonModel]
            var percentage = 80
            r.foreach { answer =>
              var percentageForAnswer = Utils.getRandomNumber(0, percentage)
              percentage -= percentageForAnswer
              if (answer.isCorrect) {
                percentageForAnswer += 20
              }

              audienceAnswerPercentageSeq = audienceAnswerPercentageSeq :+ AnswerAudiencePercentageJsonModel(answer.id, percentageForAnswer)
            }

            val amountToAdd = questionService.checkPercentagesIsUnderOneHundred(audienceAnswerPercentageSeq)
            val indexOfSeqToAddDifference = Utils.getRandomNumber(0, audienceAnswerPercentageSeq.size - 1)
            val percents = audienceAnswerPercentageSeq(indexOfSeqToAddDifference).percentage;
            audienceAnswerPercentageSeq(indexOfSeqToAddDifference) = audienceAnswerPercentageSeq(indexOfSeqToAddDifference).copy(percentage = percents + amountToAdd)
            Ok(audienceAnswerPercentageSeq.toSeq.toJson.compactPrint).withSession(request.session + ("audienceHint" -> "true"))
          }
        }
      }
  } getOrElse {
      Future.successful(Forbidden(sessionInvalidText))
    }
  }
}
