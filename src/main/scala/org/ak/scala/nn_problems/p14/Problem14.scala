package org.ak.scala.nn_problems.p14

/**
 * @author antonk
 * @since  8/18/14 - 11:19 AM
 */
object Problem14 {
  //  P14 (*) Duplicate the elements of a list.
  //    Example:
  //    scala> duplicate(List('a, 'b, 'c, 'c, 'd))
  //  res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)


  def duplicate[T](list: List[T]) = {
    def duplicateRec(
      rest: List[T],
      duplicated: List[T]
    ): List[T] = rest match {
      case head :: tail =>
        duplicateRec(
          tail,
          head :: head :: duplicated
        )

      case Nil =>
        duplicated
    }


    duplicateRec(
      list,
      Nil
    ).reverse
  }


  def duplicateUsingFoldLeft[T](list: List[T]) = {
    // Use 'reverse' before foldLeft is more effective than after
    list.reverse.foldLeft(List[T]()) {
      (duplicated, e) =>
        e :: e :: duplicated
    }
  }


  def duplicateUsingFoldRight[T](list: List[T]) = {
    list.foldRight(List[T]()) {
      (e, duplicated) =>
        e :: e :: duplicated
    }
  }
}
