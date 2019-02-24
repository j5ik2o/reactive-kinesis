package com.github.j5ik2o.reactive.kinesis.model.v2

import com.github.j5ik2o.reactive.kinesis.model.{ ListStreamsResponse => ScalaListStreamsResponse }
import software.amazon.awssdk.services.kinesis.model.{ ListStreamsResponse => JavaListStreamsResponse }

import scala.collection.JavaConverters._

object ListStreamsResponseOps {

  implicit class JavaListStreamsResponseOps(val self: JavaListStreamsResponse) extends AnyVal {

    def toScala: ScalaListStreamsResponse = {
      ScalaListStreamsResponse()
        .withStatusCode(Option(self.sdkHttpResponse().statusCode()))
        .withHttpHeaders(Option(self.sdkHttpResponse().headers().asScala.mapValues(_.asScala).toMap))
        .withStreamNames(Option(self.streamNames()).map(_.asScala))
        .withHasMoreStreams(Option(self.hasMoreStreams))
    }

  }

}
