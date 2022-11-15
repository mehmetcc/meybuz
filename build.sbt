ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val Fs2Version      = "3.3.0"
lazy val Log4CatsVersion = "2.5.0"
lazy val LogbackVersion  = "1.4.4"

lazy val root = (project in file("."))
  .settings(
    name := "meybuz",
    libraryDependencies ++= Seq(
      "co.fs2"        %% "fs2-core"        % Fs2Version,
      "org.typelevel" %% "log4cats-slf4j"  % Log4CatsVersion,
      "ch.qos.logback" % "logback-classic" % LogbackVersion % Runtime
    ),
    idePackagePrefix := Some("me.mehmetcc")
  )
