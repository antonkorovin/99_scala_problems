package org.ak.scala.nn_problems.arithmetic

import org.ak.scala.nn_problems.p31.Problem31

import scala.language.implicitConversions

/**
 * @author antonk
 * @since  10/17/14 - 1:42 AM
 */
class S99Int(start: Int) {
  def isPrime = Problem31.isPrime(start)
}

object S99Int {
  implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
}