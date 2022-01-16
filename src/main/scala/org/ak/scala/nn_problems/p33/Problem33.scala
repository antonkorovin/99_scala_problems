package org.ak.scala.nn_problems.p33

import org.ak.scala.nn_problems.p32.Problem32

/**
  * @author antonk
  * @since 10/26/14 - 6:33 AM
  */
object Problem33 {
  //  P33 (*) Determine whether two positive integer numbers are coprime.
  //    Two numbers are coprime if their greatest common divisor equals 1.
  //  scala> 35.isCoprimeTo(64)
  //  res0: Boolean = true


  def isCoprime(a: Int, b: Int): Boolean = Problem32.gcd(a, b) == 1

}
