package me.enkode.j8

import java.util.stream.Collectors

import org.scalatest.{Matchers, FlatSpec}

class ScalaStreamSupportTest extends FlatSpec with Matchers {
  case class Fixture(scalaStream: Stream[String]) extends ScalaStreamSupport[String]

  "ScalaStreamSupport" should "be able to convert a finite scala stream to a java stream" in {
    val jStream = Fixture(Stream("a", "b", "c")).asJava
    jStream.count() should be (3)
  }

  "ScalaStreamSupport" should "be able to convert an empty scala stream to an empty java stream" in {
    Fixture(Stream.empty).asJava.count() should be (0)
  }
}
