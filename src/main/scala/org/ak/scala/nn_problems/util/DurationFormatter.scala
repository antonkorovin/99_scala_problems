package org.ak.scala.nn_problems.util

import com.github.nscala_time.time.Imports._
import org.joda.time.format.PeriodFormatterBuilder


trait DurationFormatter {
  def prettyDuration(p: Duration): String = {
    DurationFormatter.prettyDurationFormatter
      .print(p.toPeriod().normalizedStandard())
      .trim
  }
}

object DurationFormatter extends DurationFormatter {

  trait Implicits {
    implicit class RichDuration(d: Duration) {
      def prettyString: String = {
        prettyDuration(d)
      }
    }
  }

  object Implicits extends Implicits

  private def prettyDurationFormatter = {
    new PeriodFormatterBuilder()
      .appendHours()
      .appendSuffix(" hour", " hours")
      .appendSeparatorIfFieldsBefore(" ")
      .appendMinutes()
      .appendSuffix(" minute", " minutes")
      .appendSeparatorIfFieldsBefore(" ")
      .appendSeconds()
      .appendSuffix(" second", " seconds")
      .appendSeparatorIfFieldsBefore(" ")
      .appendMillis()
      .appendSuffix(" ms", " millis")
      .toFormatter
  }

}
