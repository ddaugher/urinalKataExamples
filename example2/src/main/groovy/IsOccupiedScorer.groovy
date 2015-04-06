class IsOccupiedScorer implements I_Scorer {
  @Override
  def int score(List<ScoredUrinal> urinals) {
    urinals*.score = 0
  }
}
