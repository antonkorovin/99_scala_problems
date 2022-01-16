package org.ak.scala.nn_problems.p35

import org.ak.scala.nn_problems.arithmetic.Implicits._
import org.scalatest.{FunSuite, Matchers}

/**
  * @author antonk
  * @since 11/2/14 - 1:36 PM
  */
class Problem35Test
  extends FunSuite
    with Matchers {

  test("example") {

    315.primeFactors shouldEqual List(1, 3, 3, 5, 7)

  }


  test("prime factors for 1") {

    1.primeFactors shouldEqual List(1)

  }


  test("prime factors for 2") {

    2.primeFactors shouldEqual List(1, 2)

  }


  test("prime factors for 3") {

    3.primeFactors shouldEqual List(1, 3)

  }

}
