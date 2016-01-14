package org.ak.scala.nn_problems.p35

import org.ak.scala.nn_problems.arithmetic.S99Int._
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  11/2/14 - 1:36 PM
 */
class Problem35Test
  extends FunSuite
          with Matchers {

  test("example") {
    pendingUntilFixed {

      315.primeFactors shouldEqual List(3, 3, 5, 7)

    }
  }

}
