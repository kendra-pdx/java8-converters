package me.enkode.j8

import java.util.function.Supplier

import org.scalatest.{Matchers, FlatSpec}

class JavaSupplierSupportTest extends FlatSpec with Matchers {
  val fixture = new JavaSupplierSupport[String] {
    override def jSupplier: Supplier[String] = new Supplier[String] {
      override def get(): String = "hello world"
    }
  }

  "JavaSupplierSupport" should "be able to convert a supplier to a scala function" in {
    val fn = fixture.asScala
    fn() should be ("hello world")
  }
}
