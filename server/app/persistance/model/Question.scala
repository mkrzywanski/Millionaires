package persistance.model

/**
  * Created by michal on 22.05.17.
  */
case class Question(id : Int, content : String, level : Int)

case class QuestionWithAnswers(id: Int, content : String, level: Int, answers : Seq[Answer])


