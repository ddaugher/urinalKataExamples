public class Bathroom {
  def urinals = []

  Bathroom() {
    new Bathroom(0)
  }

  Bathroom(int numberOfUrinals) {

    if (isEmptyBathroom(numberOfUrinals)) return

    if (isSingleStallFacility(numberOfUrinals)) {
      createSingleUrinal()
      return
    }

    createMultiUrinalFacility(numberOfUrinals)

  }

  private def createMultiUrinalFacility(int numberOfUrinals) {
    return (1..numberOfUrinals).each { it ->
      if (it == 1) createLeftUrinal()
      if (it > 1 && it < numberOfUrinals) createMiddleUrinal(it)
      if (it == numberOfUrinals) createRightUrinal(it)
    }
  }

  private boolean isSingleStallFacility(int numberOfUrinals) {
    return 1 == numberOfUrinals
  }

  private boolean isEmptyBathroom(int numberOfUrinals) {
    return 0 == numberOfUrinals
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

  private createSingleUrinal() {
    def u = new Urinal()
    u.position = 1
    u.leftNeighbor = null
    u.rightNeighbor = null
    urinals.add(u)
  }

  int getNumberOfUrinals() {
    urinals.size()
  }

  def nextAvailable() {
    if (urinals.isEmpty()) return null

    def available = urinals.findAll().findAll {it.isAvailable()}
    if (available.size() == 0) {
      def a = urinals.findAll().findAll {it.status == UrinalStatus.AVAILABLE}
      if (!a.isEmpty()) {
        return a.last()
      } else {
        return null
      }
    }

    available.last()
  }
}
