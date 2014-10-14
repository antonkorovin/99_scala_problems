package org.ak.scala.nn_problems.p27

import org.scalatest.{FunSuite, Matchers}

/**
 * @author antonk
 * @since  8/28/14 - 6:46 PM
 */
class Problem27Test
  extends FunSuite
          with Matchers {

  test("group3") {
    pendingUntilFixed {
      // TODO Fill expected list correctly
      val expectedList = List(
        List(
          List("Aldo", "Beat"),
          List("Carla", "David", "Evi"),
          List("Flip", "Gary", "Hugo", "Ida")
        )
      )


      Problem27.group3(
        List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")
      ) shouldEqual expectedList
    }
  }


  test("groupList") {
    pendingUntilFixed {

      // TODO Fill expected list correctly

      val expectedList = List(
        List(
          List("Aldo", "Beat"),
          List("Carla", "David", "Evi"),
          List("Flip", "Gary", "Hugo", "Ida")
        )
      )


      Problem27.group(
        List(1, 3, 5),
        List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")
      ) shouldEqual expectedList

    }
  }
}
