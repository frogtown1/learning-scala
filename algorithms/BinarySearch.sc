// Binary Search implementation

def binarySearch[T: Ordering](sorted: IndexedSeq[T], target: T): Boolean = {
  def binarySearch0(start: Int, end: Int): Boolean = {
    if (start == end) false
    else {
      val middle     = (start + end) / 2
      val middleItem = sorted(middle)
      val comparison = Ordering[T].compare(target, middleItem)
      if (comparison == 0) true
      else if (comparison < 0) binarySearch0(start, middle)
      else binarySearch0(middle + 1, end)
    }
  }
  binarySearch0(0, sorted.length)
}
