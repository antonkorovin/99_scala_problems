package org.ak.scala.nn_problems.p04

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  8/12/14 - 5:40 PM
 */
object Problem04 {
  //  P04 (*) Find the number of elements of a list.
  //    Example:
  //    scala> length(List(1, 1, 2, 3, 5, 8))
  //  res0: Int = 6

  def length[T](list: List[T]) = {
    @tailrec
    def lengthRec(count: Int, list: List[T]): Int = list match {
      case Nil =>
        count

      case _ :: tail =>
        lengthRec(
          count + 1,
          tail
        )
    }


    lengthRec(0, list)
  }
}
