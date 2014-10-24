package me.enkode.j8

import java.util.function.BiPredicate

trait JavaBiPredicateSupport[T, U] {
  def jBiPredicate: BiPredicate[T, U]

  @inline
  def asScala: (T, U) ⇒ Boolean = jBiPredicate.test
}
