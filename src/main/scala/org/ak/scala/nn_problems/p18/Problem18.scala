package org.ak.scala.nn_problems.p18

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  8/18/14 - 4:52 PM
 */
object Problem18 {
  //  P18 (**) Extract a slice from a list.
  //    Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
  //  Example:
  //
  //    scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //  res0: List[Symbol] = List('d, 'e, 'f, 'g)


  def slice[T](
    fromIndex: Int,
    untilIndex: Int,
    list: List[T]
  ) = {
    @tailrec
    def sliceRec(
      rest: List[T],
      leftToDrop: Int,
      leftToTake: Int,
      sliced: List[T]
    ): List[T] = (leftToDrop, leftToTake, rest) match {
      case (0, 0, _) | (_, _, Nil) =>
        sliced.reverse

      case (0, _, head :: tail) =>
        sliceRec(
          tail,
          leftToDrop,
          leftToTake - 1,
          head :: sliced
        )


      case (_, _, _ :: tail) =>
        sliceRec(
          tail,
          leftToDrop - 1,
          leftToTake,
          sliced
        )
    }

    sliceRec(
      list,
      fromIndex,
      untilIndex - fromIndex,
      Nil
    )
  }



  def sliceUsingDropAndTake[T](
    fromIndex: Int,
    untilIndex: Int,
    list: List[T]
  ) = {
    require(fromIndex <= untilIndex)

    list.drop(fromIndex).take(untilIndex - fromIndex)
  }
}
