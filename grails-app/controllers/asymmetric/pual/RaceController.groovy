package asymmetric.pual

class RaceController {

        def index() {
            render view: 'raceIntro'
        }

        def form() {}

        def save() {
            def race = new Race(params)
            race.save()
            render view: 'raceProgress'
        }
}
