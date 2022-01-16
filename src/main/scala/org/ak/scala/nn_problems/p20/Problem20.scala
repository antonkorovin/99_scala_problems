package org.ak.scala.nn_problems.p20

import java.util.NoSuchElementException
import scala.annotation.tailrec

/**
  * @author antonk
  * @since 8/20/14 - 5:34 PM
  */
object Problem20 {
  //  P20 (*) Remove the Kth element from a list.
  //  Return the list and the removed element in a Tuple. Elements are numbered from 0.
  //  Example:
  //
  //    scala> removeAt(1, List('a, 'b, 'c, 'd))
  //  res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

  def removeAt[T](
    n: Int,
    list: List[T]
  ): (List[T], T) = {
    @tailrec
    def removeAtRec(
      n: Int,
      rest: List[T],
      prefix: List[T]
    ): (List[T], T) = (n, rest) match {
      case (0, head :: tail) =>
        (prefix.reverse ::: tail, head)

      case (_, head :: tail) =>
        removeAtRec(
          n - 1,
          tail,
          head :: prefix
        )

      case (_, Nil) =>
        throw new NoSuchElementException
    }


    removeAtRec(
      n,
      list,
      Nil
    )
  }


  def removeAtUsingSplitAt[T](
    n: Int,
    list: List[T]
  ): (List[T], T) = {
    if (n < 0 || n > list.size) {
      throw new NoSuchElementException()
    }

    val (prefix, suffix) = list.splitAt(n)

    (prefix ::: suffix.tail, suffix.head)
  }


  def removeAtUsingTakeAndDrop[T](
    n: Int,
    list: List[T]
  ): (List[T], T) = {
    if (n < 0 || n > list.size) {
      throw new NoSuchElementException()
    }

    val prefix = list.take(n)
    val suffix = list.drop(n)

    (prefix ::: suffix.tail, suffix.head)
  }
}
