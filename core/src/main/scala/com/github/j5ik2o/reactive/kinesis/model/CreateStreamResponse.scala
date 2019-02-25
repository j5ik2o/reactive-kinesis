package com.github.j5ik2o.reactive.kinesis.model

final case class CreateStreamResponse(override val statusCode: Option[Int] = None,
                                      override val httpHeaders: Option[Map[String, Seq[String]]] = None)
    extends AbstractResponse(statusCode, httpHeaders) {
  override type ThisType = CreateStreamResponse
  override def withStatusCode(value: Option[Int]): CreateStreamResponse = copy(statusCode = value)
  override def withHttpHeaders(value: Option[Map[String, Seq[String]]]): CreateStreamResponse =
    copy(httpHeaders = value)
}
