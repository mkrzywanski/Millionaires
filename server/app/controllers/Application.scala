package controllers

import javax.inject.Inject

import persistance.protocols.MyJsonProtocol._
import persistance.model.{AnswerAudiencePercentage, AnswerCorrectness, QuestionToFriend, QuestionWithAnswers}
import play.api.mvc.{Action, Controller}
import service.{AnswerService, QuestionService}
import shared.SharedMessages
import shared.Utils
import spray.json._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Random


class Application @Inject()(answerService: AnswerService, questionService: QuestionService) extends Controller {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }

  def hello = Action {
    Ok("hello")
  }

  def answers = Action.async { implicit request =>
    val answers = answerService.listAll;
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

  def getRandomQuestionForLevel(level: Int) = Action.async {
    val randomQuestion = questionService.getRandomQuestionForLevel(level);

    randomQuestion.map { q =>
      val index = Utils.getRandomNumber(0, q.size - 1)
      val q2 = q.map{ case (question, answersList) => QuestionWithAnswers(question.id, question.content, question.level, answersList) }
      Ok(q2(index).toJson.compactPrint)
    }
  }

  def chceckIfAnswerIsCorrect(answerId : Int) = Action.async {
    val result = questionService.checkIfAnswerIsCorrect(answerId);

    result.map { r =>
      Ok(AnswerCorrectness(r.isCorrect).toJson.compactPrint)
    }
  }

  def questionToAFriend(questionId : Int) = Action.async {
    val correctAnswer = questionService.getCorrectAnswerForQuestion(questionId);

    correctAnswer.map { r =>
      Ok(QuestionToFriend("Myślę, że odpowiedź to", r.id).toJson.compactPrint)
    }
  }

  def eliminateTwoWrongAnswers(questionId : Int) = Action.async {
    val answers = questionService.getAllAnswersForQuestion(questionId);

    answers.map { r =>
      val wrongAnswerSeq = r.filter(i => i.isCorrect == false);
      val randomSeq = Random.shuffle(wrongAnswerSeq.toList);
      Ok(randomSeq.take(2).toJson.compactPrint)
    }
  }

  def questionForAudience(questionId : Int) = Action.async {
    val answers = questionService.getAllAnswersForQuestion(questionId);

    answers.map { r =>
      var audienceAnswerPercentageSeq = Seq.empty[AnswerAudiencePercentage];
      var percentage = 80;
      r.foreach{ answer =>
        var percentageForAnswer = Utils.getRandomNumber(0, percentage);
        percentage -= percentageForAnswer;
        if(answer.isCorrect == true) {
          percentageForAnswer += 20;
        }

        audienceAnswerPercentageSeq = audienceAnswerPercentageSeq :+ AnswerAudiencePercentage(answer.id, percentageForAnswer);
      }

      val amountToAdd = questionService.checkPercentagesIsUnderOneHundred(audienceAnswerPercentageSeq);
      val indexOfSeqToAddDifference = Utils.getRandomNumber(0, audienceAnswerPercentageSeq.size - 1);
      audienceAnswerPercentageSeq(indexOfSeqToAddDifference).percentage += amountToAdd;
      Ok(audienceAnswerPercentageSeq.toJson.compactPrint)

    }
  }
}
