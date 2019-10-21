package org.ak.scala.nn_problems.p40

import org.scalatest.{FunSuite, Matchers}

class Problem40Test
  extends FunSuite
    with Matchers {

  test("smoke") {
    pendingUntilFixed {
      Problem40.goldbachConjecture(28) shouldBe (5 -> 23)
    }
  }

}
