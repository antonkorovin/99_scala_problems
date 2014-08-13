package org.ak.scala.nn_problems

import org.scalacheck.Gen

/**
 * @author antonk
 * @since  8/13/14 - 11:52 AM
 */
object GenUtil {
  def chooseAllOfInt() = Gen.chooseNum(Int.MinValue, Int.MaxValue)
}
