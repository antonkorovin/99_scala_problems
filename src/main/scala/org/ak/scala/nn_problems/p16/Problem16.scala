package org.ak.scala.nn_problems.p16

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  8/18/14 - 12:09 PM
 */
object Problem16 {
  //  P16 (**) Drop every Nth element from a list.
  //  Example:
  //    scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //  res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)


  def drop[T](
    n: Int,
    list: List[T]
  ) = {
    @tailrec
    def dropRec(
      current: Int,
      rest: List[T],
      filtered: List[T]
    ): List[T] = rest match {
      case head :: tail if current % n == 0 =>
        dropRec(
          current + 1,
          tail,
          filtered
        )


      case head :: tail =>
        dropRec(
          current + 1,
          tail,
          head :: filtered
        )


      case Nil =>
        filtered
    }


    dropRec(
      1,
      list,
      Nil
    ).reverse
  }



  def dropV2[T](
    n: Int,
    list: List[T]
  ) = {
    def dropRec(
      current: Int,
      rest: List[T],
      filtered: List[T]
    ): List[T] = (current, rest) match {
      case (1, _ :: tail) =>
        dropRec(
          n,
          tail,
          filtered
        )

      case (_, head :: tail) =>
        dropRec(
          current - 1,
          tail,
          head :: filtered
        )

      case (_, Nil) =>
        filtered
    }


    dropRec(
      n,
      list,
      Nil
    ).reverse
  }


  def dropUsingForAndZipWithIndex[T](
    n: Int,
    list: List[T]
  ) = {
    for ((e, index) <- list.zipWithIndex if (index + 1) % n != 0) yield e
  }


  def dropUsingFilterAndZipWithIndex[T](
    n: Int,
    list: List[T]
  ) = {
    list.zipWithIndex.filter {
      elementWithIndex =>
        (elementWithIndex._2 + 1) % n != 0
    }.unzip._1
  }
}
