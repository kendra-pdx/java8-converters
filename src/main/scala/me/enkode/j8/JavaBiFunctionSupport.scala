package me.enkode.j8

import java.util.function.BiFunction

trait JavaBiFunctionSupport[T,U,R] {
  def jBiFunction: BiFunction[T,U,R]

  @inline
  def asScala: (T, U) ⇒ R = jBiFunction.apply
}
