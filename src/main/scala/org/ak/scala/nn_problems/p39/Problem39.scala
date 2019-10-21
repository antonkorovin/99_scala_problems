package org.ak.scala.nn_problems.p39

import org.ak.scala.nn_problems.p31.Problem31

object Problem39 {
  // (*) A list of prime numbers.
  // Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.
  // scala> listPrimesInRange(7 to 31)
  // res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)

  def listPrimesInRange(range: Range): List[Int] = {
    range.filter(Problem31.isPrime).toList
  }
}
