package org.ak.scala.nn_problems.p10

import org.ak.scala.nn_problems.p09.Problem09

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  8/15/14 - 3:11 PM
 */
object Problem10 {
  //  P10 (*) Run-length encoding of a list.
  //    Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
  //  Example:
  //
  //    scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //  res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))


  def encodeTailRecursive[T](list: List[T]) = {
    @tailrec
    def encodeRec(
      rest: List[List[T]],
      encoded: List[(Int, T)]
    ): List[(Int, T)] = {
      rest match {
        case Nil =>
          encoded

        case headBasket :: tail =>
          encodeRec(
            tail,
            (headBasket.length, headBasket.head) :: encoded
          )
      }
    }

    encodeRec(
      Problem09.packTailRecursive(list),
      Nil
    ).reverse
  }



  def encodeUsingFor[T](list: List[T]) = {
    for (basket <- Problem09.packTailRecursive(list)) yield (basket.length, basket.head)
  }



  def encodeUsingMap[T](list: List[T]) = {
    Problem09.packTailRecursive(list).map(
      basket => (basket.length, basket.head)
    )
  }


  def encodeUsingFoldLeft[T](list: List[T]) = {
    Problem09.packTailRecursive(list).foldLeft(List[(Int, T)]())(
      (encoded, basket) =>
        (basket.length, basket.head) :: encoded
    ).reverse
  }


  def encodeUsingFoldRight[T](list: List[T]) = {
    Problem09.packTailRecursive(list).foldRight(List[(Int, T)]())(
      (basket, encoded) =>
        (basket.length, basket.head) :: encoded
    )
  }
}
