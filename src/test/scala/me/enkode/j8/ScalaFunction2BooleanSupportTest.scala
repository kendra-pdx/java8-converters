package me.enkode.j8

import org.scalatest.{Matchers, FlatSpec}

class ScalaFunction2BooleanSupportTest extends FlatSpec with Matchers {
  case class Fixture(scalaFunction2: (String, String) ⇒ Boolean) extends ScalaFunction2BooleanSupport[String, String]
  object Compare extends Fixture((a, b) ⇒ a equalsIgnoreCase b)

  "ScalaFunction2BooleanSupport" should "be able to convert a scala (String, String) ⇒ Boolean to a java Predicate[String, String]" in {
    Compare.asJava.test("test", "TEST") should be (true)
  }
}
