package org.ak.scala.nn_problems.p21

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  8/20/14 - 6:34 PM
 */
object Problem21 {
  //  P21 (*) Insert an element at a given position into a list.
  //    Example:
  //    scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
  //  res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

  def insertAt[T](
    element: T,
    n: Int,
    list: List[T]
  ) = {
    @tailrec
    def insertAtRec(
      current: Int,
      rest: List[T],
      prefix: List[T]
    ): List[T] = (current, rest) match {
      case (0, _) | (_, Nil) =>
        prefix.reverse ::: (element ::rest)


      case (_, head :: tail) =>
        insertAtRec(
          current - 1,
          tail,
          head :: prefix
        )
    }


    insertAtRec(
      n,
      list,
      Nil
    )
  }
}
