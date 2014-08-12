package org.ak.scala.nn_problems.p03

import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/12/14 - 2:19 PM
 */
class Problem03Test extends FunSuite
with Matchers
with GeneratorDrivenPropertyChecks {

  test("example test") {
    Problem03.nth(2, List(1, 1, 2, 3, 5, 8)) shouldEqual 2
  }


  test("find nth element in normal list") {
    forAll(
      Gen.nonEmptyListOf(
        Gen.chooseNum(Int.MinValue, Int.MaxValue)
      )
    ) {
      list =>
        forAll(Gen.chooseNum(0, list.size - 1)) {
          index =>
            Problem03.nth(index, list) shouldEqual list(index)
        }
    }
  }


  test("find nth element in empty list") {
    forAll(
      Gen.oneOf(List.empty, Nil, List())
    ) {
      anEmptyList => {
        forAll(
          Gen.chooseNum(Int.MinValue, Int.MaxValue)
        ) {
          index => {
            intercept[IndexOutOfBoundsException] {
              Problem03.nth(index, anEmptyList)
            }
          }
        }
      }
    }
  }


  test("find nth (out-of-bound) element in normal list") {
    forAll(
      Gen.nonEmptyListOf(
        Gen.chooseNum(Int.MinValue, Int.MaxValue)
      )
    ) {
      list => {

        forAll(
          Gen.chooseNum(
            list.size,
            Int.MaxValue
          )
        ) {
          index => {

            intercept[IndexOutOfBoundsException] {
              Problem03.nth(index, list)
            }

          }
        }

      }
    }
  }
}
