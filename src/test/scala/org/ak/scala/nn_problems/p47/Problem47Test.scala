package org.ak.scala.nn_problems.p47

import org.ak.scala.nn_problems.p46.Problem46.{LogicalFunction, printTable2, table2}
import org.scalatest.{FunSuite, Matchers}

class Problem47Test
  extends FunSuite
    with Matchers {

  import Problem47._

  val f: LogicalFunction = (a, b) => a and (a or b.negated)

  test("printTable2") {
    printTable2(f)
  }

  test("check table2 format") {
    val expected =
      """A     B     result
        |true  true  true
        |true  false true
        |false true  false
        |false false false
        |""".stripMargin

    val t = table2(f)

    t shouldEqual expected
  }
}
