package org.ak.scala.nn_problems.p19

import org.ak.scala.nn_problems.GenUtil
import org.ak.scala.nn_problems.p19.Problem19._
import org.scalacheck.Gen
import org.scalatest.{FunSuite, Matchers}
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

/**
  * @author antonk
  * @since 8/19/14 - 2:23 PM
  */
class Problem19Test
  extends FunSuite
    with Matchers
    with ScalaCheckDrivenPropertyChecks {


  test("example test") {
    val srcList = List(
      Symbol("a")
      , Symbol("b")
      , Symbol("c")
      , Symbol("d")
      , Symbol("e")
      , Symbol("f")
      , Symbol("g")
      , Symbol("h")
      , Symbol("i")
      , Symbol("j")
      , Symbol("k")
    )

    val expPosList = List(
      Symbol("d")
      , Symbol("e")
      , Symbol("f")
      , Symbol("g")
      , Symbol("h")
      , Symbol("i")
      , Symbol("j")
      , Symbol("k")
      , Symbol("a")
      , Symbol("b")
      , Symbol("c")
    )
    val expNegList = List(
      Symbol("j")
      , Symbol("k")
      , Symbol("a")
      , Symbol("b")
      , Symbol("c")
      , Symbol("d")
      , Symbol("e")
      , Symbol("f")
      , Symbol("g")
      , Symbol("h")
      , Symbol("i")
    )


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
      sizeRange(100)
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
  ): Unit = {
    functions.foreach {
      rotateFun =>
        rotateFun(n, srcList) shouldEqual expList
    }
  }
}
