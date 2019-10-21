package org.ak.scala.nn_problems.arithmetic

import org.scalatest.{FunSuite, Matchers}

class PrimesTest
  extends FunSuite
    with Matchers {

  for (n <- -1 to 2) {
    registerTest(s"from $n") {
      checkFirstThreePrimes(Primes.streamFrom(n))
    }
  }

  test("from 3") {
    checkPrimes(
      Primes.streamFrom(3),
      Seq(3, 5, 7)
    )
  }

  test("from 4") {
    checkPrimes(
      Primes.streamFrom(4),
      Seq(5, 7, 11)
    )
  }

  test("from 5") {
    checkPrimes(
      Primes.streamFrom(4),
      Seq(5, 7, 11)
    )
  }

  test("from 6") {
    checkPrimes(
      Primes.streamFrom(6),
      Seq(7, 11, 13)
    )
  }

  test("from 7") {
    checkPrimes(
      Primes.streamFrom(7),
      Seq(7, 11, 13)
    )
  }

  test("from 8") {
    checkPrimes(
      Primes.streamFrom(8),
      Seq(11, 13, 17)
    )
  }

  private def checkPrimes(s: LazyList[Int], expected: Seq[Int]): Unit = {
    s.take(expected.size).toList should contain theSameElementsInOrderAs expected
  }

  private def checkFirstThreePrimes(s: LazyList[Int]): Unit = {
    checkPrimes(s, Seq(2, 3, 5))
  }
}
