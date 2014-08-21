package org.ak.scala.nn_problems.p21

import org.ak.scala.nn_problems.GenUtil
import org.ak.scala.nn_problems.p21.Problem21._
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

import scala.util.Random

/**
 * @author antonk
 * @since  8/19/14 - 2:23 PM
 */
class Problem21Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks{
  test("example test") {
    val srcList = List('a, 'b, 'c, 'd)
    val expList = List('a, 'new, 'b, 'c, 'd)


    insertAt(
      'new,
      1,
      srcList
    ) shouldEqual expList
  }


  test("various lists") {
    def checkFirstAndLast[T](
      element: T,
      srcList: List[T],
      functions:  ((Any, Int, List[Any]) => List[Any]) *
    ) {
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
      maxSize(100),
      maxDiscarded(0),
      workers(Runtime.getRuntime.availableProcessors() + 1)
    ) {
      list =>
        val element = Random.nextInt(100)

        checkFirstAndLast(
          element,
          list,
          insertAt
        )
    }
  }
}
