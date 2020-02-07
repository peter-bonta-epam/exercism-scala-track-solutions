object PrimeFactors {
  def factors(number: Long): List[Long] = {
    @scala.annotation.tailrec
    def factorize(x: Long, a: Int = 2, list: List[Long] = Nil): List[Long] = x < a * a  match {
      case false if x % a == 0 => factorize(x / a, a, a :: list)
      case false               => factorize(x, a + 1, list)
      case true                => x :: list
    }
    if (number == 1) Nil else factorize(number).sorted
  }
}