package org.ak.scala.nn_problems.p50

import org.scalatest.{FunSuite, Matchers}

class Problem50Test
  extends FunSuite
    with Matchers {

  test("smoke") {
    val source = List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))
    val expected = List(("a", "0"), ("b", "101"), ("c", "100"), ("d", "111"), ("e", "1101"), ("f", "1100"))

    val result = Problem50.huffman(source)
    result should contain theSameElementsAs expected
  }
}
