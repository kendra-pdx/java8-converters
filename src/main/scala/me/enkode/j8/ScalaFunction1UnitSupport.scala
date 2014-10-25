package me.enkode.j8

import java.util.function.Consumer

trait ScalaFunction1UnitSupport[T] {
  def scalaFunction1: (T) ⇒ Unit

  def asJava: Consumer[T] = new Consumer[T] {
    @inline
    override def accept(t: T): Unit = scalaFunction1(t)
  }
}
