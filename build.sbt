ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / versionScheme := Some("semver-spec")
ThisBuild / scalaVersion := "3.7.2"
organization := "io.github.makingthematrix"
name := "ratio"
homepage := Some(url("https://github.com/makingthematrix/ratio"))
licenses := Seq("GPL 3.0" -> url("https://www.gnu.org/licenses/gpl-3.0.en.html"))

val standardOptions = Seq(
	"-deprecation",
	"-feature",
	"-unchecked",
	"-encoding",
	"utf8"
)

val scala3Options = Seq(
	"-explain",
	"-Wsafe-init",
	"-Ycheck-all-patmat",
	"-Wunused:imports"
)

developers := List(
	Developer(
		"makingthematrix",
		"Maciej Gorywoda",
		"makingthematrix@protonmail.com",
		url("https://github.com/makingthematrix"))
)

lazy val root = (project in file("."))
	.settings(
		name := "ratio",
		libraryDependencies ++= Seq(
			//Test dependencies
			"org.scalameta" %% "munit" % "1.1.1" % "test"
		),
		scalacOptions ++= standardOptions ++ scala3Options
	)

testFrameworks += new TestFramework("munit.Framework")

exportJars := true
Compile / packageBin / packageOptions +=
	Package.ManifestAttributes("Automatic-Module-Name" -> "ratio")

