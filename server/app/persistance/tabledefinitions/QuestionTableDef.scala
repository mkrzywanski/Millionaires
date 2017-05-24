package persistance.tabledefinitions

import persistance.model.Question
import slick.jdbc.MySQLProfile.api._
import slick.lifted.Tag;

/**
  * Created by michal on 22.05.17.
  */
class QuestionTableDef(tag: Tag) extends Table[Question](tag, "Questions") {
  def id = column[Int]("id", O.PrimaryKey)
  def content = column[String]("content")
  def level = column[Int]("question_level")
  override def * = (id, content, level) <> (Question.tupled, Question.unapply)
}
