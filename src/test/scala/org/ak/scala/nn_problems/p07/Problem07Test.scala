package org.ak.scala.nn_problems.p07

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/13/14 - 2:06 PM
 */
class Problem07Test extends FunSuite
with Matchers
with GeneratorDrivenPropertyChecks {

  test("example test") {
    Problem07.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) shouldEqual List(1, 1, 2, 3, 5, 8)
  }

}
