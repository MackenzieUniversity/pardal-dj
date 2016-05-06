

name := """pardal-dj"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  evolutions,
  cache,
  ws,
  "com.typesafe.play" %% "anorm" % "2.4.0",
  "org.postgresql" % "postgresql" % "9.4.1208",
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

resolvers +=     "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += Resolver.url("sbt-plugin-snapshots", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator


fork in run := true