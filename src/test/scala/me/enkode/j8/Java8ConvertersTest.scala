package me.enkode.j8

import java.util.Optional
import java.util.stream.{Stream ⇒ JStream}
import java.util.function.{Function ⇒ JFunction, _}

import org.scalatest.{FlatSpec, Matchers}

class Java8ConvertersTest extends FlatSpec with Matchers {
  import me.enkode.j8.Java8Converters._

  /* ===========================================================================================
     Conventions to Scala equivalents
     =========================================================================================== */
  "Java8Converters" should "be able to implicitly convert a java function to a scala function" in {
    new JFunction[String, Int] {
      override def apply(t: String): Int = t.length
    }.asScala("test") should be (4)
  }

  it should "be able to implicitly convert a java predicate to a scala function" in {
    new Predicate[String] {
      override def test(t: String): Boolean = t.toBoolean
    }.asScala("true") should be (true)
  }

  it should "be able to implicitly convert a java supplier to a scala function" in {
    new Supplier[String] {
      override def get(): String = "test"
    }.asScala() should be ("test")
  }

  it should "be able to implicitly convert a java consumer to a scala function" in {
    var consumed = false
    new Consumer[Boolean] {
      override def accept(t: Boolean): Unit = consumed = true
    }.asScala(true)
    consumed should be (true)
  }

  it should "be able to implicitly convert a java bi-function to a scala function" in {
    new BiFunction[Int, Int, Int]() {
      override def apply(t: Int, u: Int): Int = t + u
    }.asScala(2, 3) should be (5)

  }

  it should "be able to implicitly convert a java bi-consumer to a scala function" in {
    var consumed = false
    new BiConsumer[Boolean, Boolean]() {
      override def accept(t: Boolean, u: Boolean): Unit = consumed = true
    }.asScala(true, false)
    consumed should be (true)
  }

  it should "be able to implicitly convert a java bi-predicate to a scala function" in {
    new BiPredicate[Boolean, Boolean] {
      override def test(t: Boolean, u: Boolean): Boolean = t ^ u
    }.asScala(true, false) should be (true)
  }

  it should "be able to implicitly convert a java optional to a scala option" in {
    Optional.of("test").asScala should be (Some("test"))
    Optional.ofNullable(null).asScala should be (None)
    Optional.empty().asScala should be (None)
  }

  it should "be able to implicitly convert a java stream to a scala stream" in {
    JStream.of("a", "b", "c", "d").asScala.mkString should be ("abcd")
  }

  /* ===========================================================================================
   Conventions to Java equivalents
   =========================================================================================== */
  it should "be able to implicitly convert a scala (Int) ⇒ Boolean to a java predicate" in {
    def isPositive(i: Int) = i > 0
    (isPositive _).asJava.test(1) should be (true)
  }

  it should "be able to implicitly convert a scala (Int) ⇒ Unit to a java consumer" in {
    var consumed = false
    def consume(i: Int) = consumed = true
    (consume _).asJava.accept(0)
    consumed should be (true)
  }

  it should "be able to implicitly convert a scala (String) ⇒ Int to a java function" in {
    def lengthOf(s: String) = s.length
    (lengthOf _).asJava.apply("test") should be (4)
  }

  it should "be able to implicitly convert a scala () ⇒ String to a java supplier" in {
    def generate() = "test"
    (generate _).asJava.get() should be ("test")
  }

  it should "be able to implicitly convert a scala (String, String) ⇒ Int to a java bi-function" in {
    def addStrings(a: String, b: String) = a.toInt + b.toInt
    (addStrings _).asJava.apply("6", "7") should be (13)
  }

  it should "be able to implicitly convert a scala (String, String) ⇒ Unit to a java bi-consumer" in {
    var consumed = false
    def consume(a: String, b: String) = consumed = true
    (consume _).asJava.accept("foo", "bar")
    consumed should be (true)
  }

  it should "be able to implicitly convert a scala (String, String) ⇒ Boolean to a java bi-predicate" in {
    def compare(a: String, b: String) = a equalsIgnoreCase b
    (compare _).asJava.test("test", "TEST") should be (true)
  }

  it should "be able to implicitly convert a scala Option[String] to a java Optional[String]" in {
    None.asJava should be (Optional.empty())
    Some(null).asJava should be (Optional.empty())
    Some("foo").asJava should be (Optional.of("foo"))
  }

  it should "be able to implicity convert a scala Stream to a java Stream" in {
    Stream("a", "b", "c").asJava.count() should be (3)
  }
}
