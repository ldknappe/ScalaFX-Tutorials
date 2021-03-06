// @formatter:off

name         := "Stand-Alone Dialog"
organization := "scalafx.org"
version      := "1.0.8"

scalaVersion := "2.13.1"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8")

libraryDependencies += "org.scalafx" %% "scalafx" % "14-R19"

// Add OS specific JavaFX dependencies
val javafxModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}
libraryDependencies ++= javafxModules.map(m => "org.openjfx" % s"javafx-$m" % "14.0.1" classifier osName)


// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true

//fork in console := true

shellPrompt := { _ => System.getProperty("user.name") + s":${name.value}> " }