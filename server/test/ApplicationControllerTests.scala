import com.google.inject.Guice
import controllers.Application
import org.scalatest.{FlatSpec, Inside, Matchers}
import org.scalatest.concurrent.ScalaFutures
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.{Await, Future}
import scala.reflect.ClassTag

/**
  * Created by kaima_000 on 2017-06-12.
  */

class ApplicationControllerTests extends FlatSpec with ScalaFutures with Matchers {
  lazy val applicationController: Application = Inject[Application]

  "ApplicationController" should "run a hello" in {
    val result: Future[Result] = applicationController.hello().apply(FakeRequest())
    val bodyText: String = contentAsString(result)
    bodyText shouldBe "hello"
  }

  it should "give some answers" in {
    val result: Future[Result] = applicationController.answers().apply(FakeRequest())
    val bodyText: String = contentAsString(result)
    bodyText should include ("questionId")
  }

  it should "give some questions" in {
    val result: Future[Result] = applicationController.questions().apply(FakeRequest())
    val bodyText: String = contentAsString(result)
    bodyText should include ("content")
  }

  it should "give random question" in new WithServer {
    val result: Future[Result] = applicationController.getRandomQuestionForLevel(2).apply(FakeRequest().withSession("question2" -> "false"))
    val bodyText: String = contentAsString(result)
    bodyText should include ("\"level\":2")
    bodyText should not include ("\"level\":1")
  }

  it should "check if answer is correct" in {
    val result: Future[Result] = applicationController.chceckIfAnswerIsCorrect(2).apply(FakeRequest())
    val bodyText: String = contentAsString(result)
    bodyText should include ("isCorrect")
  }

  it should "ask friend for help" in new WithServer {
    val result: Future[Result] = applicationController.questionToAFriend(2).apply(FakeRequest().withSession("friendHint" -> "false"))
    val bodyText: String = contentAsString(result)
    bodyText should include ("Myślę, że odpowiedź to")
  }

  it should "eliminate two answers" in new WithServer {
    val result: Future[Result] = applicationController.eliminateTwoWrongAnswers(1).apply(FakeRequest().withSession("fiftyFiftyHint" -> "false"))
    val bodyText: String = contentAsString(result)
    bodyText.split("},").toSeq should have size 2
  }

  it should "let the audience help our poor boy" in new WithServer {
    val result: Future[Result] = applicationController.questionForAudience(1).apply(FakeRequest().withSession("audienceHint" -> "false"))
    val bodyText: String = contentAsString(result)
    bodyText.split("},").toSeq should have size 4
    bodyText should include ("percentage")
  }
}
