import spock.lang.Specification

public class UrinalSpec extends Specification {

  def "urinal should default to Available status when created"() {
    given: "instantiated Urinal"
    def urinal = new Urinal()

    expect: "expect Available status"
    urinal.status == UrinalStatus.AVAILABLE
  }

}
