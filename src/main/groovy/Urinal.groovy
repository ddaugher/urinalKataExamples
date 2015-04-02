public class Urinal {
  UrinalStatus status = UrinalStatus.AVAILABLE
  Urinal leftNeighbor
  Urinal rightNeighbor
  int position

  boolean isAvailable() {
    if (status == UrinalStatus.OCCUPIED) return false

    if (null == leftNeighbor && isUrinalAvailable()) return true

    if (null == rightNeighbor && isUrinalAvailable()) return true

    if (hasLeftNeighbor() && leftNeighbor.status != UrinalStatus.AVAILABLE) return false

    if (hasRightNeighbor() && rightNeighbor.status != UrinalStatus.AVAILABLE) return false
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

  boolean isUrinalAvailable() {
    status == UrinalStatus.AVAILABLE
  }
}
