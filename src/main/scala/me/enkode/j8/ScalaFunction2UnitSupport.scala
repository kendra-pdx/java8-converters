package me.enkode.j8

import java.util.function.BiConsumer

trait ScalaFunction2UnitSupport[T, U] {
  def scalaFunction2: (T, U) ⇒ Unit

  def asJava: BiConsumer[T, U] = new BiConsumer[T, U] {
    @inline
    override def accept(t: T, u: U): Unit = scalaFunction2(t, u)
  }
}
