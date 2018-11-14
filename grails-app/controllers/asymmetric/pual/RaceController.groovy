package asymmetric.pual


class RaceController {

        static rsaKeypair = RSAKeyGenerator.generateKeypair()
        static eccKeypair = ECCKeyGenerator.generateKeypair()

        def index() {
            render view: 'raceIntro'
        }

        def form() {}

        def save() {
            def race = new Race(params)
            race.save()

            doRace(race)

            render view: 'raceProgress'
        }

        def racing(Race race) {

            def racer1 = race.getProperty("racer1")
            def racer2 = race.getProperty("racer2")

            return race
        }

        def doFullRace(Race race) {

            race.startDate = new Date()

            raceBack(race, raceThere(race))

            race.racer1time = racer1time
            race.racer2time = racer2time

            race.winner = racer1time > racer2time ? racer2 : racer1

            race.endDate = new Date()

            return race
        }

        def raceThere(Race race) {
            String[] firstLegRacer1 = encryptAndTime(race.racer1, race.data)
            race.racer1time = new Integer(firstLegRacer1[0])

            String[] firstLegRacer2 = encryptAndTime(race.racer1, race.data)
            race.racer2time = new Integer(firstLegRacer2[0])

            String[] encryptedArray = [(String)firstLegRacer1[1], (String)firstLegRacer2[1]]
            return encryptedArray
        }

        def raceBack(Race race, String[] encryptedData) {

            def racer1secondLegTime = decryptAndTime(race.racer1, encryptedData[0])
            def racer2secondLegTime = decryptAndTime(race.racer2, encryptedData[1])

            race.racer1time += racer1secondLegTime;
            race.racer2time += racer2secondLegTime;
        }

        def encryptAndTime(Algorithm racer, String data) {

            def keyPair = selectKeyPair(racer)

            def startTime = new Date()
            def encryptedData = EncryptDecryptService.encrypt(data, keyPair.getPublic(), racer.toString())
            def endTime = new Date()

            return [endTime.time - startTime.time, encryptedData]
        }

        def decryptAndTime(Algorithm racer, String data) {

            def keyPair = selectKeyPair(racer)

            def startTime = new Date()
            EncryptDecryptService.decrypt(data.bytes, keyPair.getPrivate(), racer.toString())
            def endTime = new Date()

            return (endTime.time - startTime.time)
        }

        def selectKeyPair(Algorithm racer) {

            return racer == Algorithm.RSA ? rsaKeypair : eccKeypair
        }
}
