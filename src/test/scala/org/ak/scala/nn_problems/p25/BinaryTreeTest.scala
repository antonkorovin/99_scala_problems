package org.ak.scala.nn_problems.p25

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{Matchers, FunSuite}

/**
 * @author antonk
 * @since  9/17/14 - 11:49 PM
 */
class BinaryTreeTest
  extends FunSuite
          with Matchers
          with GeneratorDrivenPropertyChecks {

  test("empty tree") {
    EmptyLeaf.empty shouldBe true
    Leaf(1).empty shouldBe false

    Node(1, EmptyLeaf, EmptyLeaf).empty shouldBe false
    Node(1, Leaf(2), EmptyLeaf).empty shouldBe false
    Node(1, EmptyLeaf, Leaf(2)).empty shouldBe false
    Node(1, Leaf(2), Leaf(3)).empty shouldBe false
  }


  test("tree size") {
    EmptyLeaf.size shouldBe 0
    Leaf(1).size shouldBe 1

    Node(1, EmptyLeaf, EmptyLeaf).size shouldBe 1
    Node(1, Leaf(2), EmptyLeaf).size shouldBe 2
    Node(1, EmptyLeaf, Leaf(2)).size shouldBe 2
    Node(1, Leaf(2), Leaf(3)).size shouldBe 3
  }
}
