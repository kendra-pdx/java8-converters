package me.enkode.j8

import java.util.function.Function

import org.scalatest.{Matchers, FlatSpec}

class JavaFunctionSupportTest extends FlatSpec with Matchers {
  val fixture = new JavaFunctionSupport[String, String] {
    override def jFunction: Function[String, String] = new Function[String, String] {
      override def apply(t: String): String = t.toUpperCase
    }
  }

  "JavaFunctionSupport" should "be able to convert a java function to a scala function" in {
    fixture.asScala("foo") should be ("FOO")
  }
}
