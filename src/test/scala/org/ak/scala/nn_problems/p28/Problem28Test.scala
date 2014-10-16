package org.ak.scala.nn_problems.p28

import org.scalatest.{Matchers, FunSuite}

/**
 * @author antonk
 * @since  10/17/14 - 1:33 AM
 */
class Problem28Test
  extends FunSuite
          with Matchers {

  test("lsort example") {
    val list = List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))

    pendingUntilFixed {
      Problem28.lsort(
        list
      ) shouldEqual List(
        List('o),
        List('d, 'e),
        List('d, 'e),
        List('m, 'n),
        List('a, 'b, 'c),
        List('f, 'g, 'h),
        List('i, 'j, 'k, 'l)
      )
    }
  }


  test("lsortFreq example") {
    val list = List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))

    pendingUntilFixed {
      Problem28.lsortFreq(
        list
      ) shouldEqual List(
        List('i, 'j, 'k, 'l),
        List('o),
        List('a, 'b, 'c),
        List('f, 'g, 'h),
        List('d, 'e),
        List('d, 'e),
        List('m, 'n)
      )
    }
  }
}
