import spock.lang.Specification

public class IsOccupiedScorerSpec extends Specification {

  def "scorer should set score on all occupied urinals to 0"() {
    given: "instantiated ScoredUrinal"
    def occupiedUrinal = new ScoredUrinal(new Urinal())
    occupiedUrinal.status = UrinalStatus.OCCUPIED
    occupiedUrinal.score = 10

    def availableUrinal = new ScoredUrinal(new Urinal())
    availableUrinal.status = UrinalStatus.AVAILABLE
    availableUrinal.score = 10

    when: "when urinals are scored"
    IsOccupiedScorer scorer = new IsOccupiedScorer()
    scorer.score([occupiedUrinal, availableUrinal])

    then: "occupied ScoredUrinals should have a score of 0"
    occupiedUrinal.score == 0
    availableUrinal.score == 10
  }

}
