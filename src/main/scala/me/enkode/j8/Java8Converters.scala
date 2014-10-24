package me.enkode.j8

import java.util.function.{Consumer, Supplier, Function ⇒ JFunction}
import java.util.stream.{Stream ⇒ JStream}

object Java8Converters {
  implicit class RichJavaSupplier[T](val jSupplier: Supplier[T]) extends JavaSupplierSupport[T]
  implicit class RichJavaConsumer[T](val jConsumer: Consumer[T]) extends JavaConsumerSupport[T]
  implicit class RichJavaFunction[T, R](val jFunction: JFunction[T, R]) extends JavaFunctionSupport[T, R]
  implicit class RichJavaStream[T](val jStream: JStream[T]) extends JavaStreamSupport[T]
}
