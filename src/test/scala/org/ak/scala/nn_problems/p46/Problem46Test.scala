package org.ak.scala.nn_problems.p46

import org.scalatest.{FunSuite, Matchers}

class Problem46Test
  extends FunSuite
    with Matchers {

  import Problem46._

  test("printTable2") {
    printTable2(
      (a, b) => and(or(a, b), nand(a, b))
    )
  }

  test("check table2 format") {
    val expected =
      """A     B     result
        |true  true  false
        |true  false true
        |false true  true
        |false false false
        |""".stripMargin

    val t = table2(
      (a, b) => and(or(a, b), nand(a, b))
    )

    t shouldEqual expected
  }
}
