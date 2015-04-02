public class Urinal {
  UrinalStatus status = UrinalStatus.AVAILABLE
  Urinal leftNeighbor
  Urinal rightNeighbor
  int position

  boolean isAvailable() {
    if (isOccupied(this)) return false

    if (isFirstPositionUrinal()) return true

    if (isLastPositionUrinal()) return true

    if (isMiddlePositionUrinal()) return false

    true
  }

  private boolean isMiddlePositionUrinal() {
    return (hasLeftNeighbor() && isOccupied(leftNeighbor)) || (hasRightNeighbor() && isOccupied(rightNeighbor))
  }

  private boolean isLastPositionUrinal() {
    return null == rightNeighbor && isUrinalAvailable()
  }

  private boolean isFirstPositionUrinal() {
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
