/*
 * Copyright 2015 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import sbt.Keys._
import sbt._
import uk.gov.hmrc.versioning.SbtGitVersioning

object HmrcBuild extends Build {
  import play.core.PlayVersion
  import uk.gov.hmrc.DefaultBuildSettings._
  import uk.gov.hmrc._

  val nameApp = "pertax-integration"

  val appDependencies = Seq(
    "com.typesafe.play" %% "play" % PlayVersion.current,
    "org.scalatest" %% "scalatest" % "2.2.1" % "test",
    "org.pegdown" % "pegdown" % "1.4.2" % "test",
    "uk.gov.hmrc" %% "play-breadcrumb" % "0.3.0",
    "uk.gov.hmrc" %% "play-ui" % "3.0.0"
  )

  lazy val playBreadcrumb = Project(nameApp, file("."))
    .enablePlugins(play.PlayScala, SbtAutoBuildPlugin, SbtGitVersioning)
    .settings(
      targetJvm := "jvm-1.7",
      libraryDependencies ++= appDependencies,
      crossScalaVersions := Seq("2.11.7"),
      resolvers := Seq(
        Resolver.bintrayRepo("hmrc", "releases"),
        "typesafe-releases" at "http://repo.typesafe.com/typesafe/releases/"
      )
    )
}
