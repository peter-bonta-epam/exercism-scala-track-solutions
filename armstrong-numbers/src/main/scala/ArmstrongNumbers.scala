object ArmstrongNumbers {
  def isArmstrongNumber(number: Int): Boolean = {
    @scala.annotation.tailrec
    def carryDigits(n: Int, carry: List[Int]): List[Int] =
      if (n < 10) n :: carry else carryDigits(n / 10, n % 10 :: carry)
    val digits = carryDigits(number, List())
    val length = digits.length
    number == digits.map(Math.pow(_, length)).sum
  }
}