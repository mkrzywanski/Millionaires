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
import org.scalatest.exceptions.TestFailedException
import persistance.tabledefinitions.{AnswerTableDef, QuestionTableDef}
import service.jsonmodels.AnswerAudiencePercentageJsonModel
import slick.jdbc.GetResult

import scala.collection.mutable
import scala.concurrent.Future
import scala.reflect.ClassTag
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scalaz._
import scalaz.Alpha.T
import slick.jdbc.MySQLProfile.api._


object Inject {
  lazy val injector = Guice.createInjector()

  def apply[T <: AnyRef](implicit m: ClassTag[T]): T =
    injector.getInstance(m.runtimeClass).asInstanceOf[T]
}

class ServerQuestionServiceTests extends FlatSpec with ScalaFutures with Matchers{
  lazy val questionService: QuestionService = Inject[QuestionService]

  def prepare = {
    val dbconn = Database.forURL("jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1", driver="org.h2.Driver")
    questionService.dbConfig = dbconn
    val questions = TableQuery[QuestionTableDef]
    val answers = TableQuery[AnswerTableDef]

    val setup = DBIO.seq(
      // Create the tables, including primary and foreign keys
      questions.schema.create,
      answers.schema.create,
      // Insert some suppliers
      questions += Question(1,"W języku scala słowo kluczowe val używane jest do :",1),
      questions += Question(2, "Jak nazywa się osoba podpowiadająca aktorom w teatrze?", 1),
      questions += Question(3, "W sali do przyrody znajdują się słoje z eksponatami.Który z podanych niżej słoi jest źle oznakowany?", 2),
      questions += Question(4, "Napięcie prądu mierzy się w woltach (V) . Jakie jest napięcie produ w gniazdkach w Polsce ?", 2),

      answers += Answer(1,"deklaracji stałych", 1, true),
      answers += Answer(2,"deklaracji zmiennych", 1, false),
      answers += Answer(3,"deklaracji listy", 1, false),
      answers += Answer(4,"odpowiedź a i c jest poprawna", 1, false),
      answers += Answer(5,"deklaracji stałych", 2, true),
      answers += Answer(6,"deklaracji zmiennych", 2, false),
      answers += Answer(7,"deklaracji listy", 2, false),
      answers += Answer(8,"odpowiedź a i c jest poprawna", 2, false),
      answers += Answer(9,"deklaracji stałych", 3, true),
      answers += Answer(10,"deklaracji zmiennych", 3, false),
      answers += Answer(11,"deklaracji listy", 3, false),
      answers += Answer(12,"odpowiedź a i c jest poprawna", 3, false),
      answers += Answer(13,"deklaracji stałych", 4, true),
      answers += Answer(14,"deklaracji zmiennych", 4, false),
      answers += Answer(15,"deklaracji listy", 4, false),
      answers += Answer(16,"odpowiedź a i c jest poprawna", 4, false)
    )
    Await.ready(dbconn.run(setup),5000 millis)
  }

  "QuestionService" should "return a question" in {
    prepare
    val returned = questionService.getRandomQuestionForLevel(1)
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

  it should "not find answer" in {
    val returned = questionService.getAllAnswersForQuestion(0)
    whenReady(returned){
      q => q.size shouldBe 0
    }
  }

  it should "check that sum of percentages is correct" in{
    val seqAns: Seq[AnswerAudiencePercentageJsonModel] = Seq(AnswerAudiencePercentageJsonModel(1,25),AnswerAudiencePercentageJsonModel(2,15),AnswerAudiencePercentageJsonModel(3,15),AnswerAudiencePercentageJsonModel(4,15))
    val returned = questionService.checkPercentagesIsUnderOneHundred(seqAns)
    returned shouldBe 30
  }

  it should "somethin do to" in{
    val returned = questionService.getRandomQuestionForLevel(4)
    whenReady(returned){ q =>
      q should have size 0
    }
  }

  it should "check that answer is correct cause it is not" in{
    val returned = questionService.checkIfAnswerIsCorrect(2)
    whenReady(returned){
      q => q shouldBe a [Answer]
        q.isCorrect shouldBe false
        returned should not be null
    }
  }

  it should "give exception for checking not existing answer " in{
    val returned = questionService.checkIfAnswerIsCorrect(1111)
    assertThrows[TestFailedException]{whenReady(returned){
        q => q.isCorrect shouldBe false
    }}
  }

  it should "return no answers cause question does not exist" in {
    val returned = questionService.getAllAnswersForQuestion(11111)
    whenReady(returned){
      q => q.size shouldBe 0
    }
  }
}