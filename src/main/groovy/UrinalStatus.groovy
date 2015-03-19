public enum UrinalStatus {
  AVAILABLE("Available"),
  OCCUPIED("Occupied")

  UrinalStatus(String value) {
    this.value = value
  }

  private final String value

  public String value() { return value }

  public String toString() { return value }

  static UrinalStatus byValue(String v) {
    values().find { it.value == v }
  }

  static List asList() {
    values().collect { it.value }
  }
}
