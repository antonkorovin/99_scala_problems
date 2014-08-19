package org.ak.scala.nn_problems.p19

import org.ak.scala.nn_problems.GenUtil
import org.ak.scala.nn_problems.p19.Problem19._
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/19/14 - 2:23 PM
 */
class Problem19Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {


  test("example test") {
    val srcList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

    val expPosList = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
    val expNegList = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)


    check(
      srcList,
      3,
      expPosList,
      rotate,
      rotateUsingDropAndTake
    )


    check(
      srcList,
      -2,
      expNegList,
      rotate,
      rotateUsingDropAndTake,
      rotateUsingSplitAt
    )
  }



  test("various lists") {
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

        check(
          list,
          list.size,
          list,
          rotate,
          rotateUsingDropAndTake,
          rotateUsingSplitAt
        )
    }
  }



  // TODO: Find out better way than using Any
  type RotateFunction = (Int, List[Any]) => List[Any]

  private def check[T](
    srcList: List[T],
    n: Int,
    expList: List[T],
    functions: RotateFunction*
  ) {
    functions.foreach {
      rotateFun =>
        rotateFun(n, srcList) shouldEqual expList
    }
  }
}
