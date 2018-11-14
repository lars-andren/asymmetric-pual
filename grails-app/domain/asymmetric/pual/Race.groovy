package asymmetric.pual

class Race {

    Date startDate
    Date endDate

    String data

    int racer1time
    int racer2time

    Algorithm racer1
    Algorithm racer2

    Algorithm winner

    static constraints = {
    }

    def String toString() {
        return startDate + endDate + racer1 + racer2 + winner
    }
}
