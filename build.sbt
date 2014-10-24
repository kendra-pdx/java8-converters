seq(bintraySettings:_*)

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)

name := "java8-converters"

organization := "me.enkode"

version := "1.0.1-SNAPSHOT"

crossScalaVersions := Seq(
  "2.10", "2.11"
)

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
