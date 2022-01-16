package org.ak.scala.nn_problems.p34

import org.ak.scala.nn_problems.arithmetic.Implicits._

/**
  * @author antonk
  * @since 11/2/14 - 1:25 PM
  */
object Problem34 {
  //  P34 (**) Calculate Euler's totient function phi(m).
  //    Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
  //  scala> 10.totient
  //  res0: Int = 4

  def totient(a: Int): Int = (1 to a).count(_.isCoprimeTo(a))
}
