package org.ak.scala.nn_problems.p34

import org.ak.scala.nn_problems.arithmetic.S99Int._
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  11/2/14 - 1:26 PM
 */
class Problem34Test
  extends FunSuite
          with Matchers {

  test("example") {
    10.totient shouldEqual 4
  }

}
