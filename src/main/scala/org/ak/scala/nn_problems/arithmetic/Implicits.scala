package org.ak.scala.nn_problems.arithmetic

import org.ak.scala.nn_problems.p31.Problem31
import org.ak.scala.nn_problems.p33.Problem33
import org.ak.scala.nn_problems.p34.Problem34
import org.ak.scala.nn_problems.p35.Problem35
import org.ak.scala.nn_problems.p36.Problem36

/**
  * @author antonk
  * @since 10/17/14 - 1:42 AM
  */

trait Implicits {

  implicit class S99Int(start: Int) {
    def isPrime: Boolean = Problem31.isPrime(start)

    def isCoprimeTo(b: Int): Boolean = Problem33.isCoprime(start, b)

    def totient: Int = Problem34.totient(start)

    def primeFactors: List[Int] = Problem35.primeFactorsCount(start)

    def primeFactorMultiplicity: Map[Int, Int] = Problem36.primeFactorMultiplicity(start)

    def ! : Int = factorial


    def factorial : Int = {
      start match {
        case 0 => 1
        case n if n < 0 => throw new IllegalArgumentException("Factorial of negative")
        case _ => (1 to start).product
      }
    }
  }

}

object Implicits extends Implicits
