package com.github.j5ik2o.reactive.kinesis.model

final case class IncreaseStreamRetentionPeriodResponse(
    override val statusCode: Option[Int] = None,
    override val httpHeaders: Option[Map[String, Seq[String]]] = None
) extends AbstractResponse(statusCode, httpHeaders) {

  override type ThisType = IncreaseStreamRetentionPeriodResponse
  override def withStatusCode(value: Option[Int]): IncreaseStreamRetentionPeriodResponse = copy(statusCode = value)
  override def withHttpHeaders(
      value: Option[Map[String, Seq[String]]]
  ): IncreaseStreamRetentionPeriodResponse = copy(httpHeaders = value)

}
