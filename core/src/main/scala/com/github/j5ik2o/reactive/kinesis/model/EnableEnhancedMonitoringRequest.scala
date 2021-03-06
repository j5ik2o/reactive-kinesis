package com.github.j5ik2o.reactive.kinesis.model

final case class EnableEnhancedMonitoringRequest(streamName: Option[String] = None,
                                                 shardLevelMetrics: Option[Seq[MetricsName]] = None) {

  def withStreamName(value: Option[String]): EnableEnhancedMonitoringRequest = copy(streamName = value)
  def withShardLevelMetrics(value: Option[Seq[MetricsName]]): EnableEnhancedMonitoringRequest =
    copy(shardLevelMetrics = value)

}
