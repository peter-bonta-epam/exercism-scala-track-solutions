object House {
  private val lineBeginning = "This is "
  private val cast: Map[Int, (String, String)] = Map(
    1 -> ("house", "Jack built."),
    2 -> ("malt", "lay in "),
    3 -> ("rat", "ate"),
    4 -> ("cat", "killed"),
    5 -> ("dog", "worried"),
    6 -> ("cow with the crumpled horn", "tossed"),
    7 -> ("maiden all forlorn", "milked"),
    8 -> ("man all tattered and torn", "kissed"),
    9 -> ("priest all shaven and shorn", "married"),
    10 -> ("rooster that crowed in the morn", "woke"),
    11 -> ("farmer sowing his corn", "kept"),
    12 -> ("horse and the hound and the horn", "belonged to")
  )

  def recite(start: Int, end: Int): String = {
    (for (j <- start to end) yield getVerse(j)).mkString("\n") + "\n\n"
  }

  private def getLine(who: String, didWhat: String): String = s"the $who that $didWhat"

  private def getVerse(end: Int): String = {
    val lines = (for (i <- 2 to end) yield getLine(cast(i)._1, cast(i)._2)).reverse
    lineBeginning + lines.mkString(" ") + getLine(cast(1)._1, cast(1)._2)
  }
}