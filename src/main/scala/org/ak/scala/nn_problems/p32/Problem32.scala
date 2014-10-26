package org.ak.scala.nn_problems.p32

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  10/22/14 - 12:32 AM
 */
object Problem32 {
  //  P32 (**) Determine the greatest common divisor of two positive integer numbers.
  //    Use Euclid's algorithm.
  //  scala> gcd(36, 63)
  //  res0: Int = 9

  @tailrec
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }
}
