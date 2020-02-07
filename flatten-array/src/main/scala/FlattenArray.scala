object FlattenArray {
  def flatten(xs: List[Any]): List[Any] = xs match {
    case Nil => Nil
    case (h:List[_])::tail => flatten(h.filterNot(_ == null)):::flatten(tail.filterNot(_ == null))
    case h::tail if h != null => h::flatten(tail.filterNot(_ == null))
    case n::tail if n == null => flatten(tail.filterNot(_ == null))
  }
}