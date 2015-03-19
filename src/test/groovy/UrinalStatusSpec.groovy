import spock.lang.Specification

public class UrinalStatusSpec extends Specification {

  def "urinal should have valid proper values exist"() {
    expect: "expect proper enumeration values"
    UrinalStatus.AVAILABLE == "AVAILABLE" as UrinalStatus
    UrinalStatus.OCCUPIED == "OCCUPIED" as UrinalStatus
  }

}
