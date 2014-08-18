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

      val srcList = List('a, 'b, 'c, 'c, 'd)
      val expList = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

      duplicate(srcList) shouldEqual expList
      duplicateUsingFoldLeft(srcList) shouldEqual expList
      duplicateUsingFoldRight(srcList) shouldEqual expList
    }
}
