package org.ak.scala.nn_problems.p24

import scala.annotation.tailrec
import scala.util.Random

/**
 * @author antonk
 * @since  8/21/14 - 4:13 PM
 */
object Problem24 {
  //  P24 (*) Lotto: Draw N different random numbers from the set 1..M.
  //    Example:
  //    scala> lotto(6, 49)
  //  res0: List[Int] = List(23, 1, 17, 33, 21, 37)


  def lotto(
    n: Int,
    maxValue: Int
  ) = {
    @tailrec
    def lottoRec(
      current: Int,
      generated: List[Int]
    ): List[Int] = {
      if (current != 0)
        lottoRec(
          current - 1,
          Random.nextInt(maxValue) :: generated
        )
      else
        generated
    }


    lottoRec(
      n,
      Nil
    )
  }
}
