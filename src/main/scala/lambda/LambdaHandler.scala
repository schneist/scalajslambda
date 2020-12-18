package lambda

import net.exoego.facade.aws_lambda._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.JSConverters.JSRichFutureNonThenable
import scala.scalajs.js.annotation._
import scala.scalajs.js.{Promise, UndefOr}
import scala.util.Try


object LambdaHandler {

  @JSExportTopLevel(name = "LambdaHandler")
  def handle(event: S3Event, context: Context): Promise[Unit] = {
    context.succeed("any")
    Future.successful().toJSPromise
  }
}



