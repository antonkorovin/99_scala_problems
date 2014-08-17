package org.ak.scala.nn_problems.p13

import org.scalatest.{Matchers, FunSuite}

/**
 * @author antonk
 * @since  8/15/14 - 5:59 PM
 */
class Problem13Test
  extends FunSuite with Matchers {

  test("example test") {
    import Problem13._

    val srcList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expList = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

    encodeDirectTailRec(srcList) shouldEqual expList
    encodeDirectUsingFoldLeft(srcList) shouldEqual expList
    encodeDirectUsingFoldRight(srcList) shouldEqual expList
  }
}
