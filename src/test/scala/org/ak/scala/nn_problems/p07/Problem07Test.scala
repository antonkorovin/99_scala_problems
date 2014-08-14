package org.ak.scala.nn_problems.p07

import org.ak.scala.nn_problems.GenUtil
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/13/14 - 2:06 PM
 */
class Problem07Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {

  private[this] val srcList = List(
    List(
      1,
      1
    ),
    2,
    List(
      3,
      List(
        5,
        8
      )
    )
  )
  private[this] val expList = List(
    1,
    1,
    2,
    3,
    5,
    8
  )


  test("example test recursive") {
    Problem07.flatten(srcList) shouldEqual expList
  }



  test("example test through flat map") {
    Problem07.flattenThroughFlatMap(srcList) shouldEqual expList
  }



  test("example test pseudo tail recursive") {
    Problem07.flattenPseudoTailRecursive(srcList) shouldEqual expList
  }



  test("example test iterative") {
    Problem07.flattenIterative(srcList) shouldEqual expList
  }



  test("flatten plain lists") {
    forAll(
      Gen.nonEmptyListOf(
        GenUtil.chooseAllOfInt()
      )
    ) {
      list =>
        Problem07.flatten(list) shouldEqual list
        Problem07.flattenThroughFlatMap(list) shouldEqual list
        Problem07.flattenPseudoTailRecursive(list) shouldEqual list
        Problem07.flattenIterative(list) shouldEqual list
    }
  }
}
