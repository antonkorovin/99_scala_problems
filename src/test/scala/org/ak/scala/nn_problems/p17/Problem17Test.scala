package org.ak.scala.nn_problems.p17

import org.ak.scala.nn_problems.GenUtil
import org.ak.scala.nn_problems.p17.Problem17._
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/18/14 - 2:23 PM
 */
class Problem17Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {


  test("example test") {
    val srcList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

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
  ) {
    split(
      n,
      list
    ) shouldEqual list.splitAt(n)


    splitV2(
      n,
      list
    ) shouldEqual list.splitAt(n)


    splitUsingTakeAndDrop(
      n,
      list
    ) shouldEqual list.splitAt(n)
  }
}
