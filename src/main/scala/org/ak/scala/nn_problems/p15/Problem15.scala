package org.ak.scala.nn_problems.p15

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  8/18/14 - 11:36 AM
 */
object Problem15 {
  //  P15 (**) Duplicate the elements of a list a given number of times.
  //  Example:
  //    scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
  //  res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)


  def duplicateN[T](
    n: Int,
    list: List[T]
  ) = {
    @tailrec
    def duplicateRec(
      rest: List[T],
      duplicated: List[T]
    ): List[T] = rest match {
      case head :: tail =>
        duplicateRec(
          tail,
          List.fill(n)(head) ::: duplicated
        )

      case Nil =>
        duplicated
    }


    duplicateRec(
      list,
      Nil
    ).reverse
  }
}
