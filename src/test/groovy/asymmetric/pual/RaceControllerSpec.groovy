package asymmetric.pual

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(RaceController)
class RaceControllerSpec extends Specification {

    def setup() {

        Race race = new Race()

        race.racer1 = Algorithm.ECC
        race.racer2 = Algorithm.RSA

    }

    def cleanup() {
    }

    void runRace() {



    }
}
