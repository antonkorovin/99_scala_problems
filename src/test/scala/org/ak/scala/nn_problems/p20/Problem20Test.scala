package org.ak.scala.nn_problems.p20

import java.util.NoSuchElementException

import org.ak.scala.nn_problems.GenUtil
import org.ak.scala.nn_problems.p20.Problem20.removeAt
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/19/14 - 2:23 PM
 */
class Problem20Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {


  test("example test") {
    val srcList = List('a, 'b, 'c, 'd)
    val expList = (List('a, 'c, 'd), 'b)


    removeAt(
      1,
      srcList
    ) shouldEqual expList
  }


  test("boundaries control") {
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

        forAll(Gen.choose(Int.MinValue, -1)) {
          n =>
            intercept[NoSuchElementException] {
              removeAt(
                n,
                list
              )
            }
        }


        forAll(Gen.choose(list.size, Int.MaxValue)) {
          n =>
            intercept[NoSuchElementException] {
              removeAt(
                n,
                list
              )
            }
        }
    }
  }



  test("first/last element control") {
    forAll(
      Gen.nonEmptyListOf(
        GenUtil.chooseAllOfInt()
      ),
      maxSize(100),
      maxDiscarded(0),
      workers(Runtime.getRuntime.availableProcessors() + 1)
    ) {
      list =>
        removeAt(
          0,
          list
        ) shouldEqual (list.tail, list.head)


        removeAt(
          list.size - 1,
          list
        ) shouldEqual (list.init, list.last)
    }
  }
}
