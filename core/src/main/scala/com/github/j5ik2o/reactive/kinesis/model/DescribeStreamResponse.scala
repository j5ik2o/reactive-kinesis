package com.github.j5ik2o.reactive.kinesis.model

final case class DescribeStreamResponse(override val statusCode: Option[Int] = None,
                                        override val httpHeaders: Option[Map[String, Seq[String]]] = None,
                                        streamDescription: Option[StreamDescription] = None)
    extends AbstractResponse(statusCode, httpHeaders) {

  override type ThisType = DescribeStreamResponse
  override def withStatusCode(value: Option[Int]): DescribeStreamResponse = copy(statusCode = value)
  override def withHttpHeaders(value: Option[Map[String, Seq[String]]]): DescribeStreamResponse =
    copy(httpHeaders = value)
  def withStreamDescription(value: Option[StreamDescription]): DescribeStreamResponse = copy(streamDescription = value)

}
