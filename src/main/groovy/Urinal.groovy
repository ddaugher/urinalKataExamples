public class Urinal {
  UrinalStatus status = UrinalStatus.AVAILABLE
  Urinal leftNeighbor
  Urinal rightNeighbor
  int position

  boolean isAvailable() {
    if (status == UrinalStatus.OCCUPIED) return false

    if (null != leftNeighbor && !leftNeighbor.isAvailable()) return false

    if (null != rightNeighbor && !rightNeighbor.isAvailable()) return false
    true
  }

  boolean hasLeftNeighbor() {
    if (null != leftNeighbor) return true
    false
  }

  boolean hasRightNeighbor() {
    if (null != rightNeighbor) return true
    false
  }
}
