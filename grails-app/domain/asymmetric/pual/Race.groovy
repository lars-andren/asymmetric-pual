package asymmetric.pual

class Race {

    Date startDate
    Date endDate

    Algorithm algorithm
    Algorithm winner

    static constraints = {
    }

    def String toString() {
        return startDate + endDate + algorithm + winner
    }
}
