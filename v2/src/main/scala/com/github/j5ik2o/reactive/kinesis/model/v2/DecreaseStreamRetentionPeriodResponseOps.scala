package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{
  DecreaseStreamRetentionPeriodResponse => ScalaDecreaseStreamRetentionPeriodResponse
}
import software.amazon.awssdk.services.kinesis.model.{
  DecreaseStreamRetentionPeriodResponse => JavaDecreaseStreamRetentionPeriodResponse
}

import scala.collection.JavaConverters._
import scala.compat.java8.OptionConverters._

object DecreaseStreamRetentionPeriodResponseOps {

  implicit class JavaDecreaseStreamRetentionPeriodResponseOps(val self: JavaDecreaseStreamRetentionPeriodResponse) {

    def toScala: ScalaDecreaseStreamRetentionPeriodResponse = {
      ScalaDecreaseStreamRetentionPeriodResponse()
        .withStatusCode(Option(self.sdkHttpResponse().statusCode()))
        .withStatusText(self.sdkHttpResponse().statusText().asScala)
        .withHttpHeaders(Option(self.sdkHttpResponse().headers().asScala.mapValues(_.asScala).toMap))
    }

  }
}
