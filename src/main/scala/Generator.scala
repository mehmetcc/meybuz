package me.mehmetcc

import cats.effect.Sync
import cats.syntax.all._
import fs2.Stream
import org.typelevel.log4cats.slf4j.Slf4jLogger

import scala.language.postfixOps

class Generator[F[_]](counter: Counter[F])(implicit F: Sync[F]) {
  def generate: Stream[F, String] = Stream.eval(effect).foreverM

  private def effect: F[String] = for {
    logger <- Slf4jLogger.create[F]
    value  <- counter.incrementAndGet
    result  = meybuz(value)
    _      <- logger.info(result)
  } yield result

  private def meybuz(value: Int): String = (value % 3, value % 5) match {
    case (0, 0) => "meybuz"
    case (0, _) => "mey"
    case (_, 0) => "buz"
    case _      => value toString
  }
}
