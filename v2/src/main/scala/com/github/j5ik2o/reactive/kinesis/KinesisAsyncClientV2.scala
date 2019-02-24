package com.github.j5ik2o.reactive.kinesis

import java.util.concurrent.CompletableFuture

import com.github.j5ik2o.reactive.kinesis.model.ListStreamConsumersRequest
import com.github.j5ik2o.reactive.kinesis.model.rs.ListStreamConsumersPublisher
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient

import scala.compat.java8.FutureConverters
import scala.concurrent.Future

object KinesisAsyncClientV2 {

  implicit class CompletableFutureOps[A](val cf: CompletableFuture[A]) extends AnyVal {
    def toFuture: Future[A] = FutureConverters.toScala(cf)
  }

}

trait KinesisAsyncClientV2 extends KinesisClient[Future] {

  val underlying: KinesisAsyncClient

  def listStreamConsumersPaginator(request: ListStreamConsumersRequest): ListStreamConsumersPublisher

}
