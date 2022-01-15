package org.ak.scala.nn_problems.p47

import org.ak.scala.nn_problems.p46.Problem46

// P47 (*) Truth tables for logical expressions (2).
//     Continue problem P46 by redefining and, or, etc as operators.  (i.e. make
//     them methods of a new class with an implicit conversion from Boolean.)
//     not will have to be left as a object method.
//
//     scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
//     A     B     result
//     true  true  true
//     true  false true
//     false true  false
//     false false false
object Problem47 {

  class AdvancedLogic(a: Boolean) {
    def negated: Boolean = {
      Problem46.not(a)
    }

    def and(b: Boolean): Boolean = {
      Problem46.and(a, b)
    }

    def or(b: Boolean): Boolean = {
      Problem46.or(a, b)
    }

    def nand(b: Boolean): Boolean = {
      Problem46.nand(a, b)
    }

    def nor(b: Boolean): Boolean = {
      Problem46.nor(a, b)
    }

    def xor(b: Boolean): Boolean = {
      Problem46.xor(a, b)
    }

    def impl(b: Boolean): Boolean = {
      Problem46.impl(a, b)
    }

    def equ(b: Boolean): Boolean = {
      Problem46.equ(a, b)
    }
  }

  // //////////////////////////////////


  implicit class RichBoolean(a: Boolean) extends AdvancedLogic(a)
}
