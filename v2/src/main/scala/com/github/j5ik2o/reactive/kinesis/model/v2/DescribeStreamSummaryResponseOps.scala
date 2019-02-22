package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{ DescribeStreamSummaryResponse => ScalaDescribeStreamSummaryResponse }
import software.amazon.awssdk.services.kinesis.model.{
  DescribeStreamSummaryResponse => JavaDescribeStreamSummaryResponse
}
import scala.collection.JavaConverters._

object DescribeStreamSummaryResponseOps {

  import StreamDescriptionSummaryOps._

  implicit class JavaDescribeStreamSummaryResponseOps(val self: JavaDescribeStreamSummaryResponse) extends AnyVal {

    def toScala: ScalaDescribeStreamSummaryResponse = {
      ScalaDescribeStreamSummaryResponse()
        .withStatusCode(Option(self.sdkHttpResponse().statusCode()))
        .withHttpHeaders(Option(self.sdkHttpResponse().headers().asScala.mapValues(_.asScala).toMap))
        .withStreamDescriptionSummary(Option(self.streamDescriptionSummary()).map(_.toScala))
    }

  }

}
