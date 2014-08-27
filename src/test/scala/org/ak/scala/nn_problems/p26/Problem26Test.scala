package org.ak.scala.nn_problems.p26

import org.ak.scala.nn_problems.p26.Problem26._
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/21/14 - 6:27 PM
 */
class Problem26Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {


  test("ncr test") {
    ncr(4, 2) shouldEqual 6
    ncr(5, 2) shouldEqual 10
    ncr(6, 2) shouldEqual 15
    ncr(7, 2) shouldEqual 21
    ncr(8, 2) shouldEqual 28

    ncr(4, 3) shouldEqual 4
    ncr(5, 3) shouldEqual 10
    ncr(6, 3) shouldEqual 20
    ncr(7, 3) shouldEqual 35
    ncr(8, 3) shouldEqual 56

    ncr(4, 4) shouldEqual 1
    ncr(5, 4) shouldEqual 5
    ncr(6, 4) shouldEqual 15
    ncr(7, 4) shouldEqual 35
    ncr(8, 4) shouldEqual 70
  }



  test("combinations length test") {
    val minValue = 1
    val maxValue = 10

    forAll(
      Gen.chooseNum(minValue, maxValue)
    ) {
      n =>
        forAll(
          Gen.chooseNum(minValue, n)
        ) {
          k =>
            val elements = (minValue to n).toList
            val expSize = ncr(n, k)


            for (fun <- combinationFunctions[Int]) {
              fun(
                k,
                elements
              ) should have size expSize
            }
        }
    }
  }


  test("combinations content test") {

    val srcList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
    val groupSize = 5

    val expectedSize = ncr(srcList.size, groupSize)

    for (fun <- combinationFunctions[Symbol]) {
      val result = fun(groupSize, srcList)
      result should not be empty
      result should have size expectedSize


      result.foreach {
        r =>
          result.count(_ == r) shouldEqual 1
      }
    }
  }



  private def combinationFunctions[T] = List(combinations[T] _, combinationsFunctional[T] _)

}
