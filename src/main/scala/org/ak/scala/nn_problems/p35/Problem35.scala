package org.ak.scala.nn_problems.p35

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  11/2/14 - 1:35 PM
 */
object Problem35 {
  //  P35 (**) Determine the prime factors of a given positive integer.
  //  Construct a flat list containing the prime factors in ascending order.
  //    scala> 315.primeFactors
  //  res0: List[Int] = List(3, 3, 5, 7)

  def primeFactors(n: Int): List[Int] = {
    primesUnder(n).flatMap { p =>
      primeFactors(n, p)
    }
  }


  @tailrec
  private def primeFactors(
    n: Int,
    p: Int,
    factors: List[Int] = List.empty
  ): List[Int] = {
    if (n % p != 0) {
      factors
    } else {
      primeFactors(
        n / p,
        p,
        p :: factors
      )
    }
  }

  private def primesUnder(n: Int): List[Int] = {
    require(n >= 2)

    def isPrime(num: Int, factors: List[Int]) = factors.forall(num % _ != 0)


    @tailrec
    def primesUnderRec(i: Int, primes: List[Int]): List[Int] = {
      if (i >= n) {
        primes
      } else if (isPrime(i, primes)) {
        primesUnderRec(i + 1, i :: primes)
      } else {
        primesUnderRec(i + 1, primes)
      }
    }

    primesUnderRec(2, List()).reverse
  }

}
