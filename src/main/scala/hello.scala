import sys.process._

object HelloScala {
  def main(args: Array[String]) {
    println("Hello, Scala!")
    println("ls -l".!)
    val contents = Process("ls -l").lines
    println(contents)
  }
}
