package org.ak.scala.nn_problems.p19

import org.ak.scala.nn_problems.GenUtil
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

import Problem19._

/**
 * @author antonk
 * @since  8/19/14 - 2:23 PM
 */
class Problem19Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {


  test("example test") {
    val srcList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

    val expPosList = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)


    rotate(
      3,
      srcList
    ) shouldEqual expPosList



//    rotate(
//      -2,
//      List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
//    ) shouldEqual List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
  }



  test("various lists") {
    forAll (
      Gen.listOf(
        GenUtil.chooseAllOfInt()
      ),
      minSize(0),
      maxSize(10),
      maxDiscarded(0),
      workers(Runtime.getRuntime.availableProcessors() + 1)
    ) {
      list =>

        rotate(
          list.size,
          list
        ) shouldEqual list
    }
  }
}
