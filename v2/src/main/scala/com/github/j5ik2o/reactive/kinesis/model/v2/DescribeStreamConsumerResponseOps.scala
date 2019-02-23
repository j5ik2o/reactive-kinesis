package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{
  DescribeStreamConsumerResponse => ScalaDescribeStreamConsumerResponse
}
import software.amazon.awssdk.services.kinesis.model.{
  DescribeStreamConsumerResponse => JavaDescribeStreamConsumerResponse
}

object DescribeStreamConsumerResponseOps {

  import ConsumerDescriptionOps._

  implicit class JavaDescribeStreamConsumerResponseOps(val self: JavaDescribeStreamConsumerResponse) extends AnyVal {
    def toScala: ScalaDescribeStreamConsumerResponse = {
      ScalaDescribeStreamConsumerResponse().withConsumerDescription(Some(self.consumerDescription().toScala))
    }
  }

}
