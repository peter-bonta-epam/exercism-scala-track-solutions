object ScrabbleScore {
  val scores: Map[Int, List[Char]] = Map(
      1 -> List('a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't'),
      2 -> List('d', 'g'),
      3 -> List('b', 'c', 'm', 'p'),
      4 -> List('f', 'h', 'v', 'w', 'y'),
      5 -> List('k'),
      8 -> List('j', 'x'),
      10 -> List('q', 'z')
  )
  
  def score(word: String): Int = {
    if (word.isEmpty) 0
    else word.toLowerCase.map{letter =>
      val chars = scores.values.find(_.contains(letter)).getOrElse(List())
      scores.find(_._2 == chars).getOrElse((0, List()))._1
    }.sum
  }
}