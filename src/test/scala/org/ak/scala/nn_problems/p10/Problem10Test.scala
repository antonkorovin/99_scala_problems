package org.ak.scala.nn_problems.p10

import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/15/14 - 3:14 PM
 */
class Problem10Test
  extends FunSuite with Matchers {


  test("example test") {
    import org.ak.scala.nn_problems.p10.Problem10._

    val srcList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expList = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))


    encodeTailRecursive(srcList) shouldEqual expList
    encodeUsingFor(srcList) shouldEqual expList
    encodeUsingMap(srcList) shouldEqual expList
    encodeUsingFoldLeft(srcList) shouldEqual expList
    encodeUsingFoldRight(srcList) shouldEqual expList
  }
}
