package org.ak.scala.nn_problems.p13

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  8/15/14 - 5:57 PM
 */
object Problem13 {
  //  P13 (**) Run-length encoding of a list (direct solution).
  //    Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
  //  Example:
  //
  //    scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //  res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))


  def encodeDirectTailRec[T](list: List[T]) = {
    @tailrec
    def encodeRec(
      rest: List[T],
      encoded: List[(Int, T)]
    ): List[(Int, T)] = {
      rest match {
        case head :: tail if encoded.nonEmpty && head == encoded.head._2 =>
          encodeRec(
            tail,
            (1 + encoded.head._1, head) :: encoded.tail
          )


        case head :: tail =>
          encodeRec(
            tail,
            (1, head) :: encoded
          )


        case Nil =>
          encoded
      }
    }


    encodeRec(
      list,
      Nil
    ).reverse
  }



  def encodeDirectUsingFoldLeft[T](list: List[T]) = {
    list.foldLeft(List[(Int, T)]()) {
      (encoded, e) =>
        if (encoded.isEmpty) {
          (1, e) :: encoded
        } else if (encoded.head._2 != e) {
          (1, e) :: encoded
        } else {
          val current = encoded.head
          (1 + current._1, current._2) :: encoded.tail
        }
    }.reverse
  }


  def encodeDirectUsingFoldRight[T](list: List[T]) = {
    list.foldRight(List[(Int, T)]()) {
      (e, encoded) =>
        if (encoded.isEmpty) {
          (1, e) :: encoded
        } else if (encoded.head._2 != e) {
          (1, e) :: encoded
        } else {
          val current = encoded.head
          (1 + current._1, current._2) :: encoded.tail
        }
    }
  }
}
