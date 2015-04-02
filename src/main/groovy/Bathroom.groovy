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
    return (1..numberOfUrinals).each { position ->
      if (position == 1) createFirstUrinal()
      if (position > 1 && position < numberOfUrinals) createMiddleUrinal(position)
      if (position == numberOfUrinals) createLastUrinal(position)
    }
  }

  private boolean isSingleStallFacility(int numberOfUrinals) {
    return 1 == numberOfUrinals
  }

  private boolean isEmptyBathroom(int numberOfUrinals) {
    return 0 == numberOfUrinals
  }

  private createFirstUrinal() {
    def u = new Urinal()
    u.position = 1
    u.leftNeighbor = null
    u.rightNeighbor = new Urinal()
    urinals.add(u)
    urinals.add(u.rightNeighbor)
  }

  private createMiddleUrinal(int position) {
    Urinal u = getUrinalByPosition(position)
    u.position = position
    u.leftNeighbor = getLeftNeighbor(position)
    u.rightNeighbor = new Urinal()
    urinals.add(u.rightNeighbor)
  }

  private def getLeftNeighbor(int position) {
    return getUrinalByPosition(position - 1)
  }

  private createLastUrinal(int position) {
    Urinal u = getUrinalByPosition(position)
    u.position = position
    u.leftNeighbor = getLeftNeighbor(position)
    u.rightNeighbor = null
  }

  private createSingleUrinal() {
    def u = new Urinal()
    u.position = 1
    u.leftNeighbor = null
    u.rightNeighbor = null
    urinals.add(u)
  }

  int numberOfUrinals() {
    urinals.size()
  }

  def nextAvailable() {
    if (urinals.isEmpty()) return null

    urinalExistsWithoutNeighbor() ? getUrinalWithNoNeighbor() : getUrinalWithNeighbor()

  }

  private def getUrinalWithNeighbor() {
    def available = urinals.findAll().findAll { it.status == UrinalStatus.AVAILABLE }
    available.isEmpty() ? null : available.last()
  }

  private def getUrinalWithNoNeighbor() {
    def available = urinals.findAll().findAll { it.isAvailable() }
    available.isEmpty() ? null : available.last()

  }

  private def urinalExistsWithoutNeighbor() {
    null == getUrinalWithNoNeighbor() ? false : true
  }

  def getUrinalByPosition(int position) {
    urinals.get(position - 1)
  }
}
