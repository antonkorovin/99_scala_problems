package org.ak.scala.nn_problems.p25

import org.ak.scala.nn_problems.p23.Problem23

/**
 * @author antonk
 * @since  8/21/14 - 4:35 PM
 */
object Problem25 {
  //  P25 (*) Generate a random permutation of the elements of a list.
  //    Hint: Use the solution of problem P23.
  //  Example:
  //
  //    scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
  //  res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)


  def randomPermute[T](list: List[T]) = {
    Problem23.randomSelect(
      list.size,
      list
    )
  }
}
