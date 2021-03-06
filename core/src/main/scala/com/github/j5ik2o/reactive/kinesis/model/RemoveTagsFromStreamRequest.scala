package com.github.j5ik2o.reactive.kinesis.model

final case class RemoveTagsFromStreamRequest(streamName: Option[String] = None, tagKeys: Option[Seq[String]] = None) {

  def withStreamName(value: Option[String]): RemoveTagsFromStreamRequest   = copy(streamName = value)
  def withTagKeys(value: Option[Seq[String]]): RemoveTagsFromStreamRequest = copy(tagKeys = value)

}
