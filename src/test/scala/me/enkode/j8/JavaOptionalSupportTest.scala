package me.enkode.j8

import java.util.Optional

import org.scalatest.{Matchers, FlatSpec}

class JavaOptionalSupportTest extends FlatSpec with Matchers {
  case class Fixture(jOptional: Optional[String]) extends JavaOptionalSupport[String]

  "JavaOptionalSupport" should "be able to convert a java Optional to a scala Option" in {
    Fixture(Optional.of("test")).asScala should be (Some("test"))
    Fixture(Optional.ofNullable("test")).asScala should be (Some("test"))
    Fixture(Optional.ofNullable(null)).asScala should be (None)
    Fixture(Optional.empty()).asScala should be (None)
  }
}
