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

            combinations(
              k,
              elements
            ) should have size expSize
        }
    }
  }


  test("combinations content test") {
    val srcList = List('a, 'b, 'c, 'd, 'e, 'f, 'g)
    val groupSize = 5

    val expectedSize = ncr(srcList.size, groupSize)

    println("Group: " + srcList.size + " by " + groupSize)
    println("Expected: " + expectedSize)



    val result = combinations(groupSize, srcList)
    result should not be empty
    result should have size expectedSize



    val delimiter = "-" * (result.head.size * 2 + 3)
    println("Result: " + result.size)
    println(delimiter)

    result.zipWithIndex.foreach {
      c =>
        println("#" + c._2 + " " + c._1.mkString)
    }

    println(delimiter)



    result.foreach {
      r =>
        result.count(_ == r) shouldEqual 1
    }
  }
}
