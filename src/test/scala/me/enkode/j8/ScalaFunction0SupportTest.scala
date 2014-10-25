package me.enkode.j8

import org.scalatest.{Matchers, FlatSpec}

class ScalaFunction0SupportTest extends FlatSpec with Matchers {
  case class Fixture(eval: () ⇒ Boolean) extends ScalaFunction0Support[Boolean] {
    override val scalaFunction0: () ⇒ Boolean = eval
  }

  "ScalaFunction0Support" should "be able to convert a scala function0 to a java supplier" in {
    Fixture(() ⇒ true).asJava.get() should be (true)
  }
}
