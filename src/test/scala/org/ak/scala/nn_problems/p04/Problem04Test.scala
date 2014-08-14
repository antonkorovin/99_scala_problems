package org.ak.scala.nn_problems.p04

import org.ak.scala.nn_problems.GenUtil
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/12/14 - 5:46 PM
 */
class Problem04Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {

  test("example test") {
    Problem04.length(
      List(
        1,
        1,
        2,
        3,
        5,
        8
      )
    ) shouldEqual 6
  }


  test("find length in normal list") {
    forAll(
      Gen.listOf(
        GenUtil.chooseAllOfInt()
      )
    ) {
      list =>
        Problem04.length(list) shouldEqual list.size
    }
  }
}
