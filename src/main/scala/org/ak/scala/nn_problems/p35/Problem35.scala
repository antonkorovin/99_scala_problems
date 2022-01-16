package org.ak.scala.nn_problems.p35


import scala.annotation.tailrec

/**
  * @author antonk
  * @since 11/2/14 - 1:35 PM
  */
object Problem35 {
  //  P35 (**) Determine the prime factors of a given positive integer.
  //  Construct a flat list containing the prime factors in ascending order.
  //    scala> 315.primeFactors
  //  res0: List[Int] = List(3, 3, 5, 7)

  def primeFactorsCount(n: Int): List[Int] = {
    primesUnder(n).flatMap { p =>
      Seq.fill(
        primeFactorsCount(n, p)
      )(p)
    }
  }


  @tailrec
  def primeFactorsCount(
    n: Int,
    p: Int,
    factorsCount: Int = 0
  ): Int = {
    if (p == 1) {
      1
    } else if (n % p != 0) {
      factorsCount
    } else {
      primeFactorsCount(
        n / p,
        p,
        factorsCount + 1
      )
    }
  }

  def primesUnder(n: Int): List[Int] = {
    require(n >= 1)

    def isPrime(num: Int, factors: List[Int]) = factors.forall(p => p == 1 || num % p != 0)


    @tailrec
    def primesUnderRec(i: Int, primes: List[Int]): List[Int] = {
      if (i > n) {
        primes
      } else if (isPrime(i, primes)) {
        primesUnderRec(i + 1, i :: primes)
      } else {
        primesUnderRec(i + 1, primes)
      }
    }

    primesUnderRec(1, List()).reverse
  }

}
