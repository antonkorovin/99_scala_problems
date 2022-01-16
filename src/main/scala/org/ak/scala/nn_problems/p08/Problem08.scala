package org.ak.scala.nn_problems.p08

import scala.annotation.tailrec

/**
  * @author antonk
  * @since 8/14/14 - 5:14 PM
  */
object Problem08 {
  //  P08 (**) Eliminate consecutive duplicates of list elements.
  //    If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
  //    Example:
  //
  //    scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //  res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)

  def compressTailRec[T](list: List[T]): List[T] = {
    @tailrec
    def compressRec(
      rest: List[T],
      compressed: List[T],
      element: T = null.asInstanceOf[T]
    ): List[T] = rest match {
      case head :: tail if head != element || compressed.isEmpty =>
        compressRec(
          tail,
          head :: compressed,
          head
        )

      case head :: tail if head == element =>
        compressRec(
          tail,
          compressed,
          element
        )

      case Nil =>
        compressed.reverse
    }


    compressRec(
      list,
      Nil
    )
  }


  def compressTailRecUsingDropWhile[T](list: List[T]): List[T] = {
    @tailrec
    def compressRec(
      rest: List[T],
      compressed: List[T]
    ): List[T] = {
      rest match {
        case Nil =>
          compressed

        case head :: _ =>
          compressRec(
            rest.dropWhile(_ == head),
            head :: compressed
          )
      }
    }


    compressRec(
      list,
      Nil
    ).reverse
  }


  def compressUsingFoldLeft[T](list: List[T]): List[T] = {
    list.foldLeft(List[T]()) {
      (cmp, next) =>
        if (cmp.isEmpty || next != cmp.head) next :: cmp
        else cmp
    }.reverse
  }


  def compressUsingFoldRight[T](list: List[T]): List[T] = {
    list.foldRight(List[T]()) {
      (next, cmp) =>
        if (cmp.isEmpty || next != cmp.head) next :: cmp
        else cmp
    }
  }
}
