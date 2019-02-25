package com.github.j5ik2o.reactive.kinesis.model

final case class ListShardsResponse(override val statusCode: Option[Int] = None,
                                    override val httpHeaders: Option[Map[String, Seq[String]]] = None,
                                    shards: Option[Seq[Shard]] = None,
                                    nextToken: Option[String] = None)
    extends AbstractResponse(statusCode, httpHeaders) {

  override type ThisType = ListShardsResponse
  override def withStatusCode(value: Option[Int]): ListShardsResponse                       = copy(statusCode = value)
  override def withHttpHeaders(value: Option[Map[String, Seq[String]]]): ListShardsResponse = copy(httpHeaders = value)
  def withShards(value: Option[Seq[Shard]]): ListShardsResponse                             = copy(shards = value)
  def withNextToken(value: Option[String]): ListShardsResponse                              = copy(nextToken = value)

}
