package org.ak.scala.nn_problems.p28

import org.ak.scala.nn_problems.p10.Problem10

import scala.annotation.tailrec

/**
  * @author antonk
  * @since 10/14/14 - 7:16 AM
  */
object Problem28 {
  //  P28 (**) Sorting a list of lists according to length of sublists.
  //    a) We suppose that a list contains elements that are lists themselves.
  //  The objective is to sort the elements of the list according to their length.
  //  E.g. short lists first, longer lists later, or vice versa.
  //    Example:
  //
  //    scala> lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
  //  res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
  //
  //  b) Again, we suppose that a list contains elements that are lists themselves.
  //  But this time the objective is to sort the elements according to their length frequency;
  //  i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed, others with a more frequent length come later.
  //
  //  Example:
  //
  //    scala> lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
  //  res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
  //
  //  Note that in the above example, the first two lists in the result have length 4 and 1 and both lengths appear just once.
  //  The third and fourth lists have length 3 and there are two list of this length. Finally, the last three lists have length 2.
  //  This is the most frequent length.


  def lsort[T](list: List[List[T]]): List[List[T]] = list.sortBy(_.size)

  def lsortFreq[A](list: List[List[A]]): List[List[A]] = {
    val frequencies = Map.from(
      Problem10.encodeTailRecursive(
        list.map(_.length).sorted
      ) map {
        _.swap
      }
    )

    list.sortWith {
      (e1, e2) =>
        frequencies(e1.length) < frequencies(e2.length)
    }
  }

  def lsortFreqOriginal[A](list: List[List[A]]): List[List[A]] = {
    type ListWithSize = (Int, List[A])

    val listWithSize: List[ListWithSize] = list.map(xs => xs.length -> xs)

    // Strictly speaking, we need to use stable sorting here.
    // See 'scala.util.Sorting'
    val sortedBySize = listWithSize.sortBy(_._1)

    @tailrec
    def findSizeFrequency(
      xs: List[ListWithSize],
      result: List[(Int, List[ListWithSize])]
    ): List[(Int, List[ListWithSize])] = {
      xs match {
        case head :: tail =>
          val (packed, rest) = tail.span(_._1 == head._1)
          val allPacked = head :: packed

          findSizeFrequency(
            rest,
            (allPacked.size -> allPacked) :: result
          )

        case Nil => result
      }
    }

    findSizeFrequency(sortedBySize, List.empty).sortBy(_._1).flatMap(
      _._2.map(_._2)
    )
  }
}
