package org.ak.scala.nn_problems.p12

import org.scalatest.{Matchers, FunSuite}

/**
 * @author antonk
 * @since  8/15/14 - 3:54 PM
 */
class Problem12Test
  extends FunSuite with Matchers {


  test("example test") {
    import Problem12._

    val srcList = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    val expList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)


    decode(srcList) shouldEqual expList
    decodeUsingFoldLeft(srcList) shouldEqual expList
    decodeUsingFoldRight(srcList) shouldEqual expList
    decodeUsingMap(srcList) shouldEqual expList
  }
}
