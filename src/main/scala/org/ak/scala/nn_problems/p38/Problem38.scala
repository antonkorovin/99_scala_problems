package org.ak.scala.nn_problems.p38

import com.github.nscala_time.time.Imports._
import org.ak.scala.nn_problems.p34.Problem34
import org.ak.scala.nn_problems.p37.Problem37
import org.ak.scala.nn_problems.util.{DurationFormatter, TimeMeasuring}

/**
  * @author antonk
  * @since 1/15/16 - 1:33 AM
  */
object Problem38
  extends App
    with TimeMeasuring
    with DurationFormatter.Implicits {

  //  (*) Compare the two methods of calculating Euler's totient function.
  //    Use the solutions of problems P34 and P37 to compare the algorithms. Try to calculate phi(10090) as an example.

  private val testData = Seq(3, 5, 20, 50, 500, 2000, 10090, 20000, 50000)

  val argWidth = 7
  val timeWidth = 25

  val header = s"|%-${argWidth}s|%${timeWidth}s|%${timeWidth}s|".format("a", "Problem34, time", "Problem37, time")
  val delimiter = "-" * header.length

  println(delimiter)
  println(header)
  println(delimiter)
  testData.foreach {
    a =>
      val (t34, t37) = checkExecutionTime(a)

      val t34Time = t34.prettyString
      val t37Time = t37.prettyString

      val line = s"|%-${argWidth}d|%${timeWidth}s|%${timeWidth}s|".format(a, t34Time, t37Time)

      println(line)
  }
  println(delimiter)



  // ////////////////////////////////////////////

  def timeOfP34(a: Int): Duration = withTimeCheck {
    Problem34.totient(a)
  }

  def timeOfP37(a: Int): Duration = withTimeCheck {
    Problem37.totientImproved(a)
  }

  def checkExecutionTime(a: Int): (Duration, Duration) = {
    val p34Time = timeOfP34(a)
    val p37Time = timeOfP37(a)

    (p34Time, p37Time)
  }
}
