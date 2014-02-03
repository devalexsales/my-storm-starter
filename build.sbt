name := "my-storm-starter"

version := "1.0"

scalaVersion := "2.10.3"

sbtVersion:="0.12"

resolvers ++= Seq(
  "twitter4j" at "http://twitter4j.org/maven2",
  "clojars.org" at "http://clojars.org/repo"
)

libraryDependencies ++= Seq(
  "storm" % "storm" % "0.8.1",
  "org.twitter4j" % "twitter4j-core" % "2.2.6-SNAPSHOT",
  "org.twitter4j" % "twitter4j-stream" % "2.2.6-SNAPSHOT"
)