package me.enkode.j8

import java.util.stream.{Stream ⇒ JStream}

trait ScalaStreamSupport[T] {
  def scalaStream: Stream[T]

  /**
   * this is a very naive implementation which only works on finite streams by converting
   * to a list first. be careful when using it.
   */
  def asJava: JStream[T] = {
    import scala.collection.JavaConverters._
    if (scalaStream.isEmpty) JStream.empty()
    else scalaStream.toSeq.asJava.stream()
  }
}
