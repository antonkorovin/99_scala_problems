package org.ak.scala.nn_problems.p03

import scala.annotation.tailrec

/**
  * @author antonk
  * @since 8/12/14 - 2:16 PM
  */
object Problem03 {
  //  P03 (*) Find the Kth element of a list.
  //  By convention, the first element in the list is element 0.
  //  Example:
  //
  //    scala> nth(2, List(1, 1, 2, 3, 5, 8))
  //  res0: Int = 2

  @tailrec
  def nth[T](
    n: Int,
    list: List[T]
  ): T = {
    if (n < 0) throw new IndexOutOfBoundsException

    list match {
      case head :: _ if n == 0 =>
        head

      case _ :: tail =>
        nth(
          n - 1,
          tail
        )

      case Nil => throw new IndexOutOfBoundsException
    }
  }
}
