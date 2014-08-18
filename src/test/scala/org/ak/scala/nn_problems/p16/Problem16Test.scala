package org.ak.scala.nn_problems.p16

import org.scalatest.{Matchers, FunSuite}

/**
 * @author antonk
 * @since  8/18/14 - 12:13 PM
 */
class Problem16Test
  extends FunSuite with Matchers {

  test("example test") {
    import Problem16._

    val srcList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val expList = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

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
