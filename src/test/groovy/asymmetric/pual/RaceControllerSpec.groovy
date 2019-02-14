package asymmetric.pual

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(RaceController)
class RaceControllerSpec extends Specification {

    def race
    def controller

    def setup() {

        race = new Race()

        race.racer1 = Algorithm.ECC
        race.racer2 = Algorithm.RSA

        race.data = "there must be more than black and white"

        controller = new RaceController()
    }

    def cleanup() {
    }

    void doFullRace() {

        controller.doFullRace(race)
        expect:
            race.winner == Algorithm.RSA

    }
}
