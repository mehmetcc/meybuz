package me.mehmetcc

import cats.effect.{Ref, Sync}
import cats.implicits._
import org.typelevel.log4cats.slf4j.Slf4jLogger

object Program {
  def run[F[_]: Sync]: F[Unit] = for {
    logger    <- Slf4jLogger.create[F]
    reference <- Ref[F].of(0)
    counter    = new Counter[F](reference)
    generator  = new Generator[F](counter)
    _         <- generator.generate.compile.drain
  } yield ()
}
