package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{
  RegisterStreamConsumerResponse => ScalaRegisterStreamConsumerResponse
}
import software.amazon.awssdk.services.kinesis.model.{
  RegisterStreamConsumerResponse => JavaRegisterStreamConsumerResponse
}
import scala.collection.JavaConverters._
object RegisterStreamConsumerResponseOps {

  import ConsumerOps._

  implicit class JavaRegisterStreamConsumerResponseOps(val self: JavaRegisterStreamConsumerResponse) extends AnyVal {

    def toScala: ScalaRegisterStreamConsumerResponse = {
      ScalaRegisterStreamConsumerResponse()
        .withStatusCode(Option(self.sdkHttpResponse().statusCode()))
        .withHttpHeaders(Option(self.sdkHttpResponse().headers().asScala.mapValues(_.asScala).toMap))
        .withConsumer(Option(self.consumer()).map(_.toScala))
    }

  }

}
