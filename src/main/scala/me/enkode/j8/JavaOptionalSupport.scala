package me.enkode.j8

import java.util.Optional

trait JavaOptionalSupport[T] {
  def jOptional: Optional[T]

  def asScala = if (jOptional.isPresent) {
    Option(jOptional.get())
  } else {
    None
  }
}
