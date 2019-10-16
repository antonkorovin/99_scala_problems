package org.ak.scala.nn_problems.p10

import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since 8/15/14 - 3:14 PM
 */
class Problem10Test
  extends FunSuite with Matchers {


  test("example test") {
    import org.ak.scala.nn_problems.p10.Problem10._

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


    encodeTailRecursive(srcList) shouldEqual expList
    encodeUsingFor(srcList) shouldEqual expList
    encodeUsingMap(srcList) shouldEqual expList
    encodeUsingFoldLeft(srcList) shouldEqual expList
    encodeUsingFoldRight(srcList) shouldEqual expList
  }
}
