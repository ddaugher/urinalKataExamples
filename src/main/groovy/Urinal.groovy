public class Urinal {
  UrinalStatus status = UrinalStatus.AVAILABLE

  boolean isAvailable() {
    if (status == UrinalStatus.OCCUPIED) return false
    true
  }
}
