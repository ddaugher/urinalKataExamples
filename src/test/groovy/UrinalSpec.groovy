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

  def "urinal can have an empty left neighbor"() {
    given: "instantiated Urinal"
    def urinal = new Urinal()

    when: "status is occupied"
    urinal.leftNeighbor = null

    then: "urinal has no left neighbor"
    urinal.hasLeftNeighbor() == false
  }

  def "urinal has a left neighbor"() {
    given: "instantiated Urinal"
    def urinal = new Urinal()

    when: "status is occupied"
    urinal.leftNeighbor = new Urinal()

    then: "urinal has left neighbor"
    urinal.hasLeftNeighbor() == true
  }

  def "urinal can have an empty right neighbor"() {
    given: "instantiated Urinal"
    def urinal = new Urinal()

    when: "status is occupied"
    urinal.rightNeighbor = null

    then: "urinal has no right neighbor"
    urinal.hasRightNeighbor() == false
  }

  def "urinal has a right neighbor"() {
    given: "instantiated Urinal"
    def urinal = new Urinal()

    when: "status is occupied"
    urinal.rightNeighbor = new Urinal()

    then: "urinal has right neighbor"
    urinal.hasRightNeighbor() == true
  }
}
