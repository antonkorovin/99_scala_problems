package org.ak.scala.nn_problems.p07

import org.ak.scala.nn_problems.GenUtil
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/13/14 - 2:06 PM
 */
class Problem07Test extends FunSuite
with Matchers
with GeneratorDrivenPropertyChecks {

  val srcList = List(List(1, 1), 2, List(3, List(5, 8)))
  val expList = List(1, 1, 2, 3, 5, 8)


  test("example test") {
    Problem07.flatten(srcList) shouldEqual expList
    Problem07.flattenThroughFlatMapMap(srcList) shouldEqual expList
  }


  test("flatten plain lists") {
    forAll(
      Gen.nonEmptyListOf(
        GenUtil.chooseAllOfInt()
      )
    ) {
      list =>
        Problem07.flatten(list) shouldEqual list
        Problem07.flattenThroughFlatMapMap(list) shouldEqual list
    }
  }
}
