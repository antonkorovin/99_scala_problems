package org.ak.scala.nn_problems.p25

import org.ak.scala.nn_problems.p25.Problem25.randomPermute
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{Matchers, FunSuite}

/**
 * @author antonk
 * @since  8/21/14 - 4:44 PM
 */
class Problem25Test
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {

  test("example test") {
    val srcList = List('a, 'b, 'c, 'd, 'e, 'f)
    val resList = randomPermute(srcList)

    println(resList.mkString)

    resList should have size srcList.size
    resList should not be equal(srcList)
  }
}
