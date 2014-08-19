package org.ak.scala.nn_problems.p19

/**
 * @author antonk
 * @since  8/19/14 - 2:21 PM
 */
object Problem19 {
  //  P19 (**) Rotate a list N places to the left.
  //    Examples:
  //    scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //  res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
  //
  //  scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //  res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)


  def rotate[T](
    n: Int,
    list: List[T]
  ) = {
    def rotateRecLeft(
      current: Int,
      rest: List[T],
      rotated: List[T]
    ): List[T] = (current, rest) match {
      case (_, Nil) =>
        rotated.reverse

      case (0, tail) =>
        tail ::: rotated.reverse

      case (_, head :: tail) =>
        rotateRecLeft(
          current - 1,
          tail,
          head :: rotated
        )
    }


    rotateRecLeft(
      n,
      list,
      Nil
    )
  }
}
