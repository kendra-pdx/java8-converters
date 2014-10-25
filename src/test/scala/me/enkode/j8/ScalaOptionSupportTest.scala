package me.enkode.j8

import java.util.Optional

import org.scalatest.{Matchers, FlatSpec}

class ScalaOptionSupportTest extends FlatSpec with Matchers {
  case class Fixture[T](scalaOption: Option[T]) extends ScalaOptionSupport[T]

  "ScalaOptionSupportTest" should "be able to convert a scala Option to a java Optional" in {
    Fixture(Some(1)).asJava.get() should be (1)
    Fixture(None).asJava should be (Optional.empty())
    Fixture(Some(null)).asJava should be (Optional.empty())
  }
}
