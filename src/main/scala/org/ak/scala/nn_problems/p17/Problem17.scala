package org.ak.scala.nn_problems.p17

import scala.annotation.tailrec

/**
  * @author antonk
  * @since 8/18/14 - 2:23 PM
  */
object Problem17 {
  //  P17 (*) Split a list into two parts.
  //    The length of the first part is given. Use a Tuple for your result.
  //  Example:
  //
  //    scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //  res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))


  def split[T](
    n: Int,
    list: List[T]
  ): (List[T], List[T]) = {
    @tailrec
    def splitRec(
      current: Int,
      rest: List[T],
      prefix: List[T]
    ): (List[T], List[T]) = rest match {
      case head :: tail if current <= n =>
        splitRec(
          current + 1,
          tail,
          head :: prefix
        )

      case suffix =>
        (prefix.reverse, suffix)
    }


    splitRec(
      1,
      list,
      Nil
    )
  }


  def splitV2[T](
    n: Int,
    list: List[T]
  ): (List[T], List[T]) = {
    @tailrec
    def splitRec(
      current: Int,
      rest: List[T],
      prefix: List[T]
    ): (List[T], List[T]) = (current, rest) match {
      case (0, suffix) =>
        (prefix.reverse, suffix)

      case (_, head :: tail) =>
        splitRec(
          current - 1,
          tail,
          head :: prefix
        )

      case (_, Nil) =>
        (prefix, Nil)
    }


    splitRec(
      n,
      list,
      Nil
    )
  }


  def splitUsingTakeAndDrop[T](
    n: Int,
    list: List[T]
  ): (List[T], List[T]) = {
    val prefix = list.take(n)
    val suffix = list.drop(n)

    (prefix, suffix)
  }
}
