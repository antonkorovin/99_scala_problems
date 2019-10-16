package org.ak.scala.nn_problems.p14

import org.scalatest.{Matchers, FunSuite}

/**
 * @author antonk
 * @since  8/18/14 - 11:20 AM
 */
class Problem14Test
  extends FunSuite with Matchers {

    test("example test") {
      import Problem14._

      val srcList = List(Symbol("a"), Symbol("b"), Symbol("c"), Symbol("c"), Symbol("d"))
      val expList = List(
        Symbol("a")
        , Symbol("a")
        , Symbol("b")
        , Symbol("b")
        , Symbol("c")
        , Symbol("c")
        , Symbol("c")
        , Symbol("c")
        , Symbol("d")
        , Symbol("d")
      )

      duplicate(srcList) shouldEqual expList
      duplicateUsingFoldLeft(srcList) shouldEqual expList
      duplicateUsingFoldRight(srcList) shouldEqual expList
      duplicateUsingMap(srcList) shouldEqual expList
      duplicateUsingFlatMap(srcList) shouldEqual expList
    }
}
