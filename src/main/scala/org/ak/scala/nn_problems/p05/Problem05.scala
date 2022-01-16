package org.ak.scala.nn_problems.p05

import scala.annotation.tailrec

/**
  * @author antonk
  * @since 8/13/14 - 12:00 PM
  */
object Problem05 {
  //  P05 (*) Reverse a list.
  //    Example:
  //    scala> reverse(List(1, 1, 2, 3, 5, 8))
  //  res0: List[Int] = List(8, 5, 3, 2, 1, 1)


  def reverse[T](list: List[T]): List[T] = {
    @tailrec
    def reverseRec(
      rest: List[T],
      reversed: List[T]
    ): List[T] = {
      rest match {
        case head :: tail =>
          reverseRec(
            tail,
            head :: reversed
          )

        case Nil =>
          reversed
      }
    }


    reverseRec(
      list,
      Nil
    )
  }
}
