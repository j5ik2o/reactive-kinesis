package com.github.j5ik2o.reactive.kinesis.model

final case class DescribeLimitsResponse(override val statusCode: Option[Int] = None,
                                        override val httpHeaders: Option[Map[String, Seq[String]]] = None,
                                        shardLimit: Option[Int] = None,
                                        openShardCount: Option[Int] = None)
    extends AbstractResponse() {
  override type ThisType = DescribeLimitsResponse
  override def withStatusCode(value: Option[Int]): DescribeLimitsResponse = copy(statusCode = value)
  override def withHttpHeaders(value: Option[Map[String, Seq[String]]]): DescribeLimitsResponse =
    copy(httpHeaders = value)
  def withShardLimit(value: Option[Int]): DescribeLimitsResponse     = copy(shardLimit = value)
  def withOpenShardCount(value: Option[Int]): DescribeLimitsResponse = copy(openShardCount = value)
}
