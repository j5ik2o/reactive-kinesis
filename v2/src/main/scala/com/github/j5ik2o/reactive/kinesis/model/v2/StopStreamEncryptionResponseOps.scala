package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{ StopStreamEncryptionResponse => ScalaStopStreamEncryptionResponse }
import software.amazon.awssdk.services.kinesis.model.{
  StopStreamEncryptionResponse => JavaStopStreamEncryptionResponse
}

import scala.collection.JavaConverters._
import scala.compat.java8.OptionConverters._

object StopStreamEncryptionResponseOps {

  implicit class JavaStopStreamEncryptionResponseOps(val self: JavaStopStreamEncryptionResponse) extends AnyVal {

    def toScala: ScalaStopStreamEncryptionResponse = {
      ScalaStopStreamEncryptionResponse()
        .withStatusCode(Option(self.sdkHttpResponse().statusCode()))
        .withStatusText(self.sdkHttpResponse().statusText().asScala)
        .withHttpHeaders(Option(self.sdkHttpResponse().headers().asScala.mapValues(_.asScala).toMap))
    }

  }
}
