package com.github.j5ik2o.reactive.kinesis.model

final case class DeregisterStreamConsumerResponse(override val statusCode: Option[Int] = None,
                                                  override val httpHeaders: Option[Map[String, Seq[String]]] = None)
    extends AbstractResponse(statusCode, httpHeaders) {
  override type ThisType = DeregisterStreamConsumerResponse
  override def withStatusCode(value: Option[Int]): DeregisterStreamConsumerResponse = copy(statusCode = value)
  override def withHttpHeaders(value: Option[Map[String, Seq[String]]]): DeregisterStreamConsumerResponse =
    copy(httpHeaders = value)
}
