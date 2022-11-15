package me.mehmetcc

import cats.effect.{IO, IOApp}

object Main extends IOApp.Simple {
  override def run: IO[Unit] = Program.run[IO]
}
