package asymmetric.pual

class RaceController {

        def index() {
            render view: 'raceIntro'
        }

        def form() {}

        def save() {
            def race = new Race(params)
            race.save()

            def result = encryptDecrypt(race)
            render view: 'raceProgress'
        }

        def encryptDecrypt(Race race) {

            def racer1 = race.getProperty("racer1")
            def racer2 = race.getProperty("racer2")

            return race
        }
}
