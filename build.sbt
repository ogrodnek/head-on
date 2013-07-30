organization := "com.ogrodnek"

name := "head-on"

version := "0.0.1"

scalaVersion := "2.10.2"

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.10" % "test",
  "com.novocode" % "junit-interface" % "0.10-M4" % "test"
)
