Java 8 Converters
=================

Utilities for converting between Scala and Java 8 functional structures.

Supported conversions:

- scala `() ⇒ R` to/from java `Supplier[R]`
- scala `(T) ⇒ R` to/from java `Function[T, R]`
- scala `(T) ⇒ Unit` to/from java `Consumer[T]`
- scala `(T) ⇒ Boolean` to/from java `Predicate[T]`
- scala `(T, U) ⇒ R` to/from java `BiFunction[T, U, R]`
- scala `(T, U) ⇒ Unit` to/from java `BiConsumer[T, U]`
- scala `(T, U) ⇒ Boolean` to/from java `BiPredicate[T, U]`
- scala `Stream[T]` to/from java `Stream[T]`
- scala `Option[T]` to/from java `Optional[T]`

Follows the same class enrichment pattern as scala-library's [JavaConverters](http://www.scala-lang.org/api/current/#scala.collection.JavaConverters$) by adding `.asJava` and `.asScala` methods to appropriate classes.

## How to Use

In your build:

```scala
resolvers += "kender" at "http://dl.bintray.com/kender/maven"

libraryDependencies += "me.enkode" %% "java8-converters" % "1.1.0"
```

In your program:

```scala
import me.enkode.j8.Java8Converters._
```

see [the unit tests](https://github.com/kender/java8-converters/blob/develop/src/test/scala/me/enkode/j8/Java8ConvertersTest.scala) for full usage examples.

[ ![Download](https://api.bintray.com/packages/kender/maven/java8-converters/images/download.svg) ](https://bintray.com/kender/maven/java8-converters/_latestVersion)
