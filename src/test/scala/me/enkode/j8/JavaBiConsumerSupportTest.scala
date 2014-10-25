package me.enkode.j8

import java.util.function.BiConsumer

import org.scalatest.{Matchers, FlatSpec}

class JavaBiConsumerSupportTest extends FlatSpec with Matchers {
  def fixture(onAccept: (String, Int) ⇒ Unit) = new JavaBiConsumerSupport[String, Int] {
    override def jBiConsumer: BiConsumer[String, Int] = new BiConsumer[String, Int] {
      override def accept(t: String, u: Int): Unit = onAccept(t, u)
    }
  }

  "JavaBiConsumerSupport" should "be able to convert a java biconsumer to a scala function" in {
    var consumed = false
    val consumption = fixture((t, u) ⇒ consumed = true).asScala
    consumption("foo", 42)
    consumed should be (true)
  }
}
