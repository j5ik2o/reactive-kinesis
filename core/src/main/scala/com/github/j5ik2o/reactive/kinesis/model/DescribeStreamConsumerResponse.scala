package com.github.j5ik2o.reactive.kinesis.model

final case class DescribeStreamConsumerResponse(override val statusCode: Option[Int] = None,
                                                override val httpHeaders: Option[Map[String, Seq[String]]] = None,
                                                consumerDescription: Option[ConsumerDescription] = None)
    extends AbstractResponse(statusCode, httpHeaders) {

  override type ThisType = DescribeStreamConsumerResponse
  override def withStatusCode(value: Option[Int]): DescribeStreamConsumerResponse = copy(statusCode = value)
  override def withHttpHeaders(value: Option[Map[String, Seq[String]]]): DescribeStreamConsumerResponse =
    copy(httpHeaders = value)
  def withConsumerDescription(value: Option[ConsumerDescription]): DescribeStreamConsumerResponse =
    copy(consumerDescription = value)

}
