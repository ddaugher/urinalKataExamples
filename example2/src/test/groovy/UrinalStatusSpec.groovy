import spock.lang.Specification

public class UrinalStatusSpec extends Specification {

  def "urinal should have valid proper values exist"() {
    expect: "expect proper enumeration values"
    UrinalStatus.AVAILABLE == "AVAILABLE" as UrinalStatus
    UrinalStatus.OCCUPIED == "OCCUPIED" as UrinalStatus
  }

  def "should return correct value"() {
    UrinalStatus.AVAILABLE.value() == "Available"
    UrinalStatus.OCCUPIED.value() == "Occupied"
  }

  def "should return correct enum when retrieving by string"() {
    UrinalStatus.AVAILABLE.toString() == "Available"
    UrinalStatus.OCCUPIED.toString() == "Occupied"
  }

  def "should return correct enumw when retrieved by value"() {
    UrinalStatus.AVAILABLE == UrinalStatus.byValue("Available")
    UrinalStatus.OCCUPIED == UrinalStatus.byValue("Occupied")
  }

}
