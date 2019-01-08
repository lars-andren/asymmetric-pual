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
        return startDate + "_" + endDate + "_" + racer1 + "_" + racer2 + "_Winner: " + winner
    }
}
