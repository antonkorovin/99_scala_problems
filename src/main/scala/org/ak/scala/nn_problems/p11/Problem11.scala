package org.ak.scala.nn_problems.p11

import org.ak.scala.nn_problems.p09.Problem09

import scala.annotation.tailrec

/**
  * @author antonk
  * @since 8/15/14 - 3:41 PM
  */
object Problem11 {
  //  P11 (*) Modified run-length encoding.
  //  Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
  //  Example:
  //
  //    scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //  res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))


  def encodeTailRecursive[T](list: List[T]): List[Any] = {
    @tailrec
    def encodeRec(
      rest: List[List[T]],
      encoded: List[Any]
    ): List[Any] = {
      rest match {
        case Nil =>
          encoded

        case headBasket :: tail =>
          val element = {
            val length = headBasket.length
            if (length == 1) headBasket.head
            else (length, headBasket.head)
          }

          encodeRec(
            tail,
            element :: encoded
          )
      }
    }

    encodeRec(
      Problem09.packTailRecursive(list),
      Nil
    ).reverse
  }


  def encodeUsingFor[T](list: List[T]): List[Any] = {
    for (basket <- Problem09.packTailRecursive(list)) yield {
      val length = basket.length
      if (length == 1) basket.head
      else (length, basket.head)
    }
  }


  def encodeUsingMap[T](list: List[T]): List[Any] = {
    Problem09.packTailRecursive(list).map(
      basket => {
        val length = basket.length
        if (length == 1) basket.head
        else (length, basket.head)
      }
    )
  }


  def encodeUsingFoldLeft[T](list: List[T]): List[Any] = {
    Problem09.packTailRecursive(list).foldLeft(List[Any]())(
      (encoded, basket) => {
        val length = basket.length
        if (length == 1) basket.head
        else (length, basket.head)
      } :: encoded
    ).reverse
  }


  def encodeUsingFoldRight[T](list: List[T]): List[Any] = {
    Problem09.packTailRecursive(list).foldRight(List[Any]())(
      (basket, encoded) => {
        val length = basket.length
        if (length == 1) basket.head
        else (length, basket.head)
      } :: encoded
    )
  }
}
