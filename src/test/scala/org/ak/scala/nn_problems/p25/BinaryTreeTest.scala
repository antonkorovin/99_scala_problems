package org.ak.scala.nn_problems.p25

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

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

    1.node(EmptyLeaf, EmptyLeaf).empty shouldBe false
    1.node(2, EmptyLeaf).empty shouldBe false
    1.node(EmptyLeaf, 2).empty shouldBe false
    1.node(2, 3).empty shouldBe false
  }


  test("tree size") {
    EmptyLeaf.size shouldBe 0
    Leaf(1).size shouldBe 1

    1.node(EmptyLeaf, EmptyLeaf).size shouldBe 1
    1.node(2, EmptyLeaf).size shouldBe 2
    1.node(EmptyLeaf, 2).size shouldBe 2
    1.node(2, 3).size shouldBe 3

    val n1 = 1.node(2.leaf, 3.leaf)

    0.node(n1, n1).size shouldBe 7

    0.node(
      42.node(
        n1,
        n1
      ),
      37.node(
        n1,
        n1
      )
    ).size shouldBe 15
  }


  test("full tree") {

    val n1 = 1.node(2.leaf, 3.leaf)

    0.node(
      42.node(
        n1,
        n1
      ),
      37.node(
        n1,
        n1
      )
    ).full shouldBe true


    0.node(
      42.node(
        n1,
        n1
      ),
      37.node(
        n1,
        EmptyLeaf
      )
    ).full shouldBe false


    0.node(
      42.node(
        n1,
        n1
      ),
      37.node(
        EmptyLeaf,
        n1
      )
    ).full shouldBe false


    0.node(
      42.node(
        n1,
        EmptyLeaf
      ),
      37.node(
        n1,
        n1
      )
    ).full shouldBe false


    0.node(
      42.node(
        EmptyLeaf,
        n1
      ),
      37.node(
        n1,
        n1
      )
    ).full shouldBe false
  }


  test("add value to empty leaf") {
    EmptyLeaf.add(1) shouldEqual 1.leaf
  }


  test("add value to leaf") {
    1.leaf.add(2) shouldEqual 1.node(2, EmptyLeaf)
  }


  test("add value to node with leafs") {
    1.node(2, 3).add(4) shouldEqual 1.node(2.node(4, EmptyLeaf), 3)
  }


  test("add value to node with right leaf and left node") {
    pending

    1.node(
      2.node(
        4,
        EmptyLeaf
      ),
      3
    ).add(5) shouldEqual 1.node(2.node(4, 5), 3)
  }
}
