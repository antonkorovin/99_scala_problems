package org.ak.scala.nn_problems.p02

import java.util.NoSuchElementException
import scala.annotation.tailrec

/**
  * @author antonk
  * @since 8/12/14 - 10:30 AM
  */
object Problem02 {
  //  P02 (*) Find the last but one element of a list.
  //  Example:
  //    scala> penultimate(List(1, 1, 2, 3, 5, 8))
  //  res0: Int = 5


  @tailrec
  def penultimateRecursive[T](list: List[T]): T = list match {
    // Empty and one element list are not acceptable
    case Nil | _ :: Nil =>
      throw new NoSuchElementException

    case penultimate :: _ :: Nil =>
      penultimate

    case _ :: tail =>
      penultimateRecursive(tail)
  }
}
