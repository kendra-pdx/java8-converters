package me.enkode.j8

import org.scalatest.{FlatSpec, Matchers}

class ScalaFunction1SupportTest extends FlatSpec with Matchers {
  case class Fixture(scalaFunction1: (String) ⇒ Int) extends ScalaFunction1Support[String, Int]

  "ScalaFunction1Support" should "be able to convert a scala (T) ⇒ R to a java Function[T, R]" in {
    Fixture((s: String) ⇒ s.length).asJava.apply("test") should be (4)
  }
}
