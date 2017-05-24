package shared

import scala.util.Random

/**
  * Created by michal on 23.05.17.
  */
object Utils {
  val random = Random;

  def getRandomNumber(start : Int, end: Int): Int = {
    return start + random.nextInt( (end - start) + 1 )
  }

}
