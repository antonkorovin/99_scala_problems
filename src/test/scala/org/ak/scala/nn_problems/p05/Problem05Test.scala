package org.ak.scala.nn_problems.p05

import org.ak.scala.nn_problems.GenUtil
import org.scalacheck.Gen
import org.scalatest.{FunSuite, Matchers}
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

/**
  * @author antonk
  * @since 8/13/14 - 12:04 PM
  */
class Problem05Test
  extends FunSuite
    with Matchers
    with ScalaCheckDrivenPropertyChecks {


  test("example test") {
    Problem05.reverse(
      List(
        1,
        1,
        2,
        3,
        5,
        8
      )
    ) shouldEqual List(
      8,
      5,
      3,
      2,
      1,
      1
    )
  }


  test("reverse normal list") {
    forAll(
      Gen.listOf(
        GenUtil.chooseAllOfInt()
      )
    ) {
      list =>
        Problem05.reverse(list) shouldEqual list.reverse
    }
  }
}
