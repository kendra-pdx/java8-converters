name := "java8-converters"

organization := "me.enkode"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)

crossScalaVersions := Seq(
  "2.10", "2.11"
)
