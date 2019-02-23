package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{ DescribeLimitsResponse => ScalaDescribeLimitsResponse }
import software.amazon.awssdk.services.kinesis.model.{ DescribeLimitsResponse => JavaDescribeLimitsResponse }

import scala.collection.JavaConverters._

object DescribeLimitsResponseOps {

  implicit class JavaDescribeLimitsResponseOps(val self: JavaDescribeLimitsResponse) extends AnyVal {

    def toScala: ScalaDescribeLimitsResponse = {
      ScalaDescribeLimitsResponse()
        .withStatusCode(Some(self.sdkHttpResponse().statusCode()))
        .withHttpHeaders(Some(self.sdkHttpResponse().headers().asScala.toMap.mapValues(_.asScala)))
    }

  }

}
