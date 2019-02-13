package asymmetric.pual

class Race {

    Date startDate
    Date endDate

    String data

    String distance = "1/4 mile"
    String spc = "_"

    int racer1time
    int racer2time

    Algorithm racer1
    Algorithm racer2

    Algorithm winner

    static constraints = {
        startDate nullable: true
        endDate nullable: true
        racer1time nullable: true
        racer2time nullable: true
        winner nullable: true
    }

    def String toString() {
        return "${startDate}${spc}${endDate}${spc}${distance}${spc}${racer1}${spc}${racer2}${spc}${winner}".toString()
    }
}
