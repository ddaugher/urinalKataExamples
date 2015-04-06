import spock.lang.Specification

public class IsOccupiedScorerSpec extends Specification {

  def "scorer should set score on all occupied urinals to 0"() {
    given: "instantiated ScoredUrinal"
    def scoredUrinal = new ScoredUrinal(new Urinal())
    scoredUrinal.status = UrinalStatus.OCCUPIED
    scoredUrinal.score = 10

    when: "when urinals are scored"
    IsOccupiedScorer scorer = new IsOccupiedScorer()
    scorer.score([scoredUrinal])

    then: "occupied ScoredUrinals should have a score of 0"
    scoredUrinal.score == 0
  }
}
