import spock.lang.Specification

public class Bathroom_4Urinals_Spec extends Specification {

  def "should return urinal position 1 when five urinals exists and 2, 3 and 5 are occupied"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(5)
    bathroom.urinals.get(1).status = UrinalStatus.OCCUPIED
    bathroom.urinals.get(2).status = UrinalStatus.OCCUPIED
    bathroom.urinals.get(4).status = UrinalStatus.OCCUPIED

    expect: "position 1 should be returned"
    bathroom.numberOfUrinals == 5
    bathroom.nextAvailable() == bathroom.urinals.get(0)
    1 == bathroom.urinals.get(0).position
  }
}
