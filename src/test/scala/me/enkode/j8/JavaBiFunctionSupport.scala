package me.enkode.j8

import java.util.function.BiFunction

import org.scalatest.{Matchers, FlatSpec}

class JavaBiFunctionSupportTest extends FlatSpec with Matchers {
  val fixture = new JavaBiFunctionSupport[String, Int, String] {
    override def jBiFunction: BiFunction[String, Int, String] = new BiFunction[String, Int, String] {
      override def apply(t: String, u: Int): String = t * u
    }
  }

  "JavaBiFunctionSupport" should "be able to convert a java bifunction to a scala function" in {
    fixture.asScala("foo", 3) should be ("foofoofoo")
  }
}
