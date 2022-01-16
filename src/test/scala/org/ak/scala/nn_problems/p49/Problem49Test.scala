package org.ak.scala.nn_problems.p49

import org.scalatest.{FunSuite, Matchers}

class Problem49Test
  extends FunSuite
    with Matchers {

  test("smoke") {
    val expected = List("000", "001", "011", "010", "110", "111", "101", "100")

    Problem49.gray(3) should contain theSameElementsInOrderAs expected
  }
}
