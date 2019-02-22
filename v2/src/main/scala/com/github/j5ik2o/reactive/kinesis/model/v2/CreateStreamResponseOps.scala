package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{ CreateStreamResponse => ScalaCreateStreamResponse }
import software.amazon.awssdk.services.kinesis.model.{ CreateStreamResponse => JavaCreateStreamResponse }

import scala.collection.JavaConverters._

object CreateStreamResponseOps {

  implicit class JavaCreateStreamResponseOps(val self: JavaCreateStreamResponse) extends AnyVal {

    def toScala: ScalaCreateStreamResponse = {
      ScalaCreateStreamResponse()
        .withStatusCode(Option(self.sdkHttpResponse().statusCode()))
        .withHttpHeaders(Option(self.sdkHttpResponse().headers().asScala.mapValues(_.asScala).toMap))
    }

  }

}
