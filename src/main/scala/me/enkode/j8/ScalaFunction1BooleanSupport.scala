package me.enkode.j8

import java.util.function.Predicate

trait ScalaFunction1BooleanSupport[T] {
  def scalaFunction1: (T) ⇒ Boolean

  def asJava: Predicate[T] = new Predicate[T] {
    @inline
    override def test(t: T): Boolean = scalaFunction1(t)
  }
}
