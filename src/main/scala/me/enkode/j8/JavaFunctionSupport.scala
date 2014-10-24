package me.enkode.j8

import java.util.function.{Function ⇒ JFunction}

trait JavaFunctionSupport[T, R] {
  def jFunction: JFunction[T, R]

  @inline
  def asScala: (T) ⇒ R = jFunction.apply
}
