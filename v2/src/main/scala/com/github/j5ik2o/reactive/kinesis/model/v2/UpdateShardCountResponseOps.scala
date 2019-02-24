package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{ UpdateShardCountResponse => ScalaUpdateShardCountResponse }
import software.amazon.awssdk.services.kinesis.model.{ UpdateShardCountResponse => JavaUpdateShardCountResponse }

import scala.collection.JavaConverters._

object UpdateShardCountResponseOps {

  implicit class JavaUpdateShardCountResponseOps(val self: JavaUpdateShardCountResponse) extends AnyVal {

    def toScala: ScalaUpdateShardCountResponse = {
      ScalaUpdateShardCountResponse()
        .withStatusCode(Option(self.sdkHttpResponse().statusCode()))
        .withHttpHeaders(Option(self.sdkHttpResponse().headers().asScala.mapValues(_.asScala).toMap))
        .withStreamName(Option(self.streamName()))
        .withCurrentShardCount(Option(self.currentShardCount()))
        .withTargetShardCount(Option(self.targetShardCount()))
    }

  }

}
