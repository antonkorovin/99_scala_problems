package org.ak.scala.nn_problems.p02

import org.ak.scala.nn_problems.GenUtil
import org.scalacheck.Gen
import org.scalatest.{FunSuite, Matchers}
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

/**
 * @author antonk
 * @since  8/12/14 - 10:32 AM
 */
class Problem02Test
  extends FunSuite
          with Matchers
          with ScalaCheckDrivenPropertyChecks {


  test("example test") {
    Problem02.penultimateRecursive(
      List(
        1,
        1,
        2,
        3,
        5,
        8
      )
    ) shouldEqual 5
  }


  test("find penultimate in normal list") {
    forAll(
      Gen.nonEmptyListOf(
        GenUtil.chooseAllOfInt()
      )
    ) {
      list =>
        whenever(list.size > 1) {
          Problem02.penultimateRecursive(list) shouldEqual list(list.size - 2)
        }
    }
  }
}
