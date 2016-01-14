package org.ak.scala.nn_problems.p37

import org.ak.scala.nn_problems.p36.Problem36

/**
 * @author antonk
 * @since  1/15/16 - 12:06 AM
 */
object Problem37 {
  //  (**) Calculate Euler's totient function phi(m) (improved).
  //    See problem P34 for the definition of Euler's totient function.
  //    If the list of the prime factors of a number m is known in the form of problem P36
  //    then the function phi(m>) can be efficiently calculated as follows:
  //    Let [[p1, m1], [p2, m2], [p3, m3], ...] be the list of prime factors (and their multiplicities) of
  //    a given number m. Then phi(m) can be calculated with the following formula:
  //    phi(m) = (p1-1)*p1(m1-1) * (p2-1)*p2(m2-1) * (p3-1)*p3(m3-1) * ...
  //
  //  Note that ab stands for the bth power of a.

  def totientImproved(a: Int) = {
    Problem36
      .primeFactorMultiplicity(a)
      .filter(_._1 != 1)
      .foldLeft(1) {
      (t, p) =>
        t * (p._1 - 1) * Math.pow(p._1, p._2 - 1).toInt
    }
  }
}
