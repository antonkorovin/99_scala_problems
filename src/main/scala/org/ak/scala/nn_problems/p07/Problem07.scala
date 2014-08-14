package org.ak.scala.nn_problems.p07

import scala.annotation.tailrec

/**
 * @author antonk
 * @since  8/13/14 - 12:44 PM
 */
object Problem07 {
  //  P07 (**) Flatten a nested list structure.
  //  Example:
  //    scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  //  res0: List[Any] = List(1, 1, 2, 3, 5, 8)


  def flatten(list: List[Any]): List[Any] = {
    def flattenRec(
      rest: List[Any],
      flattenList: List[Any]
    ): List[Any] = {
      rest match {
        case head :: tail =>
          head match {
            case subList: List[_] =>
              flattenRec(
                tail,
                flattenRec(
                  subList,
                  flattenList
                )
              )

            case singleElement: Any =>
              flattenRec(
                tail,
                singleElement :: flattenList
              )
          }


        case Nil =>
          flattenList
      }
    }

    flattenRec(
      list,
      Nil
    ).reverse
  }


  def flattenTailRecursive(list: List[Any]): List[Any] = {
    @tailrec
    def flatList(
      rest: List[Any],
      flattenList: List[Any]
    ): List[Any] = {
      rest match {
        case head :: tail =>
          flatList(
            tail,
            flatElement(head) ::: flattenList
          )


        case Nil =>
          flattenList
      }
    }


    def flatElement(element: Any): List[Any] = {
      element match {
        case subList: List[_] =>
          flatList(
            subList,
            Nil
          )

        case singleElement =>
          List(singleElement)
      }
    }


    flatList(
      list,
      Nil
    ).reverse
  }


  def flattenThroughFlatMap(list: List[Any]): List[Any] = {
    list.flatMap {
      case ms: List[_] => flattenThroughFlatMap(ms)
      case e => List(e)
    }
  }
}
