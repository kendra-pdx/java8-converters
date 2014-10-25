package me.enkode.j8

import java.util.function.Supplier

trait ScalaFunction0Support[R] {
  val scalaFunction0: () ⇒ R

  def asJava: Supplier[R] = new Supplier[R] {
    @inline
    override def get(): R = scalaFunction0()
  }
}
