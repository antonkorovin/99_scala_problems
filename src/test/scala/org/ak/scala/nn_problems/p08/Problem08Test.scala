package org.ak.scala.nn_problems.p08

import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/14/14 - 5:17 PM
 */
class Problem08Test
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
      Symbol("a")
      , Symbol("b")
      , Symbol("c")
      , Symbol("a")
      , Symbol("d")
      , Symbol("e")
    )

    import org.ak.scala.nn_problems.p08.Problem08._

    compressTailRec(srcList) shouldEqual expList
    compressTailRecUsingDropWhile(srcList) shouldEqual expList
    compressUsingFoldLeft(srcList) shouldEqual expList
    compressUsingFoldRight(srcList) shouldEqual expList
  }
}
