
import sbt.Keys._
import sbt._

/** Adds common settings automatically to all subprojects */
object Build extends AutoPlugin {

  object autoImport {
    val org = "com.sksamuel.scrimage"
    val TwelveMonkeysVersion = "3.4.1"
    val PngjVersion = "2.1.0"
    val MetadataExtractorVersion = "2.10.1"
    val ScalatestVersion = "3.0.8"
    val CommonsIoVersion = "2.6"
  }

  import autoImport._

  def isTravis = System.getenv("TRAVIS") == "true"
  def travisBuildNumber = System.getenv("TRAVIS_BUILD_NUMBER")

  override def trigger = allRequirements
  override def projectSettings = Seq(
    organization := org,
    name := "scrimage",
    scalaVersion := "2.13.1",
    crossScalaVersions := Seq("2.12.8", "2.13.0"),
    parallelExecution in Test := false,
    scalacOptions := Seq("-unchecked", "-encoding", "utf8"),
    javacOptions := Seq("-source", "1.8", "-target", "1.8"),
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % "1.7.7",
      "org.imgscalr" % "imgscalr-lib" % "4.2" % "test",
      "org.scalatest" %% "scalatest" % ScalatestVersion % "test",
      "org.mockito" % "mockito-all" % "1.9.5" % "test"
    )
  )

}
