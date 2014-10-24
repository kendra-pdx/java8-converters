package me.enkode.j8

import java.util.function.{Function ⇒ JFunction, _}
import java.util.stream.{Stream ⇒ JStream}

object Java8Converters {
  implicit class RichJavaSupplier[T](val jSupplier: Supplier[T]) extends JavaSupplierSupport[T]
  implicit class RichJavaConsumer[T](val jConsumer: Consumer[T]) extends JavaConsumerSupport[T]
  implicit class RichJavaFunction[T, R](val jFunction: JFunction[T, R]) extends JavaFunctionSupport[T, R]
  implicit class RichJavaBiFunction[T, U, R](val jBiFunction: BiFunction[T, U, R]) extends JavaBiFunctionSupport[T, U, R]
  implicit class RichJavaStream[T](val jStream: JStream[T]) extends JavaStreamSupport[T]
  implicit class RichJavaPredicate[T](val jPredicate: Predicate[T]) extends JavaPredicateSupport[T]
  implicit class RichJavaBiPredicate[T, U](val jBiPredicate: BiPredicate[T, U]) extends JavaBiPredicateSupport[T, U]
}
