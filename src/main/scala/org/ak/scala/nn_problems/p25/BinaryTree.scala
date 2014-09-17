package org.ak.scala.nn_problems.p25

/**
 * @author antonk
 * @since  09/17/14 - 11:32 PM
 */

sealed trait BinaryTree[+T] {
  def empty: Boolean
  def size: Int
}

case class Node[T](
  value: T,
  left: BinaryTree[T],
  right: BinaryTree[T]
) extends BinaryTree[T] {
  override def empty = false
  override def size = 1 + left.size + right.size
}


case class Leaf[T](value: T) extends BinaryTree[T] {
  override def empty = false
  override def size = 1
}

case object EmptyLeaf extends BinaryTree[Nothing] {
  override def empty = true

  override def size = 0
}
