object AtbashCipher {
  val alphabet = ('a' to 'z').toIndexedSeq
  val atbash = alphabet.reverse
  
  def encode(text: String): String = {
    val strippedText = text.filter(_.isLetterOrDigit).toLowerCase()
    strippedText.map(char => getChar(char, true)).grouped(5).mkString(" ")
  }

  def decode(code: String): String = {
    val stippedCode = code.filter(_.isLetterOrDigit)
    stippedCode.map(char => getChar(char, false))
  }

  def getChar(character: Char, encode: Boolean): Char = character match {
    case normal if normal.isLetter && encode => atbash(alphabet.indexOf(normal))
    case encoded if encoded.isLetter && !encode => alphabet(atbash.indexOf(encoded))
    case number => number
  }
}