class ScoredUrinal extends Urinal {

  int score

  def ScoredUrinal(Urinal urinal) {
    id = urinal.id
    status = urinal.status
    score = 0
  }

  @Override
  def String toString() {
    "id: ${id}, status: ${status}, score: ${score}"
  }
}
