package scm

import scala.actors.Actor
import scala.actors.Actor._
import sys.process._

abstract class Proc
case object Run extends Proc
case object Abort extends Proc
case object Retry extends Proc


object run_actors extends Application {
  val cmds = List("ls -l", "tree", "echo 'hello world'")
  cmds foreach {
    val cm = new Command(_)
    // cm.start
    // cm ! Run
  }
}

class Command(cmd: String) extends Actor {
  def act() {
    react {
      case Run => 
        println("Running command")
      Process(cmd).lines foreach println
    }
  }
}
