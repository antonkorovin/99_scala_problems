package org.ak.scala.nn_problems.p33


import org.ak.scala.nn_problems.arithmetic.Implicits._
import org.scalatest.{FunSuite, Matchers}

/**
  * @author antonk
  * @since 10/30/14 - 2:24 AM
  */
class Problem33Test
  extends FunSuite
    with Matchers {

  test("example") {
    35.isCoprimeTo(64) shouldBe true
  }

}
