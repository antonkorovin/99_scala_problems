package org.ak.scala.nn_problems.p11

import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since 8/15/14 - 3:43 PM
 */
class Problem11Test
  extends FunSuite with Matchers {


  test("example test") {
    import Problem11._

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
      , Symbol("b")
      , (2, Symbol("c"))
      , (2, Symbol("a"))
      , Symbol("d")
      , (4, Symbol("e"))
    )


    encodeTailRecursive(srcList) shouldEqual expList
    encodeUsingFor(srcList) shouldEqual expList
    encodeUsingMap(srcList) shouldEqual expList
    encodeUsingFoldLeft(srcList) shouldEqual expList
    encodeUsingFoldRight(srcList) shouldEqual expList
  }
}
