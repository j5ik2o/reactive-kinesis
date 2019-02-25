package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{
  IncreaseStreamRetentionPeriodResponse => ScalaIncreaseStreamRetentionPeriodResponse
}
import software.amazon.awssdk.services.kinesis.model.{
  IncreaseStreamRetentionPeriodResponse => JavaIncreaseStreamRetentionPeriodResponse
}
import scala.collection.JavaConverters._

object IncreaseStreamRetentionPeriodResponseOps {

  implicit class JavaIncreaseStreamRetentionPeriodResponseOps(val self: JavaIncreaseStreamRetentionPeriodResponse)
      extends AnyVal {

    def toScala: ScalaIncreaseStreamRetentionPeriodResponse = {
      ScalaIncreaseStreamRetentionPeriodResponse()
        .withStatusCode(Option(self.sdkHttpResponse().statusCode()))
        .withHttpHeaders(Option(self.sdkHttpResponse().headers().asScala.mapValues(_.asScala).toMap))
    }

  }

}
