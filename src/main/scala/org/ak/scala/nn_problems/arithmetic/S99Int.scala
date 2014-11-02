package org.ak.scala.nn_problems.arithmetic

import org.ak.scala.nn_problems.p31.Problem31
import org.ak.scala.nn_problems.p33.Problem33
import org.ak.scala.nn_problems.p34.Problem34
import org.ak.scala.nn_problems.p35.Problem35

import scala.language.implicitConversions

/**
 * @author antonk
 * @since  10/17/14 - 1:42 AM
 */
class S99Int(start: Int) {
  def isPrime = Problem31.isPrime(start)
  def isCoprimeTo(b: Int) = Problem33.isCoprime(start, b)
  def totient = Problem34.totient(start)
  def primeFactors = Problem35.primeFactors(start)
}

object S99Int {
  implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
}
