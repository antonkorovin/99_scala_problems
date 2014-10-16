package org.ak.scala.nn_problems.p31

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  10/17/14 - 1:45 AM
 */
object Problem31 {
  //  P31 (**) Determine whether a given integer number is prime.
  //    scala> 7.isPrime
  //  res0: Boolean = true

  def isPrime(i: Int) = {

    @tailrec
    def isPrimeRec(n: Int): Boolean = {
      if (i >= n) {
        true
      } else {
        i % n == 0 || isPrimeRec(n + 1)
      }
    }


    if (i == 0) {
      throw new IllegalArgumentException
    } else {
      isPrimeRec(2)
    }
  }

}
