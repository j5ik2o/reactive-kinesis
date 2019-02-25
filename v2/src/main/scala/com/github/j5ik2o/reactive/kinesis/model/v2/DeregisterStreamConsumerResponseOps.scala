package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{
  DeregisterStreamConsumerResponse => ScalaDeregisterStreamConsumerResponse
}
import software.amazon.awssdk.services.kinesis.model.{
  DeregisterStreamConsumerResponse => JavaDeregisterStreamConsumerResponse
}

import scala.collection.JavaConverters._

object DeregisterStreamConsumerResponseOps {

  implicit class JavaDeregisterStreamConsumerResponseOps(val self: JavaDeregisterStreamConsumerResponse)
      extends AnyVal {

    def toScala: ScalaDeregisterStreamConsumerResponse = {
      ScalaDeregisterStreamConsumerResponse()
        .withStatusCode(Some(self.sdkHttpResponse().statusCode()))
        .withHttpHeaders(Some(self.sdkHttpResponse().headers().asScala.toMap.mapValues(_.asScala)))
    }

  }

}
