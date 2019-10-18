package org.ak.scala.nn_problems.p39

import org.scalatest.{FunSuite, Matchers}

class Problem39Test
  extends FunSuite
    with Matchers {


  test("smoke test") {
    pendingUntilFixed {
      Problem39.listPrimesInRange(7 to 31) shouldBe List(7, 11, 13, 17, 19, 23, 29, 31)
    }
  }
}
