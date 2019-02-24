package com.github.j5ik2o.reactive.kinesis.model

final case class StopStreamEncryptionResponse(override val statusCode: Option[Int] = None,
                                              override val httpHeaders: Option[Map[String, Seq[String]]] = None)
    extends AbstractResponse(statusCode, httpHeaders) {

  override type ThisType = StopStreamEncryptionResponse
  override def withStatusCode(value: Option[Int]): StopStreamEncryptionResponse = copy(statusCode = value)
  override def withHttpHeaders(value: Option[Map[String, Seq[String]]]): StopStreamEncryptionResponse =
    copy(httpHeaders = value)

}
