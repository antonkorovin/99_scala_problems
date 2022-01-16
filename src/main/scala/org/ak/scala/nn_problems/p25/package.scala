package org.ak.scala.nn_problems

import scala.language.implicitConversions

/**
  * @author antonk
  * @since 9/20/14 - 6:49 AM
  */
package object p25 {
  implicit def toLeafConverter[T](v: T): Leaf[T] = Leaf(v)

  implicit class BinaryTreeCreator[+T](v: T) {
    def node[VT >: T](left: BinaryTree[VT], right: BinaryTree[VT]): Node[VT] = Node(v, left, right)

    def leaf[VT >: T]: Leaf[VT] = Leaf[VT](v)
  }
}
