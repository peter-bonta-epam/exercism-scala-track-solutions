import RobotSimulator._

case class Robot(bearing: Bearing.Value, coordinates: (Int, Int)) {
 
  def turnRight: Robot = Robot(Bearing.rightValue(bearing), coordinates)
 
  def turnLeft: Robot = Robot(Bearing.leftValue(bearing), coordinates)
 
  def advance: Robot = {
    val newCoordinates = bearing match {
      case Bearing.North => (coordinates._1, coordinates._2 + 1)
      case Bearing.South => (coordinates._1, coordinates._2 - 1)
      case Bearing.East => (coordinates._1 + 1, coordinates._2)
      case Bearing.West => (coordinates._1 - 1, coordinates._2)
    }
    Robot(bearing, newCoordinates)
  }

  def simulate(instructions: String): Robot = {
    instructions.foldLeft(this)((robot, step) => step match {
      case 'L' => robot.turnLeft
      case 'R' => robot.turnRight
      case 'A' => robot.advance
      case _   => robot
    })
  }
}
