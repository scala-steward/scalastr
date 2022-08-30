import sbt._

object Deps {

  object V {
    val akkaV = "10.2.9"
    val akkaStreamV = "2.6.19"
    val akkaActorV: String = akkaStreamV

    val bitcoinsV = "1.9.2-195-2cae3f80-SNAPSHOT"

    val testContainersV = "0.40.10"

    val grizzledSlf4jV = "1.3.4"
  }

  object Compile {

    val akkaHttp =
      "com.typesafe.akka" %% "akka-http" % V.akkaV withSources () withJavadoc ()

    val akkaStream =
      "com.typesafe.akka" %% "akka-stream" % V.akkaStreamV withSources () withJavadoc ()

    val akkaActor =
      "com.typesafe.akka" %% "akka-actor" % V.akkaStreamV withSources () withJavadoc ()

    val akkaSlf4j =
      "com.typesafe.akka" %% "akka-slf4j" % V.akkaStreamV withSources () withJavadoc ()

    val grizzledSlf4j =
      "org.clapper" %% "grizzled-slf4j" % V.grizzledSlf4jV withSources () withJavadoc ()

    val bitcoinsKeyManager =
      "org.bitcoin-s" %% "bitcoin-s-key-manager" % V.bitcoinsV withSources () withJavadoc ()

    val bitcoinsTor =
      "org.bitcoin-s" %% "bitcoin-s-tor" % V.bitcoinsV withSources () withJavadoc ()

    val bitcoinsTestkitCore =
      "org.bitcoin-s" %% "bitcoin-s-testkit-core" % V.bitcoinsV withSources () withJavadoc ()

    val bitcoinsTestkit =
      "org.bitcoin-s" %% "bitcoin-s-testkit" % V.bitcoinsV withSources () withJavadoc ()

    val bitcoinsAppCommons =
      "org.bitcoin-s" %% "bitcoin-s-app-commons" % V.bitcoinsV withSources () withJavadoc ()

    val bitcoinsDbCommons =
      "org.bitcoin-s" %% "bitcoin-s-db-commons" % V.bitcoinsV withSources () withJavadoc ()

    val testContainers =
      "com.dimafeng" %% "testcontainers-scala-scalatest" % V.testContainersV withSources () withJavadoc ()
  }

  val core: List[ModuleID] = List(
    Compile.bitcoinsAppCommons
  )

  val coreTest: List[ModuleID] = List(
    Compile.bitcoinsTestkitCore
  )

  val client: List[ModuleID] = List(
    Compile.bitcoinsKeyManager,
    Compile.bitcoinsAppCommons,
    Compile.bitcoinsDbCommons,
    Compile.bitcoinsTor,
    Compile.akkaActor,
    Compile.akkaHttp,
    Compile.akkaStream,
    Compile.akkaSlf4j
  )

  val testkit: List[ModuleID] = List(
    Compile.bitcoinsTestkit,
    Compile.grizzledSlf4j,
    Compile.testContainers
  )

}
