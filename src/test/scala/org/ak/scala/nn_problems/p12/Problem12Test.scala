package org.ak.scala.nn_problems.p12

import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since 8/15/14 - 3:54 PM
 */
class Problem12Test
  extends FunSuite with Matchers {


  test("example test") {
    import Problem12._

    val srcList = List(
      (4, Symbol("a"))
      , (1, Symbol("b"))
      , (2, Symbol("c"))
      , (2, Symbol("a"))
      , (1, Symbol("d"))
      , (4, Symbol("e"))
    )
    val expList = List(
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


    decode(srcList) shouldEqual expList
    decodeUsingFoldLeft(srcList) shouldEqual expList
    decodeUsingFoldRight(srcList) shouldEqual expList
    decodeUsingMap(srcList) shouldEqual expList
  }
}
