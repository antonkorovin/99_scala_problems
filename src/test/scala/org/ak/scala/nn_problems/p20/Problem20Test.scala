package org.ak.scala.nn_problems.p20

import org.ak.scala.nn_problems.GenUtil
import org.ak.scala.nn_problems.p20.Problem20._
import org.scalacheck.Gen
import org.scalatest.{FunSuite, Matchers}
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

import java.util.NoSuchElementException

/**
  * @author antonk
  * @since 8/19/14 - 2:23 PM
  */
class Problem20Test
  extends FunSuite
    with Matchers
    with ScalaCheckDrivenPropertyChecks {


  test("example test") {
    val srcList = List(Symbol("a"), Symbol("b"), Symbol("c"), Symbol("d"))
    val expList = (List(Symbol("a"), Symbol("c"), Symbol("d")), Symbol("b"))


    removeAt(
      1,
      srcList
    ) shouldEqual expList


    removeAtUsingSplitAt(
      1,
      srcList
    ) shouldEqual expList


    removeAtUsingTakeAndDrop(
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
      sizeRange(100)
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

            intercept[NoSuchElementException] {
              removeAtUsingSplitAt(
                n,
                list
              )
            }

            intercept[NoSuchElementException] {
              removeAtUsingTakeAndDrop(
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

            intercept[NoSuchElementException] {
              removeAtUsingSplitAt(
                n,
                list
              )
            }


            intercept[NoSuchElementException] {
              removeAtUsingTakeAndDrop(
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
      sizeRange(100)
    ) {
      list =>
        removeAt(
          0,
          list
        ) shouldEqual (list.tail -> list.head)


        removeAt(
          list.size - 1,
          list
        ) shouldEqual (list.init -> list.last)


        removeAtUsingSplitAt(
          0,
          list
        ) shouldEqual (list.tail -> list.head)


        removeAtUsingSplitAt(
          list.size - 1,
          list
        ) shouldEqual (list.init -> list.last)


        removeAtUsingTakeAndDrop(
          0,
          list
        ) shouldEqual (list.tail -> list.head)


        removeAtUsingTakeAndDrop(
          list.size - 1,
          list
        ) shouldEqual (list.init -> list.last)
    }
  }
}
