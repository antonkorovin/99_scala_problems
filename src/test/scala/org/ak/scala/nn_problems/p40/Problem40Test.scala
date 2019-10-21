package org.ak.scala.nn_problems.p40

import org.ak.scala.nn_problems.arithmetic._
import org.scalacheck.Gen
import org.scalatest.{FunSuite, Matchers}
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class Problem40Test
  extends FunSuite
    with Matchers
    with ScalaCheckDrivenPropertyChecks {

  test("smoke") {
    Problem40.goldbachConjecture(28) shouldBe (5 -> 23)
  }


  test("property-based check") {
    val minValue = 2
    val maxValue = 10

    forAll(Gen.chooseNum(minValue, maxValue)) {
      n =>
        val evenValue = 2 * n

        val (k, m) = Problem40.goldbachConjecture(evenValue)

        k.isPrime shouldBe true
        m.isPrime shouldBe true

        k + m shouldBe evenValue
    }
  }

}
