// Prefix Tree implementation

class prefixTree() {
  class Node( var hasValue: Boolean,
              val children: collection.mutable.Map[Char, Node] = collection.mutable.Map())

  val root = new Node(false)
}
