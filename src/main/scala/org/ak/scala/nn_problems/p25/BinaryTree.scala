package org.ak.scala.nn_problems.p25

/**
 * @author antonk
 * @since  09/17/14 - 11:32 PM
 */

sealed trait BinaryTree[+T]

case class Node[T](
  value: T,
  left: BinaryTree[T],
  right: BinaryTree[T]
) extends BinaryTree[T]


case class Leaf[T](value: T) extends BinaryTree[T]

case object EmptyLeaf extends BinaryTree[Nothing]
