package me.enkode.j8

import org.scalatest.{Matchers, FlatSpec}

class ScalaFunction1UnitSupportTest extends FlatSpec with Matchers {
  case class Fixture(scalaFunction1: (String) ⇒ Unit) extends ScalaFunction1UnitSupport[String]

  "ScalaFunction1UnitSupport" should "be able to convert a scala (String) ⇒ Unit to a java Consumer[Unit]" in {
    var consumed = false
    object Consumer extends Fixture(_ ⇒ consumed = true)
    Consumer.asJava.accept("foo")
    consumed should be (true)
  }
}
