
enablePlugins(ScalaJSPlugin)

lazy val copyRes = TaskKey[Unit]("copyRes") //.dependsOn(fullOptJS)

name := "Hello-World-ScalaJS"

version := "1.0.0"

scalaVersion := "2.13.4"

libraryDependencies += "net.exoego" %%% "aws-lambda-scalajs-facade" % "0.11.0"

scalaJSLinkerConfig ~= (_.withModuleKind(ModuleKind.CommonJSModule))
enablePlugins(ScalaJSBundlerPlugin)


copyRes := {
  import Path._
  val src = (Compile / target).value / "scala-2.13" / "scalajs-bundler" / "main"
  val jsFiles: Seq[File] = (src ** "*.js").get()
  val pairs = jsFiles pair rebase(src, baseDirectory.value / "hello-world" / "handler")
  println("Copied:")
  IO.copy(pairs, CopyOptions.apply(overwrite = true, preserveLastModified = true, preserveExecutable = false)).map(println)

}