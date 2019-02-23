package com.github.j5ik2o.reactive.kinesis
import java.nio.ByteBuffer

import com.github.j5ik2o.reactive.kinesis.model._

trait KinesisClient[M[_]] {

  def addTagsToStream(request: AddTagsToStreamRequest): M[AddTagsToStreamResponse]

  def createStream(request: CreateStreamRequest): M[CreateStreamResponse]

  def createStream(streamName: String, shardCount: Int): M[CreateStreamResponse]

  def decreaseStreamRetentionPeriod(
      request: DecreaseStreamRetentionPeriodRequest
  ): M[DecreaseStreamRetentionPeriodResponse]

  def deleteStream(request: DeleteStreamRequest): M[DeleteStreamResponse]

  def deleteStream(streamName: String): M[DeleteStreamResponse]

  def deregisterStreamConsumer(request: DeregisterStreamConsumerRequest): M[DeregisterStreamConsumerResponse]

  def describeLimits(request: DescribeLimitsRequest): M[DescribeLimitsResponse]

  def describeStream(request: DescribeStreamRequest): M[DescribeStreamResponse]

  def describeStream(streamName: String): M[DescribeStreamResponse]

  def describeStream(streamName: String, exclusiveStartShardId: String): M[DescribeStreamResponse]

  def describeStream(streamName: String, limit: Int, exclusiveStartShardId: String): M[DescribeStreamResponse]

  def describeStreamConsumer(request: DescribeStreamConsumerRequest): M[DescribeStreamConsumerResponse]

  def describeStreamSummary(request: DescribeStreamSummaryRequest): M[DescribeStreamSummaryResponse]

  def disableEnhancedMonitoring(request: DisableEnhancedMonitoringRequest): M[DisableEnhancedMonitoringResponse]

  def enableEnhancedMonitoring(request: EnableEnhancedMonitoringRequest): M[EnableEnhancedMonitoringResponse]

  def getRecords(request: GetRecordsRequest): M[GetRecordsResponse]

  def getShardIterator(request: GetShardIteratorRequest): M[GetShardIteratorResponse]

  def getShardIterator(streamName: String,
                       shardId: String,
                       shardIteratorType: ShardIteratorType): M[GetShardIteratorResponse]

  def increaseStreamRetentionPeriod(
      request: IncreaseStreamRetentionPeriodRequest
  ): M[IncreaseStreamRetentionPeriodResponse]

  def listShards(request: ListShardsRequest): M[ListShardsResponse]

  def listStreamConsumers(request: ListStreamConsumersRequest): M[ListStreamConsumersResponse]

  def listStreams(request: ListStreamsRequest): M[ListStreamsResponse]

  def listStreams(): M[ListStreamsResponse]

  def listStreams(exclusiveStartStreamName: String): M[ListStreamsResponse]

  def listStreams(limit: Int, exclusiveStartStreamName: String): M[ListStreamsResponse]

  def listTagsForStream(request: ListTagsForStreamRequest): M[ListTagsForStreamResponse]

  def mergeShards(request: MergeShardsRequest): M[MergeShardsResponse]

  def mergeShards(streamName: String, shardToMerge: String, adjacentShardToMerge: String): M[MergeShardsResponse]

  def putRecord(request: PutRecordRequest): M[PutRecordResponse]

  def putRecord(streamName: String, data: ByteBuffer, partitionKey: String): M[PutRecordResponse]

  def putRecord(streamName: String,
                data: ByteBuffer,
                partitionKey: String,
                sequenceNumberForOrdering: String): M[PutRecordResponse]

  def putRecords(request: PutRecordsRequest): M[PutRecordsResponse]

  def registerStreamConsumer(request: RegisterStreamConsumerRequest): M[RegisterStreamConsumerResponse]

  def removeTagsFromStream(request: RemoveTagsFromStreamRequest): M[RemoveTagsFromStreamResponse]

  def splitShard(request: SplitShardRequest): M[SplitShardResponse]

  def splitShard(streamName: String, shardToSplit: String, newStartingHashKey: String): M[SplitShardResponse]

  def startStreamEncryption(request: StartStreamEncryptionRequest): M[StartStreamEncryptionResponse]

  def stopStreamEncryption(request: StopStreamEncryptionRequest): M[StopStreamEncryptionResponse]

  def updateShardCount(updateShardCountRequest: UpdateShardCountRequest): M[UpdateShardCountResponse]

}
