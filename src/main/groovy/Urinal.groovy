public class Urinal {
  UrinalStatus status = UrinalStatus.AVAILABLE
  Urinal leftNeighbor

  boolean isAvailable() {
    if (status == UrinalStatus.OCCUPIED) return false
    true
  }

  boolean hasLeftNeighbor() {
    if (null != leftNeighbor) return true
    false
  }
}
