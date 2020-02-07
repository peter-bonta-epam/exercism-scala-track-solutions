object CollatzConjecture {
  def steps(number: Int): Option[Int] = {
    def calculateSteps(numbers: List[Int]): List[Int] = numbers match {
      case _ :+ 1 => numbers
      case _ :+ odd if odd % 2 != 0 => calculateSteps(numbers :+ (odd * 3 + 1))
      case _ :+ even if even % 2 == 0 => calculateSteps(numbers :+ (even / 2))
    }
    if (number < 1) None
    else {
      Some(calculateSteps(List(number)).length - 1)
    }
  }
}