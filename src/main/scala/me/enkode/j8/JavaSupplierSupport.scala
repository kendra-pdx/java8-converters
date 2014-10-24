package me.enkode.j8

import java.util.function.Supplier

trait JavaSupplierSupport[T] {
  def jSupplier: Supplier[T]

  @inline
  def asScala: () ⇒ T = () ⇒ jSupplier.get()
}
