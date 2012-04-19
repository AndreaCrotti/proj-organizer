import scala.actors.Actor
import scala.actors.Actor._
import sys.process._

val cmds = List("ls -l", "tree", "echo 'hello world'")

object run_actors extends Application {
  cmds foreach {
    val cm = new Command(_)
    cm.start
  }
}

class Command extends actor {
  def act() {
    react {
      case Start =>
        println("Running command")
        Process(cm).lines foreach println
    }
  }
}
