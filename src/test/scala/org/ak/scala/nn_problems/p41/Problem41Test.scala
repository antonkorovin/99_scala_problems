package org.ak.scala.nn_problems.p41

import org.scalatest.{FunSuite, Matchers}

class Problem41Test
  extends FunSuite
    with Matchers {

  import Problem41._

  test("smoke") {
    goldbachList(9 to 20) should contain theSameElementsInOrderAs Seq(
      3 -> 7,
      5 -> 7,
      3 -> 11,
      3 -> 13,
      5 -> 13,
      3 -> 17
    )
  }

  test("smoke limited") {
    goldbachListLimited(1 to 2000, 50) should contain theSameElementsInOrderAs Seq(
      73 -> 919,
      61 -> 1321,
      67 -> 1789,
      61 -> 1867
    )
  }
}
