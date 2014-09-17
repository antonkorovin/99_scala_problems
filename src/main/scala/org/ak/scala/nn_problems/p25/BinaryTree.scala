package org.ak.scala.nn_problems.p25

/**
 * @author antonk
 * @since  09/17/14 - 11:32 PM
 */

sealed trait BinaryTree[+T] {
  def empty: Boolean
}

case class Node[T](
  value: T,
  left: BinaryTree[T],
  right: BinaryTree[T]
) extends BinaryTree[T] {
  override def empty = false
}


case class Leaf[T](value: T) extends BinaryTree[T] {
  override def empty = false
}

case object EmptyLeaf extends BinaryTree[Nothing] {
  override def empty = true
}
