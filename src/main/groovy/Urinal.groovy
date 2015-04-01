public class Urinal {
  UrinalStatus status = UrinalStatus.AVAILABLE
  Urinal leftNeighbor
  Urinal rightNeighbor
  int position

  boolean isAvailable() {
    if (status == UrinalStatus.OCCUPIED) return false

    if (null != leftNeighbor && !leftNeighbor.status == UrinalStatus.AVAILABLE) return false

    if (null != rightNeighbor && !rightNeighbor.status == UrinalStatus.AVAILABLE) return false
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
