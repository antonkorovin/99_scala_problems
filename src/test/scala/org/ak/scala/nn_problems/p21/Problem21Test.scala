package org.ak.scala.nn_problems.p21

import org.ak.scala.nn_problems.GenUtil
import org.ak.scala.nn_problems.p21.Problem21._
import org.scalacheck.Gen
import org.scalatest.{FunSuite, Matchers}
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

import scala.util.Random

/**
 * @author antonk
 * @since 8/19/14 - 2:23 PM
 */
class Problem21Test
  extends FunSuite
    with Matchers
    with ScalaCheckDrivenPropertyChecks {

  test("example test") {
    val srcList = List(Symbol("a"), Symbol("b"), Symbol("c"), Symbol("d"))
    val expList = List(Symbol("a"), Symbol("new"), Symbol("b"), Symbol("c"), Symbol("d"))


    insertAt(
      Symbol("new"),
      1,
      srcList
    ) shouldEqual expList

    insertAtUsingTakeAndDrop(
      Symbol("new"),
      1,
      srcList
    ) shouldEqual expList


    insertAtUsingSplitAt(
      Symbol("new"),
      1,
      srcList
    ) shouldEqual expList
  }


  test("various lists") {
    def checkFirstAndLast[T](
      element: T,
      srcList: List[T],
      functions:  ((Any, Int, List[Any]) => List[Any]) *
    ): Unit = {
      functions.foreach{
        f =>
          f(
            element,
            0,
            srcList
          ) shouldEqual (element +: srcList)


          f(
            element,
            srcList.size,
            srcList
          ) shouldEqual (srcList :+ element)
      }
    }


    forAll(
      Gen.listOf(
        GenUtil.chooseAllOfInt()
      ),
      minSize(0),
      sizeRange(100)
    ) {
      list =>
        val element = Random.nextInt(100)

        checkFirstAndLast(
          element,
          list,
          insertAt,
          insertAtUsingTakeAndDrop,
          insertAtUsingSplitAt
        )
    }
  }
}
