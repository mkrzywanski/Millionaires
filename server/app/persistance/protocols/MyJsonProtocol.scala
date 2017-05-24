package persistance.protocols

import persistance.model._
import spray.json._

/**
  * Created by michal on 23.05.17.
  */

object MyJsonProtocol extends DefaultJsonProtocol {
  implicit object AnswerJsonFormat extends RootJsonFormat[Answer] {
    def write(answer: Answer) = JsObject(Map(
      "id" -> JsNumber(answer.id),
      "content" -> JsString(answer.content),
      "questionId" -> JsNumber(answer.questionId),
      "isCorrect" -> JsNull
    ))
    def read(value: JsValue): Answer = ???
  }

  implicit object QuestionJsonFormat extends RootJsonFormat[Question] {
    def write(q: Question) = JsObject(Map(
      "id" -> JsNumber(q.id),
      "content" -> JsString(q.content),
      "level" -> JsNumber(q.level)
    ))
    def read(value: JsValue): Question = ???
  }

  implicit object QuestionWithAnswersJsonFormat extends RootJsonFormat[QuestionWithAnswers] {
    def write(q: QuestionWithAnswers) = JsObject(Map(
      "id" -> JsNumber(q.id),
      "content" -> JsString(q.content),
      "level" -> JsNumber(q.level),
      "answers" -> JsArray(q.answers.toList.map(_.toJson))
    ))
    def read(value: JsValue): QuestionWithAnswers = ???
  }

  implicit object AnswerCorrectnessJsonFormat extends RootJsonFormat[AnswerCorrectness] {
    def write(answerCorrectness: AnswerCorrectness) = JsObject(Map(
      "isCorrect" -> JsBoolean(answerCorrectness.isCorrect)
    ))
    def read(value: JsValue): AnswerCorrectness = ???
  }

  implicit object QuestionToFriendJsonFormat extends RootJsonFormat[QuestionToFriend] {
    def write(questionToFriend: QuestionToFriend) = JsObject(Map(
      "content" -> JsString(questionToFriend.content),
      "answerId" -> JsNumber(questionToFriend.correctAnswerId)
    ))
    def read(value: JsValue): QuestionToFriend = ???
  }

  implicit object AnswerAudiencePercentageJsonFormat extends RootJsonFormat[AnswerAudiencePercentage] {
    def write(answerAudiencePercentage : AnswerAudiencePercentage) = JsObject(Map(
      "answerId" -> JsNumber(answerAudiencePercentage.answerId),
      "percentage" -> JsNumber(answerAudiencePercentage.percentage)
    ))
    def read(value: JsValue): AnswerAudiencePercentage = ???
  }
}
