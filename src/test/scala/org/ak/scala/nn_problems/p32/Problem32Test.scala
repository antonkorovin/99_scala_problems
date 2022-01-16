package org.ak.scala.nn_problems.p32

import org.scalatest.{FunSuite, Matchers}

/**
  * @author antonk
  * @since 10/26/14 - 6:26 AM
  */
class Problem32Test
  extends FunSuite
    with Matchers {

  test("example") {
    Problem32.gcd(36, 63) shouldEqual 9
  }

}
