package com.github.j5ik2o.reactive.kinesis.model

final case class DescribeStreamSummaryResponse(override val statusCode: Option[Int] = None,
                                               override val httpHeaders: Option[Map[String, Seq[String]]] = None)
    extends AbstractResponse(statusCode, httpHeaders) {

  override type ThisType = DescribeStreamSummaryResponse
  override def withStatusCode(value: Option[Int]): DescribeStreamSummaryResponse = copy(statusCode = value)
  override def withHttpHeaders(value: Option[Map[String, Seq[String]]]): DescribeStreamSummaryResponse =
    copy(httpHeaders = value)

}
