import spock.lang.Specification

public class UrinalSpec extends Specification {

  def "urinal should default to Available status when created"() {
    given: "instantiated Urinal"
    def urinal = new Urinal()

    expect: "expect Available status"
    urinal.status == UrinalStatus.AVAILABLE
  }

  def "urinal should default to Available when created"() {
    given: "instantiated Urinal"
    def urinal = new Urinal()

    expect: "expect Urinal to be available after creation"
    urinal.isAvailable() == true
  }

  def "urinal should be unavailable when status is occupied"() {
    given: "instantiated Urinal"
    def urinal = new Urinal()

    when: "status is occupied"
    urinal.status = UrinalStatus.OCCUPIED

    then: "expect Urinal to be unavailable when occupied"
    urinal.isAvailable() == false
  }
}
