package org.ak.scala.nn_problems.p11

import org.scalatest.{Matchers, FunSuite}

/**
 * @author antonk
 * @since  8/15/14 - 3:43 PM
 */
class Problem11Test
  extends FunSuite with Matchers {


  test("example test") {
    import Problem11._

    val srcList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expList = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))


    encodeTailRecursive(srcList) shouldEqual expList
    encodeUsingFor(srcList) shouldEqual expList
    encodeUsingMap(srcList) shouldEqual expList
    encodeUsingFoldLeft(srcList) shouldEqual expList
    encodeUsingFoldRight(srcList) shouldEqual expList
  }
}
