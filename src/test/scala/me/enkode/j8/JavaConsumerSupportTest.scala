package me.enkode.j8

import java.util.function.Consumer

import org.scalatest.{Matchers, FlatSpec}

class JavaConsumerSupportTest extends FlatSpec with Matchers {
  def fixture(onAccept: (String) ⇒ Unit) = new JavaConsumerSupport[String] {
    override def jConsumer: Consumer[String] = new Consumer[String] {
      override def accept(t: String): Unit = onAccept(t)
    }
  }

  "JavaConsumerSupport" should "be able to convert to a scala function" in {
    var consumed = false
    val consumption = fixture((value) ⇒ consumed = true).asScala
    consumption("foo")
    consumed should be (true)
  }
}
