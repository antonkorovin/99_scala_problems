package org.ak.scala.nn_problems.p22

import org.ak.scala.nn_problems.p22.Problem22._
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/21/14 - 2:23 PM
 */
class Problem22Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {
  test("example test") {
    val expList = List(4, 5, 6, 7, 8, 9)

    range(4, 9) shouldEqual expList
  }


  test("various lists") {

    forAll(
      Gen.chooseNum(0, 1000)
    ) {
      start =>
        forAll(
          Gen.chooseNum(start, start * 2),
          workers(Runtime.getRuntime.availableProcessors() + 1)
        ) {
          finish =>
            range(
              start,
              finish
            ) shouldEqual (start to finish).toList
        }
    }
  }
}
