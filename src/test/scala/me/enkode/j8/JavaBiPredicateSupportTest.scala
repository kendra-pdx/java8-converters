package me.enkode.j8

import java.util.function.BiPredicate

import org.scalatest.{FlatSpec, Matchers}

class JavaBiPredicateSupportTest extends FlatSpec with Matchers {
  val fixture = new JavaBiPredicateSupport[String, Int] {
    override def jBiPredicate: BiPredicate[String, Int] = new BiPredicate[String, Int] {
      override def test(t: String, u: Int): Boolean = t.length == u
    }
  }

  "JavaBiPredicateSupport" should "be able to convert a java bipredicate into a scala function" in {
    fixture.asScala("foobar", 6) should be (true)
    fixture.asScala("foobar", 7) should be (false)
  }
}
