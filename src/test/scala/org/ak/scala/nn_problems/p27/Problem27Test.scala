package org.ak.scala.nn_problems.p27

import org.scalatest.{FunSuite, Matchers}

import scala.io.Source

/**
  * @author antonk
  * @since 8/28/14 - 6:46 PM
  */
class Problem27Test
  extends FunSuite
    with Matchers {

  test("groups count") {
    Problem27.combinationsCount(List(3, 4, 3), 10) shouldBe 4200
  }

  test("group3") {
    val expected = readExpectedListFrom(
      "p-27-test-data.txt"
    )

    val actual = Problem27.group3(
      (1 to 9).toList
    )

    actual.size shouldBe Problem27.combinationsCount(
      List(2, 3, 4),
      9
    )

    actual shouldEqual expected
  }


  test("group (1,1,1), (1..3)") {
    val expected = List(
      List(List(1), List(2), List(3)),
      List(List(1), List(3), List(2)),
      List(List(2), List(1), List(3)),
      List(List(2), List(3), List(1)),
      List(List(3), List(1), List(2)),
      List(List(3), List(2), List(1))
    )

    runTestFor(
      ns = List(1, 1, 1),
      ls = (1 to 3).toList,
      expected
    )
  }


  test("group (1,2), (1..3)") {
    val expected = List(
      List(List(1), List(2, 3))
      , List(List(2), List(1, 3))
      , List(List(3), List(1, 2))
    )

    runTestFor(
      ns = List(1, 2),
      ls = (1 to 3).toList,
      expected
    )
  }


  test("group (3), (1..3)") {
    val expected = List(
      List(List(1, 2), List(3))
      , List(List(1, 3), List(2))
      , List(List(2, 3), List(1))
    )

    runTestFor(
      ns = List(2, 1),
      ls = (1 to 3).toList,
      expected
    )
  }

  test("group (1, 1), (1..5)") {
    val expected = List(
      List(List(1, 2), List(3, 4, 5))
      , List(List(1, 3), List(2, 4, 5))
      , List(List(1, 4), List(2, 3, 5))
      , List(List(1, 5), List(2, 3, 4))
      , List(List(2, 3), List(1, 4, 5))
      , List(List(2, 4), List(1, 3, 5))
      , List(List(2, 5), List(1, 3, 4))
      , List(List(3, 4), List(1, 2, 5))
      , List(List(3, 5), List(1, 2, 4))
      , List(List(4, 5), List(1, 2, 3))
    )

    runTestFor(
      ns = List(2, 3),
      ls = (1 to 5).toList,
      expected
    )
  }


  test("group (2, 1, 2), (1..5)") {
    val expected = List(
      List(List(1, 2), List(3), List(4, 5))
      , List(List(1, 2), List(4), List(3, 5))
      , List(List(1, 2), List(5), List(3, 4))
      , List(List(1, 3), List(2), List(4, 5))
      , List(List(1, 3), List(4), List(2, 5))
      , List(List(1, 3), List(5), List(2, 4))
      , List(List(1, 4), List(2), List(3, 5))
      , List(List(1, 4), List(3), List(2, 5))
      , List(List(1, 4), List(5), List(2, 3))
      , List(List(1, 5), List(2), List(3, 4))
      , List(List(1, 5), List(3), List(2, 4))
      , List(List(1, 5), List(4), List(2, 3))
      , List(List(2, 3), List(1), List(4, 5))
      , List(List(2, 3), List(4), List(1, 5))
      , List(List(2, 3), List(5), List(1, 4))
      , List(List(2, 4), List(1), List(3, 5))
      , List(List(2, 4), List(3), List(1, 5))
      , List(List(2, 4), List(5), List(1, 3))
      , List(List(2, 5), List(1), List(3, 4))
      , List(List(2, 5), List(3), List(1, 4))
      , List(List(2, 5), List(4), List(1, 3))
      , List(List(3, 4), List(1), List(2, 5))
      , List(List(3, 4), List(2), List(1, 5))
      , List(List(3, 4), List(5), List(1, 2))
      , List(List(3, 5), List(1), List(2, 4))
      , List(List(3, 5), List(2), List(1, 4))
      , List(List(3, 5), List(4), List(1, 2))
      , List(List(4, 5), List(1), List(2, 3))
      , List(List(4, 5), List(2), List(1, 3))
      , List(List(4, 5), List(3), List(1, 2))
    )

    runTestFor(
      ns = List(2, 1, 2),
      ls = (1 to 5).toList,
      expected
    )
  }


  private def runTestFor[T](
    ns: List[Int],
    ls: List[T],
    expected: List[List[T]]
  ): Unit = {
    expected.size shouldBe Problem27.combinationsCount(ns, ls.size)

    Problem27.group(
      ns,
      ls
    ) shouldEqual expected
  }

  private def readExpectedListFrom(resourceName: String): List[List[List[Int]]] = {
    import scala.language.postfixOps

    val lineRegexp = "\\(([0-9, ]+)\\)".r

    val resource = Source.fromResource(resourceName)

    val lines = resource.getLines()

    lines map {
      line =>
        lineRegexp.findAllIn(line).map {
          m =>
            m.filterNot(x => x == '(' || x == ')' || x == ' ').split(',').map(_.toInt).toList
        }.toList
    } toList
  }
}
