package me.enkode.j8

import org.scalatest.{Matchers, FlatSpec}

class ScalaFunction1BooleanSupportTest extends FlatSpec with Matchers {
  case class Fixture(scalaFunction1: (Int) ⇒ Boolean) extends ScalaFunction1BooleanSupport[Int]
  object IsPositive extends Fixture(_ > 0)

  "ScalaFunction1BooleanSupport" should "be able to convert a scala (Int) ⇒ Boolean to a java Predicate[Int]" in {
    IsPositive.asJava.test(1) should be (true)
    IsPositive.asJava.test(-1) should be (false)
  }
}
