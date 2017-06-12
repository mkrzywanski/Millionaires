/**
  * Created by kaima_000 on 2017-06-10.
  */

import javax.inject.Inject

import com.google.inject.Guice
import org.scalatest._
import persistance.model.{Answer, Question, QuestionWithAnswers}
import service.QuestionService
import shared.Utils
import spray.json._
import org.scalactic.TypeCheckedTripleEquals._
import org.scalatest.concurrent.ScalaFutures
import service.jsonmodels.AnswerAudiencePercentageJsonModel

import scala.collection.mutable
import scala.concurrent.Future
import scala.reflect.ClassTag
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scalaz._
import scalaz.Alpha.T

object Inject {
  lazy val injector = Guice.createInjector()

  def apply[T <: AnyRef](implicit m: ClassTag[T]): T =
    injector.getInstance(m.runtimeClass).asInstanceOf[T]
}

class ServerQuestionServiceTests extends FlatSpec with ScalaFutures with Matchers{
  lazy val questionService: QuestionService = Inject[QuestionService]

  "QuestionService" should "return a question" in {
    val returned = questionService.getRandomQuestionForLevel(1)
    Await.ready(returned,5000 millis)
    whenReady(returned){ q =>
      val index = Utils.getRandomNumber(0, q.size - 1)
      val q2 = q.map{ case (question, answersList) => QuestionWithAnswers(question.id, question.content, question.level, answersList) }
      q2(index).answers should have size 4
    }
    returned shouldBe a [Future[Seq[(Question,Seq[Answer])]]]
    returned should not be null
  }

  it should "return all answers" in{
    val returned = questionService.listAllAnswers
    whenReady(returned){ q => {
      assert(q.size >= 4)
      q shouldBe a [Seq[Answer]]
    }
    }
  }

  it should "return all" in {
    val returned = questionService.listAll
    whenReady(returned){
      returned shouldBe a [Future[Seq[Answer]]]
      returned should not be null
      q => {assert(q.size >= 1)}
    }
  }

  it should "check that answer is correct" in{
    val returned = questionService.checkIfAnswerIsCorrect(1)
    whenReady(returned){
      q => q shouldBe a [Answer]
        returned should not be null
    }
  }

  it should "give correct answer for a question" in{
    val returned = questionService.getCorrectAnswerForQuestion(1)
    whenReady(returned){
      returned shouldBe a [Future[Answer]]
      returned should not be null
      q => q.isCorrect shouldBe true
    }
  }

  it should "return all answers for specific question" in {
    val returned = questionService.getAllAnswersForQuestion(1)
    whenReady(returned){
      q => q.size shouldBe 4
        q.foreach(ques => ques.questionId shouldBe 1)
    }
  }

  it should "check that sum of percentages is correct" in{
    val seqAns: Seq[AnswerAudiencePercentageJsonModel] = Seq(AnswerAudiencePercentageJsonModel(1,25),AnswerAudiencePercentageJsonModel(2,15),AnswerAudiencePercentageJsonModel(3,15),AnswerAudiencePercentageJsonModel(4,15))
    val returned = questionService.checkPercentagesIsUnderOneHundred(seqAns)
    returned shouldBe 30
  }
}