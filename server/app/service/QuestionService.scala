package service

import javax.inject.Inject

import persistance.tabledefinitions.{AnswerTableDef, QuestionTableDef}
import play.api.db.slick.DatabaseConfigProvider
import service.jsonmodels.AnswerAudiencePercentageJsonModel
import slick.jdbc.JdbcProfile
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global;

/**
  * Created by michal on 22.05.17.
  */
class QuestionService{
  val dbConfig = Database.forURL(url="jdbc:mysql://localhost/Millionaires",user="millionaires",password="millionaires",driver="com.mysql.jdbc.Driver")
  val answers = TableQuery[AnswerTableDef];
  val questions = TableQuery[QuestionTableDef];


  def listAllAnswers = {
    dbConfig.run(answers.result)
  }

  def listAll = {
    val q = for {
      qu <- questions
      a <- answers if qu.id === a.questionId
    } yield (qu, a)
    dbConfig.run(q.result.map(r => r.groupBy(_._1).mapValues(_.map(_._2)).toSeq))

  }

  def getRandomQuestionForLevel(level : Int) = {

    val q = for {
      qu <- questions if qu.level === level
      a <- answers if qu.id === a.questionId
    } yield (qu, a)

    val query = q.result.map(r => r.groupBy(_._1).mapValues(_.map(_._2)).toSeq)
    dbConfig.run(query)
  }

  def checkIfAnswerIsCorrect(answerId: Int) = {
    val query = answers.filter(_.id === answerId).result.head;
    dbConfig.run(query);
  }

  def getCorrectAnswerForQuestion(questionId: Int) = {
    val query = answers.filter(a => (a.questionId === questionId && a.isCorrect === true)).result.head;
    dbConfig.run(query);
  }

  def getAllAnswersForQuestion(questionId: Int) = {
    val query = answers.filter(a => a.questionId === questionId).result;
    dbConfig.run(query);
  }

  def checkPercentagesIsUnderOneHundred(seq : Seq[AnswerAudiencePercentageJsonModel]) : Int = {
    var sum = 0;
    for(a <- 0 until seq.size) {
      sum += seq(a).percentage
    }
    return 100 - sum
  }
}
