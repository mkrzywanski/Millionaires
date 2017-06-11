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

class ServerQuestionServiceTests extends FlatSpec with Matchers{
  lazy val questionService: QuestionService = Inject[QuestionService]

  "QuestionService" should "return a question" in {
    val returned = questionService.getRandomQuestionForLevel(1)
    Await.result(returned, 5000 millis);

    returned.map { q => println(q.toString())
      val index = Utils.getRandomNumber(0, q.size - 1)
      val q2 = q.map{ case (question, answersList) => QuestionWithAnswers(question.id, question.content, question.level, answersList) }
      q2(index).answers should have size 2
    }
    returned shouldBe a [Future[Seq[(Question,Seq[Answer])]]]
    returned should not be null
  }

  it should "return all answers" in{
    val returned = questionService.listAllAnswers
    Await.result(returned, 5000 millis);

    returned.map { q => println(q.toString())
      q should be ("hi")
      q.getClass.toString shouldBe "Int"
      q should have size 4
    }
    returned shouldBe a [Future[Seq[Answer]]]
    returned should not be null
  }
}

