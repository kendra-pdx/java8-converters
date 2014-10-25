package me.enkode.j8

import java.util.function.BiFunction

trait ScalaFunction2Support[T, U, R] {
  def scalaFunction2: (T, U) ⇒ R

  def asJava: BiFunction[T, U, R] = new BiFunction[T, U, R] {
    @inline
    override def apply(t: T, u: U): R = scalaFunction2(t, u)
  }
}
