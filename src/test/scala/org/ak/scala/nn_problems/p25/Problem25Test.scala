package org.ak.scala.nn_problems.p25

import org.ak.scala.nn_problems.p25.Problem25._
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/21/14 - 4:44 PM
 */
class Problem25Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {

  type PermuteMethod = List[Char] => List[Char]

  test("example test") {

    val srcList = List[Char]('a', 'b', 'c', 'd', 'e', 'f')

    methodsUnderTest.foreach {
      permuteMethod: PermuteMethod =>
        checkLists(
          srcList,
          permuteMethod(srcList)
        )
    }
  }



  test("test various lists") {
    forAll(
      Gen.chooseNum(5, 100).filter(_ > 5)
    ) {
      size =>
        forAll(
          Gen.listOfN(
            size,
            Gen.alphaChar
          ),
          workers(Runtime.getRuntime.availableProcessors() + 1)
        ) {

          list =>

            methodsUnderTest.foreach {
              permuteMethod: PermuteMethod =>
                checkLists(
                  list,
                  permuteMethod(list)
                )
            }
        }
    }
  }


  test("perfect permute") {
    val list = (1 to 9).toList
    val permuted = perfectRandomPermute(list)


    pendingUntilFixed {
      checkLists(
        permuted,
        list
      )
    }
  }


  private def checkLists[T](
    expected: List[T],
    actual: List[T]
  ) {
    actual should have size expected.size
    actual should not contain theSameElementsInOrderAs(expected)

    actual.toSet shouldEqual expected.toSet
  }


  private def methodsUnderTest[T] = {
    randomPermute[T] _ ::
      randomPermuteUsingSort[T] _ ::
      Nil
  }
}
