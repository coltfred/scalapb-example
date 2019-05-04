scalaVersion     := "2.12.8"
version          := "0.1.0-SNAPSHOT"
organization     := "com.example"
organizationName := "scalapb-example"

name := "scalapb-Test"
PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

// (optional) If you need scalapb/scalapb.proto or anything from
// google/protobuf/*.proto
libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"