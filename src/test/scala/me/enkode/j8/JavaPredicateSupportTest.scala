package me.enkode.j8

import java.util.function.Predicate

import org.scalatest.{Matchers, FlatSpec}

class JavaPredicateSupportTest extends FlatSpec with Matchers {
  val fixture = new JavaPredicateSupport[String] {
    override def jPredicate: Predicate[String] = new Predicate[String] {
      override def test(t: String): Boolean = !t.isEmpty()
    }
  }

  "JavaPredicateSupport" should "be able to convert a java predicate to a scala function" in {
    fixture.asScala("not empty") should be (true)
    fixture.asScala("") should be (false)
  }
}
