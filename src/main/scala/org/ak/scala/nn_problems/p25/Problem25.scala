package org.ak.scala.nn_problems.p25

import org.ak.scala.nn_problems.p23.Problem23

import scala.util.Random

/**
 * @author antonk
 * @since  8/21/14 - 4:35 PM
 */
object Problem25 {
  //  P25 (*) Generate a random permutation of the elements of a list.
  //    Hint: Use the solution of problem P23.
  //  Example:
  //
  //    scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
  //  res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)

  // Efficient purely functional algorithms for shuffling are a lot harder.
  // One is described in http://okmij.org/ftp/Haskell/perfect-shuffle.txt
  // using Haskell. Implementing it in Scala is left as an exercise for the reader.
  // TODO Implement it here

  def randomPermute[T](list: List[T]) = {
    Problem23.randomSelect(
      list.size,
      list
    )
  }


  def randomPermuteUsingSort[T](list: List[T]) = {
    list.zip(
      Stream.continually(Random.nextInt())
    ).sortWith(_._2 < _._2).map(_._1)
  }
  sealed trait BinaryTree[+T]

  case class Node[T](
    value: T,
    left: BinaryTree[T],
    right: BinaryTree[T]
  ) extends BinaryTree[T]


  case class Leaf[T](value: T) extends BinaryTree[T]


  case object EmptyLeaf extends BinaryTree[Nothing]
}
