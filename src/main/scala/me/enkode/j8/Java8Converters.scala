package me.enkode.j8

import java.util.Optional
import java.util.function.{Function ⇒ JFunction, _}
import java.util.stream.{Stream ⇒ JStream}

object Java8Converters {
  implicit class RichJavaSupplier[T](val jSupplier: Supplier[T]) extends JavaSupplierSupport[T]
  implicit class RichJavaConsumer[T](val jConsumer: Consumer[T]) extends JavaConsumerSupport[T]
  implicit class RichJavaFunction[T, R](val jFunction: JFunction[T, R]) extends JavaFunctionSupport[T, R]
  implicit class RichJavaPredicate[T](val jPredicate: Predicate[T]) extends JavaPredicateSupport[T]
  implicit class RichJavaBiFunction[T, U, R](val jBiFunction: BiFunction[T, U, R]) extends JavaBiFunctionSupport[T, U, R]
  implicit class RichJavaBiPredicate[T, U](val jBiPredicate: BiPredicate[T, U]) extends JavaBiPredicateSupport[T, U]
  implicit class RichJavaBiConsumer[T, U](val jBiConsumer: BiConsumer[T, U]) extends JavaBiConsumerSupport[T, U]
  implicit class RichJavaStream[T](val jStream: JStream[T]) extends JavaStreamSupport[T]
  implicit class RichJavaOptional[T](val jOptional: Optional[T]) extends JavaOptionalSupport[T]

  implicit class RichScalaFunction0[R](val scalaFunction0: () ⇒ R) extends ScalaFunction0Support[R]
  implicit class RichScalaFunction1Unit[T](val scalaFunction1: (T) ⇒ Unit) extends ScalaFunction1UnitSupport[T]
  implicit class RichScalaFunction1Boolean[T](val scalaFunction1: (T) ⇒ Boolean) extends ScalaFunction1BooleanSupport[T]
  implicit class RichScalaFunction1[T, R](val scalaFunction1: (T) ⇒ R) extends ScalaFunction1Support[T, R]
  implicit class RichScalaFunction2Unit[T, U](val scalaFunction2: (T, U) ⇒ Unit) extends ScalaFunction2UnitSupport[T, U]
  implicit class RichScalaFunction2Boolean[T, U](val scalaFunction2: (T, U) ⇒ Boolean) extends ScalaFunction2BooleanSupport[T, U]
  implicit class RichScalaFunction2[T, U, R](val scalaFunction2: (T, U) ⇒ R) extends ScalaFunction2Support[T, U, R]
  implicit class RichScalaOption[T](val scalaOption: Option[T]) extends ScalaOptionSupport[T]
  implicit class RichScalaStream[T](val scalaStream: Stream[T]) extends ScalaStreamSupport[T]
}
