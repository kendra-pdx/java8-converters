package me.enkode.j8

import java.util.function.BiConsumer

trait JavaBiConsumerSupport[T, U] {
  def jBiConsumer: BiConsumer[T, U]

  @inline
  def asScala: (T, U) ⇒ Unit = jBiConsumer.accept
}
