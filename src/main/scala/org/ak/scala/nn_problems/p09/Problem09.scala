package org.ak.scala.nn_problems.p09

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  8/15/14 - 11:04 AM
 */
object Problem09 {
  //  P09 (**) Pack consecutive duplicates of list elements into sublists.
  //    If a list contains repeated elements they should be placed in separate sublists.
  //    Example:
  //
  //    scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //  res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))


  def packTailRecursive[T](list: List[T]) = {
    @tailrec
    def packRec(
      rest: List[T],
      elements: List[T],
      packed: List[List[T]]
    ): List[List[T]] = {
      rest match {
        case head :: tail if elements.isEmpty =>
          packRec(
            tail,
            List(head),
            packed
          )


        case head :: tail if head != elements.head =>
          packRec(
            tail,
            List(head),
            elements :: packed
          )


        case head :: tail =>
          packRec(
            tail,
            head :: elements,
            packed
          )


        case Nil =>
          if (elements.isEmpty) packed
          else                  elements :: packed
      }


    }

    packRec(list, Nil, Nil).reverse
  }



  def packUsingTakeAndDropWhile[T](list: List[T]) = {
    @tailrec
    def packRec(
      rest: List[T],
      elements: List[T],
      packed: List[List[T]]
    ): List[List[T]] = {
      rest match {
        case Nil =>
          if (elements.isEmpty) packed
          else                  elements :: packed

        case head :: tail =>
          packRec(
            rest.dropWhile(_ == head),
            rest.takeWhile(_ == head),
            if (elements.isEmpty) packed else elements :: packed
          )
      }
    }


    packRec(
      list,
      Nil,
      Nil
    ).reverse
  }



  def packUsingSpan[T](list: List[T]) = {
    @tailrec
    def packRec(
      rest: List[T],
      packed: List[List[T]]
    ): List[List[T]] = {
      rest match {
        case Nil =>
          packed

        case head :: _ =>
          val (repeatedElements, tail) = rest.span(_ == head)

          packRec(
            tail,
            repeatedElements :: packed
          )
      }
    }


    packRec(
      list,
      Nil
    ).reverse
  }
}
