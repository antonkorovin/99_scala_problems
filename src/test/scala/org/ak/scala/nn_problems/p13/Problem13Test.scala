package org.ak.scala.nn_problems.p13

import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since 8/15/14 - 5:59 PM
 */
class Problem13Test
  extends FunSuite with Matchers {

  test("example test") {
    import Problem13._

    val srcList = List(
      Symbol("a")
      , Symbol("a")
      , Symbol("a")
      , Symbol("a")
      , Symbol("b")
      , Symbol("c")
      , Symbol("c")
      , Symbol("a")
      , Symbol("a")
      , Symbol("d")
      , Symbol("e")
      , Symbol("e")
      , Symbol("e")
      , Symbol("e")
    )

    val expList = List(
      (4, Symbol("a"))
      , (1, Symbol("b"))
      , (2, Symbol("c"))
      , (2, Symbol("a"))
      , (1, Symbol("d"))
      , (4, Symbol("e"))
    )

    encodeDirectTailRec(srcList) shouldEqual expList
    encodeDirectUsingFoldLeft(srcList) shouldEqual expList
    encodeDirectUsingFoldRight(srcList) shouldEqual expList
  }
}
