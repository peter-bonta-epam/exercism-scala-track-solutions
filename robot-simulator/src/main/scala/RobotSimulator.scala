object RobotSimulator {
  object Bearing extends Enumeration {
    val North: Bearing.Value = Value
    val South: Bearing.Value = Value
    val East: Bearing.Value = Value
    val West: Bearing.Value = Value

    def leftValue(bearing: Bearing.Value): Bearing.Value = bearing match {
      case North => West
      case South => East
      case East => North
      case West => South
    }

    def rightValue(bearing: Bearing.Value): Bearing.Value = bearing match {
      case North => East
      case South => West
      case East => South
      case West => North
    }
  }
}