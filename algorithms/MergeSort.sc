// Merge Sort implementation


def mergeSort[T: Ordering](items: IndexedSeq[T]): IndexedSeq[T] = {
  // Sort first halves such that they are halved and sort until left with one item.
  if (items.length <= 1) items
  else {
    val (left, right) = items.splitAt(items.length / 2)
    val (sortedLeft, sortedRight) = (mergeSort(left), mergeSort(right))
    // merge + sort sortedLeft and sortedRight
    var (leftIdx, rightIdx) = (0, 0) // location accumulator
    val output = IndexedSeq.newBuilder[T]
    while (leftIdx < sortedLeft.length || rightIdx < sortedRight.length) {
      val takeLeft = (leftIdx < sortedLeft.length, rightIdx < sortedRight.length) match {
        case (true, false) => true
        case (false, true) => false
        case (true, true)  => Ordering[T].lt(sortedLeft(leftIdx), sortedRight(rightIdx))
      }
      if (takeLeft) {
        output  += sortedLeft(leftIdx)
        leftIdx += 1
      } else {
        output   += sortedRight(rightIdx)
        rightIdx += 1
      }
  }
  output.result()
 }
}
