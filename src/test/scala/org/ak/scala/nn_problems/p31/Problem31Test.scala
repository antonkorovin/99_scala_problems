package org.ak.scala.nn_problems.p31

import org.ak.scala.nn_problems.arithmetic.S99Int._
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  10/17/14 - 1:47 AM
 */
class Problem31Test
  extends FunSuite
          with Matchers {

  test("example") {
    1.isPrime shouldBe true
    2.isPrime shouldBe true
    3.isPrime shouldBe true
    4.isPrime shouldBe false
    5.isPrime shouldBe true
    7.isPrime shouldBe true
    8.isPrime shouldBe false
    9.isPrime shouldBe false
    10.isPrime shouldBe false
    11.isPrime shouldBe true
    12.isPrime shouldBe false
    13.isPrime shouldBe true
    14.isPrime shouldBe false
    15.isPrime shouldBe false
    16.isPrime shouldBe false
    17.isPrime shouldBe true
  }

}
