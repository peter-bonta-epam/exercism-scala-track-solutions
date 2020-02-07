object Raindrops {
  def convert(n: Int): String = {
    val drops: Map[Int, String] = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")
     val factors = drops.filter(drop => n % drop._1 == 0)
        .map(kv => kv._2)
     if (factors.isEmpty) n.toString else factors.mkString
  }
}

