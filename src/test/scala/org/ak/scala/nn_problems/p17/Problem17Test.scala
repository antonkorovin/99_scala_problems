package org.ak.scala.nn_problems.p17

import org.ak.scala.nn_problems.GenUtil
import org.ak.scala.nn_problems.p17.Problem17._
import org.scalacheck.Gen
import org.scalatest.{FunSuite, Matchers}
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

/**
 * @author antonk
 * @since  8/18/14 - 2:23 PM
 */
class Problem17Test
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

    check(
      srcList,
      3,
      srcList.splitAt(3)
    )
  }



  test("various lists") {
    forAll(
      Gen.nonEmptyListOf(
        GenUtil.chooseAllOfInt()
      )
    ) {
      list =>
        forAll(
          Gen.chooseNum(1, list.size)
        ) {
          n =>
            check(
              list,
              n,
              list.splitAt(n)
            )
        }
    }
  }


  private def check[T](
    list: List[T],
    n: Int,
    expected: (List[T], List[T])
  ): Unit = {
    split(
      n,
      list
    ) shouldEqual expected


    splitV2(
      n,
      list
    ) shouldEqual expected


    splitUsingTakeAndDrop(
      n,
      list
    ) shouldEqual expected
  }
}
