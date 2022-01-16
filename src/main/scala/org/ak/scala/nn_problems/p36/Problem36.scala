package org.ak.scala.nn_problems.p36

import org.ak.scala.nn_problems.p35.Problem35

/**
  * @author antonk
  * @since 1/14/16 - 8:20 PM
  */
object Problem36 {
  //  (**) Determine the prime factors of a given positive integer (2).
  //    Construct a list containing the prime factors and their multiplicity.
  //  scala> 315.primeFactorMultiplicity
  //  res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))
  //  Alternately, use a Map for the result.
  //
  //  scala> 315.primeFactorMultiplicity
  //  res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)


  def primeFactorMultiplicity(n: Int): Map[Int, Int] = {
    Problem35.primesUnder(n).map { p =>
      p -> Problem35.primeFactorsCount(n, p)
    }.filter(_._2 != 0).toMap
  }

}
