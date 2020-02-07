object PascalsTriangle {
  def rows(number: Int): List[List[Int]] = {
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) 1
      else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
    if (number < 1) List()
    else (0 until number).map(r => (0 to r).map(c => pascal(c, r)).toList).toList
  }
}