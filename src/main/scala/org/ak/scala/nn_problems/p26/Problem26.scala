package org.ak.scala.nn_problems.p26

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  8/21/14 - 6:24 PM
 */
object Problem26 {
  //  P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.
  //  In how many ways can a committee of 3 be chosen from a group of 12 people?
  //  We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient).
  //  For pure mathematicians, this result may be great. But we want to really generate all the possibilities.
  //    Example:
  //
  //    scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
  //  res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...


  def combinations[T](
    n: Int,
    list: List[T]
  ): List[List[T]] = {

    require(n >= 0, s"n($n) should be greater than 0")
    require(list.size >= n, s"${list.size} should be greater or equal to $n")


    if (n == 1) {
      list.map(List(_))
    } else if (n == list.size) {
      List(list)
    } else {
      var rest = list
      var combined = Nil: List[List[T]]

      while (rest.size >= n) {

        combined = combined ::: combinations(n - 1, rest.tail).map(rest.head :: _)

        rest = rest.tail
      }


      combined
    }
  }


  def ncr(
    n: Int,
    k: Int
  ) = {
    require(n >= k, s"n($n) should be greater or equal to k($k)")

    @tailrec
    def fct(n: Int, p: Long = 1): Long = {
      if (n == 0) p
      else fct(n - 1, p * n)
    }


    fct(n) / (fct(k) * fct(n - k))
  }
}
