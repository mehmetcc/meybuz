package me.mehmetcc

import cats.effect.{Ref, Sync}
import cats.syntax.all._

class Counter[F[_]](ref: Ref[F, Int])(implicit F: Sync[F]) {
  def increment: F[Unit] =
    for {
      c1 <- ref.get
      c2 <- ref.modify(x => (x + 1, x))
    } yield ()

  def get: F[Int] = ref.get

  def incrementAndGet: F[Int] =
    for {
      _ <- increment
      c <- get
    } yield c
}
