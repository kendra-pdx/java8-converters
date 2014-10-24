package me.enkode.j8

import java.util.function.Predicate

trait JavaPredicateSupport[T] {
  def jPredicate: Predicate[T]

  @inline
  def asScala: (T) ⇒ Boolean = jPredicate.test
}
