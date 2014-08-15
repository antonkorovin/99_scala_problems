package org.ak.scala.nn_problems.p09

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/15/14 - 11:18 AM
 */
class Problem09Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {

  test("example test") {
    val srcList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expList = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

    import org.ak.scala.nn_problems.p09.Problem09._

    packTailRecursive(srcList) shouldEqual expList
    packUsingTakeAndDropWhile(srcList) shouldEqual expList
    packUsingSpan(srcList) shouldEqual expList
    packUsingFoldLeft(srcList) shouldEqual expList
    packUsingFoldRight(srcList) shouldEqual expList
  }
}
