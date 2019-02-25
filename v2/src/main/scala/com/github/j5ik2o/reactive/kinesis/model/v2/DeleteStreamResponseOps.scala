package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{ DeleteStreamResponse => ScalaDeleteStreamResponse }
import software.amazon.awssdk.services.kinesis.model.{ DeleteStreamResponse => JavaDeleteStreamResponse }

import scala.collection.JavaConverters._

object DeleteStreamResponseOps {

  implicit class JavaDeleteStreamResponseOps(val self: JavaDeleteStreamResponse) extends AnyVal {

    def toScala: ScalaDeleteStreamResponse = {
      ScalaDeleteStreamResponse()
        .withStatusCode(Option(self.sdkHttpResponse().statusCode()))
        .withHttpHeaders(Option(self.sdkHttpResponse().headers().asScala.mapValues(_.asScala).toMap))
    }

  }

}
