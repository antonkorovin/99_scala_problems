package org.ak.scala.nn_problems.p09

import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/15/14 - 11:18 AM
 */
class Problem09Test
  extends FunSuite with Matchers {

  test("example test") {
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
      List(Symbol("a"), Symbol("a"), Symbol("a"), Symbol("a"))
      , List(Symbol("b"))
      , List(Symbol("c"), Symbol("c"))
      , List(Symbol("a"), Symbol("a"))
      , List(Symbol("d"))
      , List(Symbol("e"), Symbol("e"), Symbol("e"), Symbol("e"))
    )

    import org.ak.scala.nn_problems.p09.Problem09._

    packTailRecursive(srcList) shouldEqual expList
    packUsingTakeAndDropWhile(srcList) shouldEqual expList
    packUsingSpan(srcList) shouldEqual expList
    packUsingFoldLeft(srcList) shouldEqual expList
    packUsingFoldRight(srcList) shouldEqual expList
  }
}
