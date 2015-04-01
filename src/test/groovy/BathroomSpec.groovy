import spock.lang.Specification

public class BathroomSpec extends Specification {

  def "Bathroom should default to zero urinals"() {
    given: "instantiated Bathroom"
    def bathroom = new Bathroom()

    expect: "empty list of urinals"
    bathroom.numberOfUrinals == 0
  }

  def "Bathroom should create proper number of urinals"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(1)

    expect: "1 urinal in the bathroom"
    bathroom.numberOfUrinals == 1
  }

  def "Bathroom should create two urinals and proper neighbor relationships"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(2)

    expect: "2 urinal in the bathroom and linked properly"
    bathroom.numberOfUrinals == 2

    def urinals = bathroom.urinals
    urinals.get(0).leftNeighbor == null
    urinals.get(0).rightNeighbor == urinals.get(1)
    urinals.get(1).leftNeighbor == urinals.get(0)
    urinals.get(1).rightNeighbor == null
  }

  def "Bathroom should create three urinals and proper neighbor relationships"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(3)

    expect: "3 urinal in the bathroom and linked properly"
    bathroom.numberOfUrinals == 3

    def urinals = bathroom.urinals
    urinals.get(0).leftNeighbor == null
    urinals.get(0).rightNeighbor == urinals.get(1)
    urinals.get(1).leftNeighbor == urinals.get(0)
    urinals.get(1).rightNeighbor == urinals.get(2)
    urinals.get(2).leftNeighbor == urinals.get(1)
    urinals.get(2).rightNeighbor == null
  }

  def "Bathroom should create four urinals and proper neighbor relationships"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(4)

    expect: "4 urinal in the bathroom and linked properly"
    bathroom.numberOfUrinals == 4

    def urinals = bathroom.urinals
    urinals.get(0).leftNeighbor == null
    urinals.get(0).rightNeighbor == urinals.get(1)
    urinals.get(1).leftNeighbor == urinals.get(0)
    urinals.get(1).rightNeighbor == urinals.get(2)
    urinals.get(2).leftNeighbor == urinals.get(1)
    urinals.get(2).rightNeighbor == urinals.get(3)
    urinals.get(3).leftNeighbor == urinals.get(2)
    urinals.get(3).rightNeighbor == null
  }

  def "should return position 1 urinal when only one available urinal exists"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(1)

    expect: "position 1 urinal is available"
    bathroom.numberOfUrinals == 1
    bathroom.nextAvailable() == bathroom.urinals.get(0)
    1 == bathroom.urinals.get(0).position
  }

  def "should return position 1 urinal when two available urinals exist"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(2)

    expect: "position 1 urinal should be available urinal"
    bathroom.numberOfUrinals == 2
    bathroom.nextAvailable() == bathroom.urinals.get(0)
    1 == bathroom.urinals.get(0).position
  }

  def "should return position 2 urinal when two urinals exists and position 1 is occupied"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(2)

    when: "position 1 is occupied"
    bathroom.urinals.get(0).status = UrinalStatus.OCCUPIED

    then: "position 2 urinal should be available urinal"
    bathroom.numberOfUrinals == 2
    bathroom.nextAvailable() == bathroom.urinals.get(1)
    2 == bathroom.urinals.get(1).position
  }

  def "should return position 1 urinal when two urinals exists and position 2 is occupied"() {
    given: "instantiated Urinal"
    def bathroom = new Bathroom(2)

    when: "position 2 is occupied"
    bathroom.urinals.get(1).status = UrinalStatus.OCCUPIED

    then: "position 1 urinal should be available urinal"
    bathroom.numberOfUrinals == 2
    bathroom.nextAvailable() == bathroom.urinals.get(0)
    1 == bathroom.urinals.get(0).position
  }
}
