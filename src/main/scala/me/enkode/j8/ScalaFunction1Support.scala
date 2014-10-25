package me.enkode.j8

import java.util.function.{Function ⇒ JFunction}

trait ScalaFunction1Support[T, R] {
  def scalaFunction1: (T) ⇒ R

  def asJava: JFunction[T, R] = new JFunction[T, R] {
    @inline
    override def apply(t: T): R = scalaFunction1(t)
  }
}
