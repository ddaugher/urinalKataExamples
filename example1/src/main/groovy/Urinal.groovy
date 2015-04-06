public class Urinal {
  UrinalStatus status = UrinalStatus.AVAILABLE
  Urinal leftNeighbor
  Urinal rightNeighbor
  int position

  boolean isAvailable() {
    if (isOccupied(this)) return false

    if (isFirstPositionAndAvailable()) return true

    if (isLastPositionAndAvailable()) return true

    if (isMiddlePositionAndAvailable()) return false

    true
  }

  private boolean isMiddlePositionAndAvailable() {
    return (hasLeftNeighbor() && isOccupied(leftNeighbor)) || (hasRightNeighbor() && isOccupied(rightNeighbor))
  }

  private boolean isLastPositionAndAvailable() {
    return null == rightNeighbor && isUrinalAvailable()
  }

  private boolean isFirstPositionAndAvailable() {
    return null == leftNeighbor && isUrinalAvailable()
  }

  private boolean isOccupied(urinal) {
    return urinal.status != UrinalStatus.AVAILABLE
  }

  boolean hasLeftNeighbor() {
    if (null != leftNeighbor) return true
    false
  }

  boolean hasRightNeighbor() {
    if (null != rightNeighbor) return true
    false
  }

  private boolean isUrinalAvailable() {
    status == UrinalStatus.AVAILABLE
  }
}
