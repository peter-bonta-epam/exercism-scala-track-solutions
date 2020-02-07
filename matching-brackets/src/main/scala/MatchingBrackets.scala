import scala.collection.mutable.Stack

object MatchingBrackets {
  def isPaired(text: String): Boolean = {
    var stack = Stack[Char]()
    val bracketPairs = Map('{' -> '}', '[' -> ']', '(' -> ')')
    val allBrackets = bracketPairs.flatMap(kv => kv._1 :: kv._2 :: Nil).toList
    text.filter(allBrackets.contains(_)).map {
      case opening if bracketPairs.keySet.contains(opening) =>
        stack = stack.push(opening)
        ""
      case closing if bracketPairs.values.toList.contains(closing) =>
        val pair = bracketPairs.find(_._2 == closing).map(_._1)
        if (pair.isDefined && (stack.nonEmpty && pair.get == stack.pop())) "" else "X"
    }.forall(_ == "") && stack.isEmpty
  }
}