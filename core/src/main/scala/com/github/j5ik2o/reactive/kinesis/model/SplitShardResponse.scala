package com.github.j5ik2o.reactive.kinesis.model

final case class SplitShardResponse(override val statusCode: Option[Int] = None,
                                    override val httpHeaders: Option[Map[String, Seq[String]]] = None)
    extends AbstractResponse(statusCode, httpHeaders) {

  override type ThisType = SplitShardResponse
  override def withStatusCode(value: Option[Int]): SplitShardResponse = copy(statusCode = value)
  override def withHttpHeaders(value: Option[Map[String, Seq[String]]]): SplitShardResponse =
    copy(httpHeaders = value)
}
