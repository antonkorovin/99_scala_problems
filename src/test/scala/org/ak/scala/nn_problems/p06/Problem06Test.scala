package org.ak.scala.nn_problems.p06

import org.ak.scala.nn_problems.GenUtil
import org.scalacheck.Gen
import org.scalatest.{FunSuite, Matchers}
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

/**
  * @author antonk
  * @since 8/13/14 - 12:32 PM
  */
class Problem06Test
  extends FunSuite
    with Matchers
    with ScalaCheckDrivenPropertyChecks {


  test("example test") {
    assert(
      Problem06.isPalindrome(
        List(
          1,
          2,
          3,
          2,
          1
        )
      )
    )
  }


  test("find out 'isPalindrome' on normal list") {
    forAll(
      Gen.nonEmptyListOf(
        GenUtil.chooseAllOfInt()
      )
    ) {
      list =>
        val palindrome = list.reverse ::: list

        assert(
          Problem06.isPalindrome(
            palindrome
          )
        )
    }
  }

}
