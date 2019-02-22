package com.github.j5ik2o.reactive.kinesis.model

final case class RegisterStreamConsumerResponse(override val statusCode: Option[Int] = None,
                                                override val httpHeaders: Option[Map[String, Seq[String]]] = None,
                                                consumer: Option[Consumer] = None)
    extends AbstractResponse(statusCode, httpHeaders) {

  override type ThisType = RegisterStreamConsumerResponse
  override def withStatusCode(value: Option[Int]): RegisterStreamConsumerResponse = copy(statusCode = value)
  override def withHttpHeaders(value: Option[Map[String, Seq[String]]]): RegisterStreamConsumerResponse =
    copy(httpHeaders = value)
  def withConsumer(value: Option[Consumer]): RegisterStreamConsumerResponse = copy(consumer = value)

}
