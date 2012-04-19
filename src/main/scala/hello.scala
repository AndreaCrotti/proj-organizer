import sys.process._

object HelloScala {
  def main(args: Array[String]) {
    println("Hello, Scala!")
    println("ls -l".!)
    val contents = Process("ls -l").lines
    contents foreach println
  }
}


// make it whitespace-safe
// def contentsOf(dir: String): String = Seq("ls", dir).!!

// more complex example
// import scala.sys.process._
// "find src -name *.scala -exec grep null {} ;"  #|  "xargs test -z"  #&&  "echo null-free"  #||  "echo null detected"  !

// Note that every String is implicitly converted into a ProcessBuilder through the implicits imported from process. These ProcessBuilder are then combined in three different ways.

//     #| pipes the output of the first command into the input of the second command. It mirrors a shell pipe (|).
//     #&& conditionally executes the second command if the previous one finished with exit value 0. It mirrors shell's &&.
//     #|| conditionally executes the third command if the exit value of the previous command is different than zero. It mirrors shell's &&.

// Finally, ! at the end executes the commands, and returns the exit value. Whatever is printed will be sent to the Scala process standard output. If we wanted to caputre it, we could run that with !! instead.
