import spock.lang.Specification

public class Bathroom_4Urinals_Spec extends Specification {

  def "should return urinal position 4 when four urinals exists and all are available"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(4)

    expect: "position 1 should be returned"
    bathroom.numberOfUrinals == 4
    bathroom.nextAvailable() == bathroom.urinals.get(3)
    4 == bathroom.urinals.get(3).position
  }

  def "should return urinal position 1 when four urinals exists and 2, 3 and 4 are occupied"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(4)
    bathroom.urinals.get(1).status = UrinalStatus.OCCUPIED
    bathroom.urinals.get(2).status = UrinalStatus.OCCUPIED
    bathroom.urinals.get(3).status = UrinalStatus.OCCUPIED

    expect: "position 1 should be returned"
    bathroom.numberOfUrinals == 4
    bathroom.nextAvailable() == bathroom.urinals.get(0)
    1 == bathroom.urinals.get(0).position
  }

  def "should return urinal position 1 when four urinals exists and 2, and 4 are occupied"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(4)
    bathroom.urinals.get(1).status = UrinalStatus.OCCUPIED
    bathroom.urinals.get(3).status = UrinalStatus.OCCUPIED

    expect: "position 1 should be returned"
    bathroom.numberOfUrinals == 4
    bathroom.nextAvailable() == bathroom.urinals.get(0)
    1 == bathroom.urinals.get(0).position
  }
}
