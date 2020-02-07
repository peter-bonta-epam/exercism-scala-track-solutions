case class Triangle(a: Double, b: Double, c: Double) {
  def equilateral: Boolean = isTriangle && Set(a, b, c).size == 1
  def isosceles: Boolean = isTriangle && (Set(a, b, c).size == 2 || equilateral)
  def scalene: Boolean = isTriangle && Set(a, b, c).size == 3

  private def isTriangle: Boolean = (a + b > c && a + c > b) && b + c > a
}