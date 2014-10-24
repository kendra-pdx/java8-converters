package me.enkode.j8

import java.util.stream.{Stream ⇒ JStream}
import org.scalatest.{Matchers, FlatSpec}

class JavaStreamSupportTest extends FlatSpec with Matchers {
  val fixture = new JavaStreamSupport[String] {
    override def jStream: JStream[String] = JStream.of("a", "b", "c")
  }

  "JavaStreamSupport" should "be able to convert a java stream to a scala stream" in {
    val sStream = fixture.asScala
    sStream.toSet should be(Set("a", "b", "c"))
  }
}
