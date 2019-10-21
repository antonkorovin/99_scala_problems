package org.ak.scala.nn_problems.p40

import org.ak.scala.nn_problems.arithmetic.Primes

object Problem40 {
  // Goldbach's conjecture says that every positive
  // even number greater than 2 is the sum of two prime numbers.
  // E.g. 28 = 5 + 23. It is one of the most famous facts in number theory
  // that has not been proved to be correct in the general case.
  // It has been numerically confirmed up to very large numbers
  // (much larger than Scala's Int can represent).
  // Write a function to find the two prime numbers
  // that sum up to a given even integer.


  def goldbachConjecture(n: Int): (Int, Int) = {
    require(n > 2)
    require(n % 2 == 0)

    val primes = Primes.stream.takeWhile(_ <= n).toList

    val primePairs = Primes.stream.takeWhile(_ <= n).flatMap {
      k =>
        primes.collectFirst {
          case m if m + k == n =>
            k -> m
        }
    }

    require(primePairs.nonEmpty)

    primePairs.head
  }
}
