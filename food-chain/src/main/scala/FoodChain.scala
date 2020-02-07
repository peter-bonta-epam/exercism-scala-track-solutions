object FoodChain {
  private val firstLine = "I know an old lady who swallowed a"
  private val end = "I don't know why she swallowed the fly. Perhaps she'll die."
  private val alternateEnd = "She's dead, of course!"
  private val animals = List(
    ("horse", ""),
    ("cow", "\nI don't know how she swallowed a cow!"),
    ("goat", "\nJust opened her throat and swallowed a goat!"),
    ("dog", "\nWhat a hog, to swallow a dog!"),
    ("cat", "\nImagine that, to swallow a cat!"),
    ("bird", "\nHow absurd to swallow a bird!"),
    ("spider that wriggled and jiggled and tickled inside her", "\nIt wriggled and jiggled and tickled inside her."),
    ("fly", "")
  )

  private def getVerse(n: Int): String = {
    val items = animals.drop(animals.size - n)
    val beginning = s"$firstLine ${items.head._1.split(" ").head}.${items.head._2}\n"

    if (n == animals.size) s"$beginning$alternateEnd"
    else items.zip(items.drop(1))
      .foldLeft(beginning)(
        (v, i) => s"${v}She swallowed the ${i._1._1.split(" ").head} to catch the ${i._2._1}.\n"
      ) + end
  }

  def recite(from: Int, to: Int): String =
    (from to to).map(getVerse).mkString("\n\n") + "\n\n"
}