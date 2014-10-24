package me.enkode.j8

import java.util.function.Consumer

trait JavaConsumerSupport[T] {
  def jConsumer: Consumer[T]

  @inline
  def asScala: (T) ⇒ Unit = jConsumer.accept
}
