package asymmetric.pual


class RaceController {

        static rsaKeypair = RSAKeyGenerator.generateKeypair();
        static eccKeypair = ECCKeyGenerator.generateKeypair();

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

        def racing(Race race) {

            def racer1 = race.getProperty("racer1")
            def racer2 = race.getProperty("racer2")



            return race
        }

        def doRace(Race race) {

            race.startDate = new Date()

            def racer1 = race.getProperty("racer1")
            def racer2 = race.getProperty("racer2")

            def racer1time = decryptTimer(encryptTimer(racer1))
            def racer2time = encryptTimer(racer2) + decryptTimer(racer2)

            race.racer1time = racer1time
            race.racer2time = racer2time

            race.winner = racer1time > racer2 ? racer2time : racer1

            race.endDate = new Date()

            return race
        }

        def encryptTimer(Algorithm racer, String data) {

            def startTime = new Date()
            def encryptedData = EncryptDecryptService.encrypt(data, rsaKeypair.getPublic(), "")
            def endTime = new Date()

            return [endTime.time - startTime.time, encryptedData]
        }

        def decryptTimer(Algorithm racer, String data) {

            EncryptDecryptService.decrypt(data, rsaKeypair.getPublic(), "")
        }


}
