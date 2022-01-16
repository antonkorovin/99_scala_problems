package org.ak.scala.nn_problems.p50

import scala.annotation.tailrec
import scala.collection.immutable.SortedSet
import scala.math.Ordering

// P50 (***) Huffman code.
// First of all, consult a good book on discrete mathematics or algorithms for a detailed description of Huffman codes!
// We suppose a set of symbols with their frequencies, given as a list of (S, F) Tuples.
// E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)).
// Our objective is to construct a list of (S, C) Tuples, where C is the Huffman code word for the symbol S.
//
// scala> huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
// res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))
object Problem50 {
  case class Node(s: String, frequency: Int, left: Option[Node] = None, right: Option[Node] = None)

  private implicit val priorityOrdering: Ordering[Node] = (x: Node, y: Node) => {
    y.frequency compareTo x.frequency
  }

  def huffman(list: List[(String, Int)]): List[(String, String)] = {
    encode(
      buildTree(list)
    )
  }

  def huffmanImmutable(list: List[(String, Int)]): List[(String, String)] = {
    encode(
      buildTreeImmutable(
        SortedSet.from(list.map(x => Node(x._1, x._2)))(priorityOrdering.reverse)
      )
    )
  }


  private def buildTree(list: List[(String, Int)]): Node = {
    import scala.collection.mutable

    val queue = new mutable.PriorityQueue[Node]()
    list.foreach(x => queue.enqueue(Node(x._1, x._2)))

    while (queue.size != 1) {
      val left = queue.dequeue()
      val right = queue.dequeue()

      val newNode = Node(
        s"${left.s}${right.s}",
        left.frequency + right.frequency,
        Some(left),
        Some(right)
      )

      queue.enqueue(newNode)
    }

    queue.dequeue()
  }


  @tailrec
  private def buildTreeImmutable(list: SortedSet[Node]): Node = {
    if (list.size == 1) {
      list.head
    } else {
      val left = list.head
      val right = list.tail.head

      val newNode = Node(
        s"${left.s}${right.s}",
        left.frequency + right.frequency,
        Some(left),
        Some(right)
      )

      buildTreeImmutable(
        list.drop(2) + newNode
      )
    }
  }


  private def encode(tree: Node): List[(String, String)] = {
    encode(Option(tree), "", List.empty)
  }


  private def encode(node: Option[Node], prefix: String, result: List[(String, String)]): List[(String, String)] = {
    node match {
      case None => result

      case Some(Node(s, _, None, None)) =>
        (s -> prefix) :: result

      case Some(Node(_, _, left, right)) =>
        val leftEncoded = encode(left, prefix + "0", result)
        encode(right, prefix + "1", leftEncoded)
    }
  }
}
