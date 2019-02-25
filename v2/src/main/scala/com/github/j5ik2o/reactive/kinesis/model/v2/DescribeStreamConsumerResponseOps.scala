package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{
  DescribeStreamConsumerResponse => ScalaDescribeStreamConsumerResponse
}
import software.amazon.awssdk.services.kinesis.model.{
  DescribeStreamConsumerResponse => JavaDescribeStreamConsumerResponse
}

import scala.collection.JavaConverters._

object DescribeStreamConsumerResponseOps {

  import ConsumerDescriptionOps._

  implicit class JavaDescribeStreamConsumerResponseOps(val self: JavaDescribeStreamConsumerResponse) extends AnyVal {
    def toScala: ScalaDescribeStreamConsumerResponse = {
      ScalaDescribeStreamConsumerResponse()
        .withStatusCode(Some(self.sdkHttpResponse().statusCode()))
        .withHttpHeaders(Some(self.sdkHttpResponse().headers().asScala.toMap.mapValues(_.asScala)))
        .withConsumerDescription(Option(self.consumerDescription()).map(_.toScala))
    }
  }

}
