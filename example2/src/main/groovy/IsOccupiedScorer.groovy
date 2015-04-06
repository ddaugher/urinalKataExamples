class IsOccupiedScorer implements I_Scorer {
  @Override
  def void score(List<ScoredUrinal> urinals) {
    urinals.findAll {it.status == UrinalStatus.OCCUPIED}.each {it.score = 0}
  }
}
