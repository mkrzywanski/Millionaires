package service

import javax.inject.Inject

import persistance.model.Answer
import persistance.tabledefinitions.AnswerTableDef
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.Future

/**
  * Created by michal on 21.05.17.
  */

class AnswerService @Inject()(dbConfigProvider: DatabaseConfigProvider) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]
  val answers = TableQuery[AnswerTableDef];

  def listAll: Future[Seq[Answer]] = {
    dbConfig.db.run(answers.result)
  }
}
