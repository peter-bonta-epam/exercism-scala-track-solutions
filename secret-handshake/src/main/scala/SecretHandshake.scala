object SecretHandshake {
  def commands(number: Int): List[String] = {
    val reverse = number < 16
    var indexSum = number & 15 // 15 means all possible moves
    if (number <= 0) {
      List()
    } else if (reverse) {
      getMoves(indexSum).reverse
    } else {
      getMoves(indexSum)
    }
  }

  private def getMoves(n: Int): List[String] = {
    val handshakeMoves = List("jump", "close your eyes", "double blink", "wink")
    val values = List(8, 4, 2, 1)
    val combined = handshakeMoves.zip(values)
    combined.filter(move => (n & move._2) > 0).map(_._1)
  }
}