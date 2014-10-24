package me.enkode.j8

import java.util
import java.util.stream.{Stream ⇒ JStream}

trait JavaStreamSupport[T] {
  def jStream: JStream[T]

  def asScala = {
    def stream(iterator: util.Iterator[T]): Stream[T] = {
      if (!iterator.hasNext) Stream.empty
      else iterator.next() #:: stream(iterator)
    }
    stream(jStream.iterator())
  }
}
