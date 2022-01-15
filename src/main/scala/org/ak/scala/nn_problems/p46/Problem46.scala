package org.ak.scala.nn_problems.p46

import scala.util.Properties

object Problem46 {
  // P46 (**) Truth tables for logical expressions.
  //  Define functions and, or, nand, nor, xor, impl, and equ (for logical equivalence) which return true or false
  //  according to the result of their respective operations; e.g. and(A, B) is true if and only if both A and B are true.
  //  scala> and(true, true)
  //  res0: Boolean = true
  //
  //  scala> xor(true. true)
  //  res1: Boolean = false
  //  A logical expression in two variables can then be written as an function of two variables,
  //  e.g: (a: Boolean, b: Boolean) => and(or(a, b), nand(a, b))
  //
  //  Now, write a function called table2 which prints the truth table of a given logical expression in two variables.
  //
  //  scala> table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
  //  A     B     result
  //  true  true  true
  //  true  false true
  //  false true  false
  //  false false false

  type LogicalFunction = (Boolean, Boolean) => Boolean

  // ////////////////////////////////////////////

  def not(a: Boolean): Boolean = {
    if (a) {
      false
    } else {
      true
    }
  }

  def and(a: Boolean, b: Boolean): Boolean = {
    (a, b) match {
      case (true, true) => true
      case _ => false
    }
  }

  def or(a: Boolean, b: Boolean): Boolean = {
    (a, b) match {
      case (false, false) => false
      case _ => true
    }
  }

  def nand(a: Boolean, b: Boolean): Boolean = {
    not(and(a, b))
  }

  def nor(a: Boolean, b: Boolean): Boolean = {
    not(or(a, b))
  }

  // Logical implication
  def impl(a: Boolean, b: Boolean): Boolean = {
    or(not(a), b)
  }

  def equ(a: Boolean, b: Boolean): Boolean = {
    or(and(a, b), and(not(a), not(b)))
  }

  def xor(a: Boolean, b: Boolean): Boolean = {
    not(equ(a, b))
  }


  // ////////////////////////////////////////////

  def table2(fun: LogicalFunction): String = {
    val br = Properties.lineSeparator
    val res = new StringBuilder()

    def append(a: Boolean, b: Boolean): Unit = {
      val s1 = if (a) "  " else " "
      val s2 = if (b) "  " else " "

      res.append(a)
        .append(s1)
        .append(b)
        .append(s2)
        .append(fun(a, b))
        .append(br)
    }

    res.append("A     B     result")
    res.append(br)

    append(a = true, b = true)
    append(a = true, b = false)
    append(a = false, b = true)
    append(a = false, b = false)

    res.toString()
  }


  def printTable2(fun: LogicalFunction): Unit = {
    println(table2(fun))
  }
}
