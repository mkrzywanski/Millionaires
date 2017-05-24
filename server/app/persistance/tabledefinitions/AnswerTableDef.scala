package persistance.tabledefinitions

import persistance.model.Answer
import slick.jdbc.MySQLProfile.api._;
import slick.lifted.Tag;

/**
  * Created by michal on 21.05.17.
  */

class AnswerTableDef(tag: Tag) extends Table[Answer](tag, "Answers"){
  def id = column[Int]("id", O.PrimaryKey)
  def content = column[String]("content")
  def questionId = column[Int]("question_id")
  def isCorrect = column[Boolean]("is_correct")
  override def * = (id, content, questionId, isCorrect) <> (Answer.tupled, Answer.unapply)

}
