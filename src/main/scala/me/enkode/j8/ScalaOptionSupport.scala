package me.enkode.j8

import java.util.Optional

trait ScalaOptionSupport[T] {
  def scalaOption: Option[T]

  @inline
  def asJava: Optional[T] = if (scalaOption.isDefined) {
    Optional.ofNullable(scalaOption.get)
  } else {
    Optional.empty()
  }
}
