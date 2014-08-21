package org.ak.scala.nn_problems.p23

import org.ak.scala.nn_problems.p20.Problem20

import scala.annotation.tailrec
import scala.util.Random

/**
 * @author antonk
 * @since  8/21/14 - 2:57 PM
 */
object Problem23 {
  //  P23 (**) Extract a given number of randomly selected elements from a list.
  //  Example:
  //    scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
  //  res0: List[Symbol] = List('e, 'd, 'a)
  //  Hint: Use the solution to problem P20


  def randomSelect[T](
    n:  Int,
    list: List[T]
  ) = {
    @tailrec
    def randomSelectRec(
      current: Int,
      rest: List[T],
      selected: List[T]
    ): List[T] = {
      if (current != n) {
        val (newRest, removed) = Problem20.removeAt(
           Random.nextInt(selected.size),
          rest
        )

        randomSelectRec(
          current + 1,
          newRest,
          removed :: selected
        )

      } else
        selected
    }



    randomSelectRec(
      0,
      list,
      Nil
    )
  }
}
