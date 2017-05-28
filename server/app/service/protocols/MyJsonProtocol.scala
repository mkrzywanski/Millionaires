package service.protocols

import persistance.model._
import service.jsonmodels.{AnswerAudiencePercentageJsonModel, AnswerCorrectJsonModel, QuestionToFriendJsonModel}
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

  implicit object AnswerCorrectnessJsonFormat extends RootJsonFormat[AnswerCorrectJsonModel] {
    def write(answerCorrectness: AnswerCorrectJsonModel) = JsObject(Map(
      "isCorrect" -> JsBoolean(answerCorrectness.isCorrect)
    ))
    def read(value: JsValue): AnswerCorrectJsonModel = ???
  }

  implicit object QuestionToFriendJsonFormat extends RootJsonFormat[QuestionToFriendJsonModel] {
    def write(questionToFriend: QuestionToFriendJsonModel) = JsObject(Map(
      "content" -> JsString(questionToFriend.content),
      "answerId" -> JsNumber(questionToFriend.correctAnswerId)
    ))
    def read(value: JsValue): QuestionToFriendJsonModel = ???
  }

  implicit object AnswerAudiencePercentageJsonFormat extends RootJsonFormat[AnswerAudiencePercentageJsonModel] {
    def write(answerAudiencePercentage : AnswerAudiencePercentageJsonModel) = JsObject(Map(
      "answerId" -> JsNumber(answerAudiencePercentage.answerId),
      "percentage" -> JsNumber(answerAudiencePercentage.percentage)
    ))
    def read(value: JsValue): AnswerAudiencePercentageJsonModel = ???
  }
}
