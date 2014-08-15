package org.ak.scala.nn_problems.p08

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/14/14 - 5:17 PM
 */
class Problem08Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {

  test("example test") {
    val srcList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expList = List('a, 'b, 'c, 'a, 'd, 'e)

    import Problem08._

    compressTailRec(srcList) shouldEqual expList
    compressTailRecUsingDropWhile(srcList) shouldEqual expList
    compressUsingFoldLeft(srcList) shouldEqual expList
    compressUsingFoldRight(srcList) shouldEqual expList
  }
}
