package com.github.j5ik2o.reactive.kinesis
import java.nio.ByteBuffer

import com.github.j5ik2o.reactive.kinesis.model._
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient

import scala.concurrent.{ ExecutionContext, Future }

class KinesisAsyncClientV2Impl(override val underlying: KinesisAsyncClient)(implicit ec: ExecutionContext)
    extends KinesisAsyncClientV2 {

  import KinesisAsyncClientV2._
  import com.github.j5ik2o.reactive.kinesis.model.v2.AddTagsToStreamRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.AddTagsToStreamResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.CreateStreamRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.CreateStreamResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DecreaseStreamRetentionPeriodRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DecreaseStreamRetentionPeriodResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DeleteStreamRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DeleteStreamResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DeregisterStreamConsumerRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DeregisterStreamConsumerResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DescribeLimitsRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DescribeLimitsResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DescribeStreamConsumerRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DescribeStreamConsumerResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DescribeStreamRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DescribeStreamResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DescribeStreamSummaryRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DescribeStreamSummaryResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DisableEnhancedMonitoringRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.DisableEnhancedMonitoringResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.EnableEnhancedMonitoringRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.EnableEnhancedMonitoringResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.GetRecordsRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.GetRecordsResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.GetShardIteratorRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.GetShardIteratorResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.IncreaseStreamRetentionPeriodRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.IncreaseStreamRetentionPeriodResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.ListShardsRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.ListShardsResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.ListStreamConsumersRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.ListStreamConsumersResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.ListStreamsRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.ListStreamsResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.ListTagsForStreamRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.ListTagsForStreamResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.MergeShardsRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.MergeShardsResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.PutRecordRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.PutRecordResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.PutRecordsRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.PutRecordsResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.RegisterStreamConsumerRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.RegisterStreamConsumerResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.RemoveTagsFromStreamRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.RemoveTagsFromStreamResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.SplitShardRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.SplitShardResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.StartStreamEncryptionRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.StartStreamEncryptionResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.StopStreamEncryptionRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.StopStreamEncryptionResponseOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.UpdateShardCountRequestOps._
  import com.github.j5ik2o.reactive.kinesis.model.v2.UpdateShardCountResponseOps._

  override def addTagsToStream(request: AddTagsToStreamRequest): Future[AddTagsToStreamResponse] =
    underlying.addTagsToStream(request.toJava).toFuture.map(_.toScala)

  override def createStream(streamName: String, shardCount: Int): Future[CreateStreamResponse] =
    createStream(CreateStreamRequest().withStreamName(Some(streamName)).withShardCount(Some(shardCount)))

  override def createStream(request: CreateStreamRequest): Future[CreateStreamResponse] =
    underlying.createStream(request.toJava).toFuture.map(_.toScala)

  override def decreaseStreamRetentionPeriod(
      request: DecreaseStreamRetentionPeriodRequest
  ): Future[DecreaseStreamRetentionPeriodResponse] =
    underlying.decreaseStreamRetentionPeriod(request.toJava).toFuture.map(_.toScala)

  override def deleteStream(request: DeleteStreamRequest): Future[DeleteStreamResponse] =
    underlying.deleteStream(request.toJava).toFuture.map(_.toScala)

  override def deleteStream(streamName: String): Future[DeleteStreamResponse] =
    deleteStream(DeleteStreamRequest().withStreamName(Some(streamName)))

  override def deregisterStreamConsumer(
      request: DeregisterStreamConsumerRequest
  ): Future[DeregisterStreamConsumerResponse] =
    underlying.deregisterStreamConsumer(request.toJava).toFuture.map(_.toScala)

  override def describeLimits(request: DescribeLimitsRequest): Future[DescribeLimitsResponse] =
    underlying.describeLimits(request.toJava).toFuture.map(_.toScala)

  override def describeStream(request: DescribeStreamRequest): Future[DescribeStreamResponse] =
    underlying.describeStream(request.toJava).toFuture.map(_.toScala)

  override def describeStream(streamName: String): Future[DescribeStreamResponse] =
    describeStream(
      DescribeStreamRequest()
        .withStreamName(Some(streamName))
    )

  override def describeStream(streamName: String, exclusiveStartShardId: String): Future[DescribeStreamResponse] =
    describeStream(
      DescribeStreamRequest()
        .withStreamName(Some(streamName))
        .withExclusiveStartShardId(Some(exclusiveStartShardId))
    )

  override def describeStream(streamName: String,
                              limit: Int,
                              exclusiveStartShardId: String): Future[DescribeStreamResponse] =
    describeStream(
      DescribeStreamRequest()
        .withStreamName(Some(streamName))
        .withLimit(Some(limit))
        .withExclusiveStartShardId(Some(exclusiveStartShardId))
    )

  override def describeStreamConsumer(request: DescribeStreamConsumerRequest): Future[DescribeStreamConsumerResponse] =
    underlying.describeStreamConsumer(request.toJava).toFuture.map(_.toScala)

  override def describeStreamSummary(request: DescribeStreamSummaryRequest): Future[DescribeStreamSummaryResponse] =
    underlying.describeStreamSummary(request.toJava).toFuture.map(_.toScala)

  override def disableEnhancedMonitoring(
      request: DisableEnhancedMonitoringRequest
  ): Future[DisableEnhancedMonitoringResponse] =
    underlying.disableEnhancedMonitoring(request.toJava).toFuture.map(_.toScala)

  override def enableEnhancedMonitoring(
      request: EnableEnhancedMonitoringRequest
  ): Future[EnableEnhancedMonitoringResponse] =
    underlying.enableEnhancedMonitoring(request.toJava).toFuture.map(_.toScala)

  override def getRecords(request: GetRecordsRequest): Future[GetRecordsResponse] =
    underlying.getRecords(request.toJava).toFuture.map(_.toScala)

  override def getShardIterator(request: GetShardIteratorRequest): Future[GetShardIteratorResponse] =
    underlying.getShardIterator(request.toJava).toFuture.map(_.toScala)

  override def getShardIterator(streamName: String,
                                shardId: String,
                                shardIteratorType: ShardIteratorType): Future[GetShardIteratorResponse] =
    getShardIterator(
      GetShardIteratorRequest()
        .withStreamName(Some(streamName)).withShardId(Some(shardId)).withShardIteratorType(Some(shardIteratorType))
    )

  override def increaseStreamRetentionPeriod(
      request: IncreaseStreamRetentionPeriodRequest
  ): Future[IncreaseStreamRetentionPeriodResponse] =
    underlying.increaseStreamRetentionPeriod(request.toJava).toFuture.map(_.toScala)

  override def listShards(request: ListShardsRequest): Future[ListShardsResponse] =
    underlying.listShards(request.toJava).toFuture.map(_.toScala)

  override def listStreamConsumers(request: ListStreamConsumersRequest): Future[ListStreamConsumersResponse] =
    underlying.listStreamConsumers(request.toJava).toFuture.map(_.toScala)

  override def listStreams(request: ListStreamsRequest): Future[ListStreamsResponse] =
    underlying.listStreams(request.toJava).toFuture.map(_.toScala)

  override def listStreams(): Future[ListStreamsResponse] =
    listStreams(ListStreamsRequest())

  override def listStreams(exclusiveStartStreamName: String): Future[ListStreamsResponse] =
    listStreams(ListStreamsRequest().withExclusiveStartStreamName(Some(exclusiveStartStreamName)))

  override def listStreams(limit: Int, exclusiveStartStreamName: String): Future[ListStreamsResponse] =
    listStreams(
      ListStreamsRequest().withLimit(Some(limit)).withExclusiveStartStreamName(Some(exclusiveStartStreamName))
    )

  override def listTagsForStream(request: ListTagsForStreamRequest): Future[ListTagsForStreamResponse] =
    underlying.listTagsForStream(request.toJava).toFuture.map(_.toScala)

  override def mergeShards(request: MergeShardsRequest): Future[MergeShardsResponse] =
    underlying.mergeShards(request.toJava).toFuture.map(_.toScala)

  override def mergeShards(streamName: String,
                           shardToMerge: String,
                           adjacentShardToMerge: String): Future[MergeShardsResponse] =
    mergeShards(
      MergeShardsRequest()
        .withStreamName(Some(streamName)).withShardToMerge(Some(shardToMerge)).withAdjacentShardToMerge(
          Some(adjacentShardToMerge)
        )
    )

  override def putRecord(request: PutRecordRequest): Future[PutRecordResponse] =
    underlying.putRecord(request.toJava).toFuture.map(_.toScala)

  override def putRecord(streamName: String, data: ByteBuffer, partitionKey: String): Future[PutRecordResponse] =
    putRecord(
      PutRecordRequest().withStreamName(Some(streamName)).withData(Some(data)).withPartitionKey(Some(partitionKey))
    )

  override def putRecord(streamName: String,
                         data: ByteBuffer,
                         partitionKey: String,
                         sequenceNumberForOrdering: String): Future[PutRecordResponse] =
    putRecord(
      PutRecordRequest()
        .withStreamName(Some(streamName)).withData(Some(data)).withPartitionKey(Some(partitionKey)).withSequenceNumberForOrdering(
          Some(sequenceNumberForOrdering)
        )
    )

  override def putRecords(request: PutRecordsRequest): Future[PutRecordsResponse] =
    underlying.putRecords(request.toJava).toFuture.map(_.toScala)

  override def registerStreamConsumer(request: RegisterStreamConsumerRequest): Future[RegisterStreamConsumerResponse] =
    underlying.registerStreamConsumer(request.toJava).toFuture.map(_.toScala)

  override def removeTagsFromStream(request: RemoveTagsFromStreamRequest): Future[RemoveTagsFromStreamResponse] =
    underlying.removeTagsFromStream(request.toJava).toFuture.map(_.toScala)

  override def splitShard(request: SplitShardRequest): Future[SplitShardResponse] =
    underlying.splitShard(request.toJava).toFuture.map(_.toScala)

  override def splitShard(streamName: String,
                          shardToSplit: String,
                          newStartingHashKey: String): Future[SplitShardResponse] =
    splitShard(
      SplitShardRequest()
        .withStreamName(Some(streamName)).withShardToSplit(Some(shardToSplit)).withNewStartingHashKey(
          Some(newStartingHashKey)
        )
    )

  override def startStreamEncryption(request: StartStreamEncryptionRequest): Future[StartStreamEncryptionResponse] =
    underlying.startStreamEncryption(request.toJava).toFuture.map(_.toScala)

  override def stopStreamEncryption(request: StopStreamEncryptionRequest): Future[StopStreamEncryptionResponse] =
    underlying.stopStreamEncryption(request.toJava).toFuture.map(_.toScala)

  override def updateShardCount(
      request: UpdateShardCountRequest
  ): Future[UpdateShardCountResponse] = underlying.updateShardCount(request.toJava).toFuture.map(_.toScala)

}
