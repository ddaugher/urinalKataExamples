import spock.lang.Specification

public class Bathroom_3Urinals_Spec extends Specification {

  def "should return urinal position 3 when three urinals exists and all urinals are available"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(3)

    expect: "position 3 should be returned"
    bathroom.numberOfUrinals() == 3
    bathroom.nextAvailable() == bathroom.urinals.get(2)
    3 == bathroom.urinals.get(2).position
  }

  def "should return urinal position 1 when three urinals exists and position 3 is occupied"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(3)
    bathroom.urinals.get(2).status = UrinalStatus.OCCUPIED

    expect: "position 1 should be returned"
    bathroom.numberOfUrinals() == 3
    bathroom.nextAvailable() == bathroom.urinals.get(0)
    1 == bathroom.urinals.get(0).position
  }

  def "should return urinal position 3 when three urinals exists and position 2 is occupied"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(3)
    bathroom.urinals.get(1).status = UrinalStatus.OCCUPIED

    expect: "position 3 should be returned"
    bathroom.numberOfUrinals() == 3
    bathroom.nextAvailable() == bathroom.urinals.get(2)
    3 == bathroom.urinals.get(2).position
  }

  def "should return urinal position 3 when three urinals exists and position 1 is occupied"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(3)
    bathroom.urinals.get(0).status = UrinalStatus.OCCUPIED

    expect: "position 3 should be returned"
    bathroom.numberOfUrinals() == 3
    bathroom.nextAvailable() == bathroom.urinals.get(2)
    3 == bathroom.urinals.get(2).position
  }

  def "should return urinal position 1 when three urinals exists and position 2 and 3 are occupied"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(3)
    bathroom.urinals.get(1).status = UrinalStatus.OCCUPIED
    bathroom.urinals.get(2).status = UrinalStatus.OCCUPIED

    expect: "position 1 should be returned"
    bathroom.numberOfUrinals() == 3
    bathroom.nextAvailable() == bathroom.urinals.get(0)
    1 == bathroom.urinals.get(0).position
  }

  def "should return urinal position 3 when three urinals exists and position 1 and 2 are occupied"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(3)
    bathroom.urinals.get(0).status = UrinalStatus.OCCUPIED
    bathroom.urinals.get(1).status = UrinalStatus.OCCUPIED

    expect: "position 3 should be returned"
    bathroom.numberOfUrinals() == 3
    bathroom.nextAvailable() == bathroom.urinals.get(2)
    3 == bathroom.urinals.get(2).position
  }

  def "should return urinal position 0 when three urinals exists and all positions are occupied"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(3)

    and: "position 1 is occupied"
    bathroom.urinals.get(0).status = UrinalStatus.OCCUPIED

    and: "position 2 is occupied"
    bathroom.urinals.get(1).status = UrinalStatus.OCCUPIED

    and: "position 3 is occupied"
    bathroom.urinals.get(2).status = UrinalStatus.OCCUPIED

    expect: "no available urinals"
    bathroom.numberOfUrinals() == 3
    bathroom.nextAvailable() == null
  }
}
