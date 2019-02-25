package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{ SplitShardResponse => ScalaSplitShardResponse }
import software.amazon.awssdk.services.kinesis.model.{ SplitShardResponse => JavaSplitShardResponse }

import scala.collection.JavaConverters._

object SplitShardResponseOps {

  implicit class JavaSplitShardResponseOps(val self: JavaSplitShardResponse) extends AnyVal {

    def toScala: ScalaSplitShardResponse = {
      ScalaSplitShardResponse()
        .withStatusCode(Option(self.sdkHttpResponse().statusCode()))
        .withHttpHeaders(Option(self.sdkHttpResponse().headers().asScala.mapValues(_.asScala).toMap))
    }

  }

}
