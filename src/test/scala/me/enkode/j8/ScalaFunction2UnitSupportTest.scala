package me.enkode.j8

import org.scalatest.{Matchers, FlatSpec}

class ScalaFunction2UnitSupportTest extends FlatSpec with Matchers {
  case class Fixture(scalaFunction2: (Int, Int) ⇒ Unit) extends ScalaFunction2UnitSupport[Int, Int]

  "ScalaFunction2UnitSupport" should "be able to convert a scala (Int, Int) ⇒ Unit to a java BiConsumer[Int, Int]" in {
    var consumed = false
    object Consumer extends Fixture((a, b) ⇒ consumed = true)
    Consumer.asJava.accept(1, 5)
    consumed should be (true)
  }
}
