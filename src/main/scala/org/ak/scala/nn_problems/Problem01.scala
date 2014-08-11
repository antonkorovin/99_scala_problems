package org.ak.scala.nn_problems


import scala.annotation.tailrec

/**
 * @author antonk
 * @since  8/11/14 - 11:25 PM
 */
object Problem01 {
  // Find the last element of a list.
  // Example:
  // scala> last(List(1, 1, 2, 3, 5, 8))
  // res0: Int = 8


  @tailrec
  def recursiveLast[T](list: List[T]): T = list match {
    case lastElement :: Nil =>
      lastElement

    case head :: tail =>
      recursiveLast(tail)

    case Nil =>
      throw new NoSuchElementException
  }


  def iterativeLast[T](list: List[T]): T = {
    if (list.isEmpty) throw new NoSuchElementException

    var itr = list
    var next = itr.tail

    while (next.nonEmpty) {
      itr = next
      next = next.tail
    }

    itr.head
  }
}
