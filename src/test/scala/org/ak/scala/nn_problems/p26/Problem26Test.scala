package org.ak.scala.nn_problems.p26

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

import Problem26._

/**
 * @author antonk
 * @since  8/21/14 - 6:27 PM
 */
class Problem26Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {


  test("ncr test") {
    ncr(4, 2) shouldEqual 6
    ncr(5, 2) shouldEqual 10
    ncr(6, 2) shouldEqual 15
    ncr(7, 2) shouldEqual 21
    ncr(8, 2) shouldEqual 28

    ncr(4, 3) shouldEqual 4
    ncr(5, 3) shouldEqual 10
    ncr(6, 3) shouldEqual 20
    ncr(7, 3) shouldEqual 35
    ncr(8, 3) shouldEqual 56

    ncr(4, 4) shouldEqual 1
    ncr(5, 4) shouldEqual 5
    ncr(6, 4) shouldEqual 15
    ncr(7, 4) shouldEqual 35
    ncr(8, 4) shouldEqual 70
  }

}
