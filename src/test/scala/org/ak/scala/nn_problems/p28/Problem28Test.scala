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
    val list = List(
      List(Symbol("a"), Symbol("b"), Symbol("c"))
      , List(Symbol("d"), Symbol("e"))
      , List(Symbol("f"), Symbol("g"), Symbol("h"))
      , List(Symbol("d"), Symbol("e"))
      , List(Symbol("i"), Symbol("j"), Symbol("k"), Symbol("l"))
      , List(Symbol("m"), Symbol("n"))
      , List(Symbol("o"))
    )

    Problem28.lsort(
      list
    ) shouldEqual List(
      List(Symbol("o"))
      , List(Symbol("d"), Symbol("e"))
      , List(Symbol("d"), Symbol("e"))
      , List(Symbol("m"), Symbol("n"))
      , List(Symbol("a"), Symbol("b"), Symbol("c"))
      , List(Symbol("f"), Symbol("g"), Symbol("h"))
      , List(Symbol("i"), Symbol("j"), Symbol("k"), Symbol("l"))
    )
  }


  test("lsortFreq example") {
    val list = List(
      List(Symbol("a"), Symbol("b"), Symbol("c"))
      , List(Symbol("d"), Symbol("e"))
      , List(Symbol("f"), Symbol("g"), Symbol("h"))
      , List(Symbol("d"), Symbol("e"))
      , List(Symbol("i"), Symbol("j"), Symbol("k"), Symbol("l"))
      , List(Symbol("m"), Symbol("n"))
      , List(Symbol("o"))
    )

    pendingUntilFixed {
      Problem28.lsortFreq(
        list
      ) shouldEqual List(
        List(Symbol("i"), Symbol("j"), Symbol("k"), Symbol("l"))
        , List(Symbol("o"))
        , List(Symbol("a"), Symbol("b"), Symbol("c"))
        , List(Symbol("f"), Symbol("g"), Symbol("h"))
        , List(Symbol("d"), Symbol("e"))
        , List(Symbol("d"), Symbol("e"))
        , List(Symbol("m"), Symbol("n"))
      )
    }
  }
}
