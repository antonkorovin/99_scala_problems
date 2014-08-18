package org.ak.scala.nn_problems.p15

import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/18/14 - 11:40 AM
 */
class Problem15Test
  extends FunSuite with Matchers {

  test("example test") {
    import org.ak.scala.nn_problems.p15.Problem15._

    val srcList = List('a, 'b, 'c, 'c, 'd)
    val expList = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

    duplicateN(3, srcList) shouldEqual expList
    duplicateNUsingFoldLeft(3, srcList) shouldEqual expList
    duplicateNUsingFoldRight(3, srcList) shouldEqual expList
    duplicateNUsingMap(3, srcList) shouldEqual expList
    duplicateNUsingFlatMap(3, srcList) shouldEqual expList
  }
}
