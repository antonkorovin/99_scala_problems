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





  private def checkLists[T](
    expected: List[T],
    actual: List[T]
  ) {
    actual should have size expected.size
    actual should not be equal(expected)

    actual.toSet shouldEqual expected.toSet
  }


  private def methodsUnderTest[T] = {
    randomPermute[T] _ ::
      randomPermuteUsingSort[T] _ ::
      Nil
  }
}
