package org.ak.scala.nn_problems.p16

import org.scalatest.{FunSuite, Matchers}

/**
  * @author antonk
  * @since 8/18/14 - 12:13 PM
  */
class Problem16Test
  extends FunSuite
    with Matchers {

  test("example test") {
    import Problem16._

    val srcList = List(
      Symbol("a")
      , Symbol("b")
      , Symbol("c")
      , Symbol("d")
      , Symbol("e")
      , Symbol("f")
      , Symbol("g")
      , Symbol("h")
      , Symbol("i")
      , Symbol("j")
      , Symbol("k")
    )
    val expList = List(
      Symbol("a")
      , Symbol("b")
      , Symbol("d")
      , Symbol("e")
      , Symbol("g")
      , Symbol("h")
      , Symbol("j")
      , Symbol("k")
    )

    drop(
      3,
      srcList
    ) shouldEqual
      expList


    dropV2(
      3,
      srcList
    ) shouldEqual
      expList


    dropUsingForAndZipWithIndex(
      3,
      srcList
    ) shouldEqual
      expList


    dropUsingFilterAndZipWithIndex(
      3,
      srcList
    ) shouldEqual
      expList
  }
}
