package org.ak.scala.nn_problems.p49

import scala.annotation.tailrec

object Problem49 {
  def gray(n: Int): List[String] = {
    require(n > 0)

    grayRec(n - 1, List("0", "1"))
  }


  @tailrec
  private def grayRec(n: Int, res: List[String]): List[String] = {
    n match {
      case 0 => res

      case _ =>
        grayRec(
          n - 1,
          res.map("0" + _) ::: res.reverse.map("1" + _)
        )
    }
  }
}
