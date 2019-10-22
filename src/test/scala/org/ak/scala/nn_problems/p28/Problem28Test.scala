package org.ak.scala.nn_problems.p28

import org.scalatest.{Matchers, FunSuite}

/**
 * @author antonk
 * @since  10/17/14 - 1:33 AM
 */
class Problem28Test
  extends FunSuite
          with Matchers {

  private val srcList: List[List[Symbol]] = List(
    List(Symbol("a"), Symbol("b"), Symbol("c"))
    , List(Symbol("d"), Symbol("e"))
    , List(Symbol("f"), Symbol("g"), Symbol("h"))
    , List(Symbol("d"), Symbol("e"))
    , List(Symbol("i"), Symbol("j"), Symbol("k"), Symbol("l"))
    , List(Symbol("m"), Symbol("n"))
    , List(Symbol("o"))
  )

  private val sortedByLength: List[List[Symbol]] = List(
    List(Symbol("o"))
    , List(Symbol("d"), Symbol("e"))
    , List(Symbol("d"), Symbol("e"))
    , List(Symbol("m"), Symbol("n"))
    , List(Symbol("a"), Symbol("b"), Symbol("c"))
    , List(Symbol("f"), Symbol("g"), Symbol("h"))
    , List(Symbol("i"), Symbol("j"), Symbol("k"), Symbol("l"))
  )

  private val sortedByLengthFrequency: List[List[Symbol]] = List(
    List(Symbol("i"), Symbol("j"), Symbol("k"), Symbol("l"))
    , List(Symbol("o"))
    , List(Symbol("a"), Symbol("b"), Symbol("c"))
    , List(Symbol("f"), Symbol("g"), Symbol("h"))
    , List(Symbol("d"), Symbol("e"))
    , List(Symbol("d"), Symbol("e"))
    , List(Symbol("m"), Symbol("n"))
  )

  test("lsort example") {
    Problem28.lsort(
      srcList
    ) shouldEqual sortedByLength
  }

  test("lsortFreq example") {
    Problem28.lsortFreq(
      srcList
    ) shouldEqual sortedByLengthFrequency
  }

  test("lsortFreqOriginal example") {
    Problem28.lsortFreqOriginal(
      srcList
    ) shouldEqual sortedByLengthFrequency
  }
}
