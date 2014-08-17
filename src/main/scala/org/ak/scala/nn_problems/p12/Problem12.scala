package org.ak.scala.nn_problems.p12

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  8/15/14 - 3:52 PM
 */
object Problem12 {
  //  P12 (**) Decode a run-length encoded list.
  //    Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
  //  Example:
  //
  //    scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  //  res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  def decode[T](list: List[(Int, T)]) = {
    @tailrec
    def decodeRec(
      rest: List[(Int, T)],
      decoded: List[T]
    ): List[T] = rest match {
      case Nil =>
        decoded

      case head :: tail =>
        decodeRec(
          tail,
          List.fill(head._1)(head._2) ::: decoded
        )
    }


    decodeRec(
      list,
      Nil
    ).reverse
  }


  def decodeUsingFoldLeft[T](list: List[(Int, T)]) = {
    list.foldLeft(List[T]()) {
      (decoded, e) =>
        List.fill(e._1)(e._2) ::: decoded
    }.reverse
  }


  def decodeUsingFoldRight[T](list: List[(Int, T)]) = {
    list.foldRight(List[T]()) {
      (e, decoded) =>
        List.fill(e._1)(e._2) ::: decoded
    }
  }


  def decodeUsingMap[T](list: List[(Int, T)]) = {
    list.map {
      e =>
        List.fill(e._1)(e._2)
    }.flatten
  }


  def decodeUsingFor[T](list: List[(Int, T)]) = {
    (for (e <- list) yield List.fill(e._1)(e._2)).flatten
  }
}
