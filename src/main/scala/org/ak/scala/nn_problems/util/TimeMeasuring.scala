package org.ak.scala.nn_problems.util

import com.github.nscala_time.time.Imports._
import org.ak.scala.nn_problems.util.DurationFormatter.Implicits._

trait TimeMeasuring {

  def withTimeCheck(body: => Unit): Duration = {
    val startTime = System.currentTimeMillis()

    body

    val endTime = System.currentTimeMillis()

    Duration.millis(endTime - startTime)
  }


  def printExecutionTime(label: String)(body: => Unit): Unit = {
    val executionTime = withTimeCheck(body)

    println(s"Execution of '$label': ${executionTime.prettyString}")
  }

}
