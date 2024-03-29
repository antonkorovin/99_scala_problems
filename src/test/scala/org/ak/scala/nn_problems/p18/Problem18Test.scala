package org.ak.scala.nn_problems.p18

import org.ak.scala.nn_problems.GenUtil
import org.ak.scala.nn_problems.p18.Problem18._
import org.scalacheck.Gen
import org.scalatest.{FunSuite, Matchers}
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

/**
  * @author antonk
  * @since 8/18/14 - 2:23 PM
  */
class Problem18Test
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
      7
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
          Gen.chooseNum(0, list.size)
        ) {
          from =>

            forAll(
              Gen.chooseNum(from, list.size)
            ) {
              until =>

                check(
                  list,
                  from,
                  until
                )

            }
        }
    }
  }


  private def check[T](
    list: List[T],
    from: Int,
    until: Int
  ): Unit = {
    slice(
      from,
      until,
      list
    ) shouldEqual list.slice(from, until)


    sliceUsingIfGuards(
      from,
      until,
      list
    ) shouldEqual list.slice(from, until)


    sliceUsingDropAndTake(
      from,
      until,
      list
    ) shouldEqual list.slice(from, until)

    sliceUsingBuiltinSlice(
      from,
      until,
      list
    ) shouldEqual list.slice(from, until)
  }
}
