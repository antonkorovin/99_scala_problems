package org.ak.scala.nn_problems.p18

import org.ak.scala.nn_problems.GenUtil
import org.ak.scala.nn_problems.p18.Problem18._
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/18/14 - 2:23 PM
 */
class Problem18Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {


  test("example test") {
    val srcList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

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
  ) {
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

  }
}
