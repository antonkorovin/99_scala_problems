package org.ak.scala.nn_problems.p06

/**
 * @author antonk
 * @since  8/13/14 - 12:29 PM
 */
object Problem06 {
  //  P06 (*) Find out whether a list is a palindrome.
  //    Example:
  //    scala> isPalindrome(List(1, 2, 3, 2, 1))
  //  res0: Boolean = true

  def isPalindrome[T](list: List[T]) = {
    list == list.reverse
  }
}
