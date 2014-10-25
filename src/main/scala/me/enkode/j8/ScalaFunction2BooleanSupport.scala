package me.enkode.j8

import java.util.function.BiPredicate

trait ScalaFunction2BooleanSupport[T, U] {
  def scalaFunction2: (T, U) ⇒ Boolean

  def asJava: BiPredicate[T, U] = new BiPredicate[T, U] {
    @inline
    override def test(t: T, u: U): Boolean = scalaFunction2(t, u)
  }
}
