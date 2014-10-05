package org.ak.scala.nn_problems.p25

/**
 * @author antonk
 * @since  09/17/14 - 11:32 PM
 */

object BinaryTree {
  def apply[T](values: T*) = {
    values.foldLeft(EmptyLeaf: BinaryTree[T]) {
      (tree, e) =>
        tree.add(e)
    }
  }
}

sealed trait BinaryTree[+T] {
  def empty: Boolean

  def full: Boolean

  def size: Int

  def add[VT >: T](newValue: VT): BinaryTree[VT]
}

case class Node[T](
  value: T,
  left: BinaryTree[T],
  right: BinaryTree[T]
) extends BinaryTree[T] {
  override def empty = false

  override def full = left.full && right.full

  override def size = 1 + left.size + right.size

  override def add[VT >: T](newValue: VT) = {
    (left, right) match {
      case (Leaf(_), _) =>
        Node(
          value,
          left.add(newValue),
          right
        )

      case (_, Leaf(_)) =>
        Node(
          value,
          left,
          right.add(newValue)
        )

      case (_, _) =>
        throw new IllegalArgumentException()
    }
  }
}


case class Leaf[T](value: T) extends BinaryTree[T] {
  override def empty = false

  override def full = true

  override def size = 1

  override def add[VT >: T](newValue: VT) = {
    Node(value, Leaf(newValue), EmptyLeaf)
  }
}

case object EmptyLeaf extends BinaryTree[Nothing] {
  override def empty = true

  override def full = false

  override def size = 0

  override def add[T](newValue: T) = {
    Leaf(newValue)
  }
}
