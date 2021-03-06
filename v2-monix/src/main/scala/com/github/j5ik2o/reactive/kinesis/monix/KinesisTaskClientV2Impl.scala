package com.github.j5ik2o.reactive.kinesis.monix

import com.github.j5ik2o.reactive.kinesis.KinesisAsyncClientV2
import com.github.j5ik2o.reactive.kinesis.model.{ ListStreamConsumersRequest, ListStreamConsumersResponse }
import monix.reactive.Observable

private[kinesis] class KinesisTaskClientV2Impl(override val underlying: KinesisAsyncClientV2)
    extends KinesisTaskClientV2 {

  override def listStreamConsumersPaginator(
      request: ListStreamConsumersRequest
  ): Observable[ListStreamConsumersResponse] =
    Observable.fromReactivePublisher(underlying.listStreamConsumersPaginator(request))

}
