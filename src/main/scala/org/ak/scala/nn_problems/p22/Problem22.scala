package org.ak.scala.nn_problems.p22

import scala.annotation.tailrec

/**
  * @author antonk
  * @since  8/21/14 - 6:34 PM
  */
object Problem22 {
  //  P22 (*) Create a list containing all integers within a given range.
  //    Example:
  //    scala> range(4, 9)
  //  res0: List[Int] = List(4, 5, 6, 7, 8, 9)

  def range(
    start: Int,
    finish: Int
  ) = {
    require(start <= finish)

    @tailrec
    def createRange(
      current: Int,
      range: List[Int]
    ): List[Int] = {
      if (current < finish)
        createRange(
          current + 1,
          current :: range
        )
      else
        current :: range
    }


    createRange(
      start,
      Nil
    ).reverse
  }
}
