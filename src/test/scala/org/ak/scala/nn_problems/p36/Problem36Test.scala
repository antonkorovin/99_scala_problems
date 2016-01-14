package org.ak.scala.nn_problems.p36

import org.ak.scala.nn_problems.arithmetic.S99Int._
import org.scalatest.{Matchers, FunSuite}

/**
 * @author antonk
 * @since  1/14/16 - 8:22 PM
 */
class Problem36Test
  extends FunSuite
  with Matchers {


  test("example") {

    315.primeFactorMultiplicity shouldEqual Map(3 -> 2, 5 -> 1, 7 -> 1)

  }

}
