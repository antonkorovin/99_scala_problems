package org.ak.scala.nn_problems.p37

import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  1/15/16 - 12:06 AM
 */
class Problem37Test
  extends FunSuite
  with Matchers {

  test("example") {
    Problem37.totientImproved(10) shouldEqual 4
  }


  test("various numbers test (A000010 seq)") {

    // Sequence from https://oeis.org/A000010
    val numbersWithTotientValues = Seq(
      1 -> 1,
      2 -> 1,
      3 -> 2,
      4 -> 2,
      5 -> 4,
      6 -> 2,
      7 -> 6,
      8 -> 4,
      9 -> 6,
      10 -> 4,
      11 -> 10,
      12 -> 4,
      13 -> 12,
      14 -> 6,
      15 -> 8,
      16 -> 8,
      17 -> 16,
      18 -> 6,
      19 -> 18,
      20 -> 8,
      21 -> 12,
      22 -> 10,
      23 -> 22,
      24 -> 8,
      25 -> 20,
      26 -> 12,
      27 -> 18,
      28 -> 12,
      29 -> 28,
      30 -> 8,
      31 -> 30,
      32 -> 16,
      33 -> 20,
      34 -> 16,
      35 -> 24,
      36 -> 12,
      37 -> 36,
      38 -> 18,
      39 -> 24,
      40 -> 16,
      41 -> 40,
      42 -> 12,
      43 -> 42,
      44 -> 20,
      45 -> 24,
      46 -> 22,
      47 -> 46,
      48 -> 16,
      49 -> 42,
      50 -> 20,
      51 -> 32,
      52 -> 24,
      53 -> 52,
      54 -> 18,
      55 -> 40,
      56 -> 24,
      57 -> 36,
      58 -> 28,
      59 -> 58,
      60 -> 16,
      61 -> 60,
      62 -> 30,
      63 -> 36,
      64 -> 32,
      65 -> 48,
      66 -> 20,
      67 -> 66,
      68 -> 32,
      69 -> 44
    )


    for (nt <- numbersWithTotientValues) {
      Problem37.totientImproved(nt._1) shouldEqual nt._2
    }
  }
}
