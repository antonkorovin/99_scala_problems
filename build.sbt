name := "99_scala_problems"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.13.8"

scalacOptions ++= Seq(
  "-encoding"
  , "UTF-8"
  , "-deprecation"
  , "-unchecked"
  , "-feature"
  , "-explaintypes"
  , "-Xlint"
  , "-Xfatal-warnings"
  , "-Ywarn-dead-code"
  , "-Ywarn-unused:imports"
  , "-Ywarn-unused:locals"
  , "-Ywarn-unused:params"
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.2" % "test"

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.22.0"
