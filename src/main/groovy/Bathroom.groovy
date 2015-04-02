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
    return (1..numberOfUrinals).each { index ->
      if (index == 1) createFirstUrinal()
      if (index > 1 && index < numberOfUrinals) createMiddleUrinal(index)
      if (index == numberOfUrinals) createLastUrinal(index)
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

  private createMiddleUrinal(int index) {
    Urinal u = urinals.get(index - 1)
    u.position = index
    u.leftNeighbor = getLeftNeighbor(index)
    u.rightNeighbor = new Urinal()
    urinals.add(u.rightNeighbor)
  }

  private Object getLeftNeighbor(int index) {
    return urinals.get(index - 2)
  }

  private createLastUrinal(int index) {
    Urinal u = urinals.get(index - 1)
    u.position = index
    u.leftNeighbor = getLeftNeighbor(index)
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
}
