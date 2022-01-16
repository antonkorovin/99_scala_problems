package org.ak.scala.nn_problems.p15

import org.scalatest.{FunSuite, Matchers}

/**
  * @author antonk
  * @since 8/18/14 - 11:40 AM
  */
class Problem15Test
  extends FunSuite
    with Matchers {

  test("example test") {
    import org.ak.scala.nn_problems.p15.Problem15._

    val srcList = List(Symbol("a"), Symbol("b"), Symbol("c"), Symbol("c"), Symbol("d"))
    val expList = List(
      Symbol("a")
      , Symbol("a")
      , Symbol("a")
      , Symbol("b")
      , Symbol("b")
      , Symbol("b")
      , Symbol("c")
      , Symbol("c")
      , Symbol("c")
      , Symbol("c")
      , Symbol("c")
      , Symbol("c")
      , Symbol("d")
      , Symbol("d")
      , Symbol("d")
    )

    duplicateN(3, srcList) shouldEqual expList
    duplicateNUsingFoldLeft(3, srcList) shouldEqual expList
    duplicateNUsingFoldRight(3, srcList) shouldEqual expList
    duplicateNUsingMap(3, srcList) shouldEqual expList
    duplicateNUsingFlatMap(3, srcList) shouldEqual expList
  }
}
