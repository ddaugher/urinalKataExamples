import spock.lang.Specification

public class BathroomSpec extends Specification {

  def "Bathroom should default to zero urinals"() {
    given: "instantiated Urinal"
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

}
