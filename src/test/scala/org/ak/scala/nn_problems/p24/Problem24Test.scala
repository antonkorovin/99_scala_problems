package org.ak.scala.nn_problems.p24

import org.ak.scala.nn_problems.p24.Problem24._
import org.scalacheck.Gen
import org.scalatest.{FunSuite, Matchers}
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

/**
 * @author antonk
 * @since  8/21/14 - 4:22 PM
 */
class Problem24Test
  extends FunSuite
          with Matchers
          with ScalaCheckDrivenPropertyChecks {

  test("example test") {
    val list = lotto(6, 49)


    list should have size 6
    list.max should be < 49
  }


  test("various lists") {
    forAll (
      Gen.chooseNum(1, 1000)
    ) {
      n =>
        forAll (
          Gen.chooseNum(1, Int.MaxValue)
        ) {
          maxValue =>
            val list = lotto(n, maxValue)

            list should have size n
            list.max should be < maxValue
        }
    }
  }
}
