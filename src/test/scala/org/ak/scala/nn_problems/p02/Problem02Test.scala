package org.ak.scala.nn_problems.p02

import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/12/14 - 10:32 AM
 */
class Problem02Test
  extends FunSuite
  with Matchers
  with GeneratorDrivenPropertyChecks {


  test("example test") {
    Problem02.penultimateRecursive(List(1, 1, 2, 3, 5, 8)) shouldEqual 5
  }


  test("find penultimate in normal list") {
    forAll(
      Gen.nonEmptyListOf(
        Gen.chooseNum(Int.MinValue, Int.MaxValue)
      )
    ) {
      list =>
        whenever(list.size > 1) {
          Problem02.penultimateRecursive(list) shouldEqual list(list.size - 2)
        }
    }
  }
}
