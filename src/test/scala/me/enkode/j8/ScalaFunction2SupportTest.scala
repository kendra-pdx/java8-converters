package me.enkode.j8

import org.scalatest.{Matchers, FlatSpec}

class ScalaFunction2SupportTest extends FlatSpec with Matchers {
  case class Fixture(scalaFunction2: (Int, Int) ⇒ Int) extends ScalaFunction2Support[Int, Int, Int]
  object Adder extends Fixture((a, b) ⇒ a + b)

  "ScalaFunction2Support" should "be able to convert a scala (Int, Int) ⇒ Int to a java BiFunction[Int,Int,Int]" in {
    Adder.asJava.apply(3, 4) should be (7)
  }
}
