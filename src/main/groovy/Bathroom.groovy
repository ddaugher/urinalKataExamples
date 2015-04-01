public class Bathroom {
  def urinals = []

  Bathroom() {}

  Bathroom(int numberOfUrinals) {

    if (1 == numberOfUrinals) {
      createSingleUrinal(1)
    } else {
      (1..numberOfUrinals).each { it ->
        if (it == 1) createLeftUrinal()
        if (it > 1 && it < numberOfUrinals) createMiddleUrinal(it)
        if (it == numberOfUrinals) createRightUrinal(it)
      }
    }

  }

  private createRightUrinal(int it) {
    Urinal u = urinals.get(it - 1)
    u.position = it
    u.leftNeighbor = urinals.get(it - 2)
    u.rightNeighbor = null
  }

  private createMiddleUrinal(int it) {
    Urinal u = urinals.get(it - 1)
    u.position = it
    u.leftNeighbor = urinals.get(it - 2)
    u.rightNeighbor = new Urinal()
    urinals.add(u.rightNeighbor)
  }

  private createLeftUrinal() {
    def u = new Urinal()
    u.position = 1
    u.leftNeighbor = null
    u.rightNeighbor = new Urinal()
    urinals.add(u)
    urinals.add(u.rightNeighbor)
  }

  private createSingleUrinal(int position) {
    def u = new Urinal()
    u.position = position
    u.leftNeighbor = null
    u.rightNeighbor = null
    urinals.add(u)
  }

  int getNumberOfUrinals() {
    urinals.size()
  }

  def nextAvailable() {
    if (urinals.get(0).isAvailable()) return urinals.get(0)
    urinals.get(1)
  }
}
