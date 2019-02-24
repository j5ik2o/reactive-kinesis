val scalaVersion211 = "2.11.12"
val scalaVersion212 = "2.12.8"

val awsSdk1Version = "1.11.492"
val awsSdk2Version = "2.4.0"

val catsVersion  = "1.5.0"
val monixVersion = "3.0.0-RC2"
val akkaVersion  = "2.5.19"

val compileScalaStyle = taskKey[Unit]("compileScalaStyle")

lazy val scalaStyleSettings = Seq(
  (scalastyleConfig in Compile) := file("scalastyle-config.xml"),
  compileScalaStyle := scalastyle.in(Compile).toTask("").value,
  (compile in Compile) := (compile in Compile)
    .dependsOn(compileScalaStyle)
    .value
)

val coreSettings = Seq(
  sonatypeProfileName := "com.github.j5ik2o",
  organization := "com.github.j5ik2o",
  scalaVersion := scalaVersion212,
  crossScalaVersions ++= Seq(scalaVersion211, scalaVersion212),
  scalacOptions ++= {
    Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-encoding",
      "UTF-8",
      "-language:_",
      "-Ydelambdafy:method",
      "-target:jvm-1.8"
    )
  },
  publishMavenStyle := true,
  publishArtifact in Test := false,
  pomIncludeRepository := { _ =>
    false
  },
  pomExtra := {
    <url>https://github.com/j5ik2o/reactive-kinesis</url>
      <licenses>
        <license>
          <name>The MIT License</name>
          <url>http://opensource.org/licenses/MIT</url>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:j5ik2o/reactive-kinesis.git</url>
        <connection>scm:git:github.com/j5ik2o/reactive-kinesis</connection>
        <developerConnection>scm:git:git@github.com:j5ik2o/reactive-kinesis.git</developerConnection>
      </scm>
      <developers>
        <developer>
          <id>j5ik2o</id>
          <name>Junichi Kato</name>
        </developer>
      </developers>
  },
  publishTo in ThisBuild := sonatypePublishTo.value,
  credentials := {
    val ivyCredentials = (baseDirectory in LocalRootProject).value / ".credentials"
    Credentials(ivyCredentials) :: Nil
  },
  scalafmtOnCompile in ThisBuild := true,
  scalafmtTestOnCompile in ThisBuild := true,
  resolvers ++= Seq(
    Resolver.bintrayRepo("danslapman", "maven"),
    Resolver.sonatypeRepo("releases"),
    "kinesis Local Repository" at "https://s3-us-west-2.amazonaws.com/kinesis-local/release"
  ),
  addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.7"),
  libraryDependencies ++= Seq(
    "com.beachape"           %% "enumeratum"         % "1.5.13",
    "org.slf4j"              % "slf4j-api"           % "1.7.25",
    "org.scala-lang.modules" %% "scala-java8-compat" % "0.9.0",
    "org.scalatest"          %% "scalatest"          % "3.0.5" % Test,
    "org.scalacheck"         %% "scalacheck"         % "1.14.0" % Test,
    "ch.qos.logback"         % "logback-classic"     % "1.2.3" % Test
  ),
  parallelExecution in Test := false,
  wartremoverErrors ++= Warts.allBut(Wart.Any,
                                     Wart.Throw,
                                     Wart.Nothing,
                                     Wart.Product,
                                     Wart.NonUnitStatements,
                                     Wart.DefaultArguments,
                                     Wart.ImplicitParameter,
                                     Wart.StringPlusAny,
                                     Wart.Overloading),
  wartremoverExcluded += baseDirectory.value / "src" / "test" / "scala",
  envVars in Test := Map("AWS_CBOR_DISABLE" -> "1")
) ++ scalaStyleSettings

lazy val test = (project in file("test"))
  .settings(
    coreSettings ++ Seq(
      name := "reactive-kinesis-test",
      libraryDependencies ++= Seq(
        "com.google.guava" % "guava"                        % "25.1-jre",
        "commons-io"       % "commons-io"                   % "2.6",
        "org.scalatest"    %% "scalatest"                   % "3.0.5" % Provided,
        "com.whisk"        %% "docker-testkit-scalatest"    % "0.9.8",
        "com.whisk"        %% "docker-testkit-impl-spotify" % "0.9.8",
        "com.amazonaws"    % "aws-java-sdk-kinesis"         % "1.11.492",
        "org.seasar.util"  % "s2util"                       % "0.0.1"
      )
    )
  )

lazy val core = (project in file("core")).settings(
  coreSettings ++ Seq(
    name := "reactive-kinesis-core",
    libraryDependencies ++= Seq(
      "org.reactivestreams" % "reactive-streams" % "1.0.0"
    )
  )
)

lazy val cats = (project in file("cats")).settings(
  coreSettings ++ Seq(
    name := "reactive-kinesis-cats",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % catsVersion,
      "org.typelevel" %% "cats-free" % catsVersion
    )
  )
) dependsOn (core, test % "test")

lazy val monix = (project in file("monix")).settings(
  coreSettings ++ Seq(
    name := "reactive-kinesis-monix",
    libraryDependencies ++= Seq(
      "io.monix" %% "monix" % monixVersion
    )
  )
) dependsOn (core, test % "test")

lazy val akka = (project in file("akka")).settings(
  coreSettings ++ Seq(
    name := "reactive-kinesis-akka",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor"          % akkaVersion,
      "com.typesafe.akka" %% "akka-testkit"        % akkaVersion % Test,
      "com.typesafe.akka" %% "akka-stream"         % akkaVersion,
      "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,
      "com.typesafe.akka" %% "akka-slf4j"          % akkaVersion
    )
  )
) dependsOn (core, test % "test")

lazy val v1 = (project in file("v1")).settings(
  coreSettings ++ Seq(
    name := "reactive-kinesis-v1",
    libraryDependencies ++= Seq(
      "com.amazonaws" % "aws-java-sdk-kinesis" % awsSdk1Version
    )
  )
) dependsOn (core, test % "test")

lazy val `v1-cats` = (project in file("v1-cats")).settings(
  coreSettings ++ Seq(
    name := "reactive-kinesis-v1-cats",
    libraryDependencies ++= Seq(
      "com.amazonaws" % "aws-java-sdk-kinesis" % awsSdk1Version
    )
  )
) dependsOn (v1, cats, test % "test")

lazy val v2 = (project in file("v2")).settings(
  coreSettings ++ Seq(
    name := "reactive-kinesis-v2",
    libraryDependencies ++= Seq(
      "software.amazon.awssdk" % "kinesis" % awsSdk2Version
    )
  )
) dependsOn (core, test % "test")

lazy val `v2-akka` = (project in file("v2-akka")).settings(
  coreSettings ++ Seq(
    name := "reactive-kinesis-v2-akka",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-testkit"        % akkaVersion % Test,
      "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test
    )
  )
) dependsOn (v2, akka, test % "test")

lazy val `v2-monix` = (project in file("v2-monix")).settings(
  coreSettings ++ Seq(
    name := "reactive-kinesis-v2-monix",
    libraryDependencies ++= Seq(
      )
  )
) dependsOn (v2, monix, test % "test")

lazy val `v2-cats` = (project in file("v2-cats")).settings(
  coreSettings ++ Seq(
    name := "reactive-kinesis-v2-cats",
    libraryDependencies ++= Seq(
      )
  )
) dependsOn (v2, cats, test % "test")

lazy val `root`: Project = (project in file("."))
  .settings(coreSettings)
  .settings(
    name := "reactive-kinesis-project"
  )
  .aggregate(core, test, v1, v2, monix, cats, akka, `v2-akka`, `v2-monix`)
