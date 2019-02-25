package com.github.j5ik2o.reactive.kinesis.model

final case class DeleteStreamResponse(override val statusCode: Option[Int] = None,
                                      override val httpHeaders: Option[Map[String, Seq[String]]] = None)
    extends AbstractResponse(statusCode, httpHeaders) {
  override type ThisType = DeleteStreamResponse
  override def withStatusCode(value: Option[Int]): DeleteStreamResponse = copy(statusCode = value)
  override def withHttpHeaders(value: Option[Map[String, Seq[String]]]): DeleteStreamResponse =
    copy(httpHeaders = value)
}
