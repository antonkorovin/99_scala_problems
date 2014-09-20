package org.ak.scala.nn_problems

import scala.language.implicitConversions

/**
 * @author antonk
 * @since  9/20/14 - 6:49 AM
 */
package object p25 {
  implicit def toLeafConverter[T](v: T) = Leaf(v)

  def none = EmptyLeaf

  implicit class BinaryTreeCreator[T](v: T) {
    def node(left: BinaryTree[T], right: BinaryTree[T]) = Node(v, left, right)
    def leaf = Leaf(v)
  }
}
