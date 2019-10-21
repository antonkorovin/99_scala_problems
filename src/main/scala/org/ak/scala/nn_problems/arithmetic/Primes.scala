package org.ak.scala.nn_problems.arithmetic

trait Primes {

  private val initPrimesStream: LazyList[Int] = {
    // Primes being never multiples of 2 - could speed up a little with step = 2
    2 #:: LazyList.from(3, step = 2)
  }

  val stream: LazyList[Int] = {
    primes(initPrimesStream)
  }

  def streamFrom(from: Int): LazyList[Int] = {
    stream.dropWhile(_ < from)
  }

  private def primes(init: LazyList[Int]): LazyList[Int] = {
    init.filter {
      n =>
        !init.takeWhile(
          _ <= math.sqrt(n)
        ).exists(
          n % _ == 0
        )
    }
  }
}

object Primes extends Primes
