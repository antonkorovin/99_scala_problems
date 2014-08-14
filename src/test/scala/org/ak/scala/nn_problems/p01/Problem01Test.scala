package org.ak.scala.nn_problems.p01

import java.util.NoSuchElementException

import org.ak.scala.nn_problems.GenUtil
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/11/14 - 11:30 PM
 */
class Problem01Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {

  val srcList = List(
    1,
    1,
    2,
    3,
    5,
    8
  )


  test("example test") {

    Problem01.recursiveLast(
      srcList
    ) shouldEqual 8
    Problem01.iterativeLast(
      srcList
    ) shouldEqual 8
  }


  test("find the last in normal list recursive") {
    import org.ak.scala.nn_problems.p01.Problem01.recursiveLast

    forAll(
      Gen.nonEmptyListOf(
        GenUtil.chooseAllOfInt()
      )
    ) {
      list =>
        recursiveLast(list) shouldEqual list.last
    }
  }


  test("find the last in normal list iterative") {
    import org.ak.scala.nn_problems.p01.Problem01.iterativeLast

    forAll(
      Gen.nonEmptyListOf(
        GenUtil.chooseAllOfInt()
      )
    ) {
      list =>
        iterativeLast(list) shouldEqual list.last
    }
  }



  test("recursive last with empty list") {
    import org.ak.scala.nn_problems.p01.Problem01.recursiveLast

    forAll(
      Gen.oneOf(
        List.empty,
        Nil,
        List()
      )
    ) {
      anEmptyList =>
        intercept[NoSuchElementException] {
          recursiveLast(anEmptyList)
        }
    }
  }



  test("iterative last with empty list") {
    import org.ak.scala.nn_problems.p01.Problem01.iterativeLast

    forAll(
      Gen.oneOf(
        List.empty,
        Nil,
        List()
      )
    ) {
      anEmptyList =>
        intercept[NoSuchElementException] {
          iterativeLast(anEmptyList)
        }
    }
  }
}
