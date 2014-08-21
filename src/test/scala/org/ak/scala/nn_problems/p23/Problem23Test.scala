package org.ak.scala.nn_problems.p23

import org.ak.scala.nn_problems.p23.Problem23._
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{Matchers, FunSuite}

/**
 * @author antonk
 * @since  8/21/14 - 3:05 PM
 */
class Problem23Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {
  test("example test") {
    val srcList = List('a, 'b, 'c, 'd, 'f, 'g, 'h)

    val selected = randomSelect(
      3,
      srcList
    )

    selected should have size 3
    srcList.intersect(selected) should have size 3
    srcList.intersect(selected) should contain theSameElementsAs selected
    selected.intersect(srcList) should contain theSameElementsAs selected

    val permuted = randomSelect(
      srcList.size,
      srcList
    )

    permuted should have size srcList.size
    srcList.intersect(permuted) should have size srcList.size
    srcList.intersect(permuted) should contain theSameElementsAs permuted
    permuted.intersect(srcList) should contain theSameElementsAs permuted
  }
}
