package persistance.model

import spray.json.DefaultJsonProtocol

/**
  * Created by michal on 21.05.17.
  */
case class Answer(id : Int, content : String, questionId : Int, isCorrect : Boolean)

