package asymmetric.pual

import grails.util.Pair

class RaceController {

        static rsaKeypair = RSAKeyGenerator.generateKeypair()
        static eccKeypair = ECCKeyGenerator.generateKeypair()

        def index() {
            render view: '../sandwich/sandwichOrder'
        }

        def save() {
            def Race race = new Race(params)
            def verified = checkDataInput(race.data)
            race.data = verified
            race.save(flush: true)
            doFullRace(race)
        }

        def doFullRace(Race race) {

            race.startDate = new Date()

            raceBack(race, raceThere(race))

            def racer1Time = race.racer1Time
            def racer2Time = race.racer2Time

            race.winner = racer1Time > racer2Time ? race.racer2 : race.racer1

            race.endDate = new Date()

            render (view: 'raceProgress', model: [race: race])
        }

        def getResults() {
            Race race = Race.findByDistance("1/4 mile")
            render (view: 'raceFinished', model: [race:race])
        }

        def raceThere(Race race) {

            def data = checkDataInput(race.data)

            Pair<Long, byte[]> firstLegRacer1 = encryptAndTime(race.racer1, data)
            race.racer1Time = new Long(firstLegRacer1.aValue)

            Pair<Long, byte[]> firstLegRacer2 = encryptAndTime(race.racer2, data)
            race.racer2Time = new Long(firstLegRacer2.aValue)

            def encryptedPair = new Pair<byte[], byte[]>(firstLegRacer1.bValue, firstLegRacer2.bValue)
            return encryptedPair
        }

        def raceBack(Race race, Pair<byte[], byte[]> encryptedData) {

            def racer1secondLegTime = decryptAndTime(race.racer1, encryptedData.aValue)
            def racer2secondLegTime = decryptAndTime(race.racer2, encryptedData.bValue)

            race.racer1Time += racer1secondLegTime;
            race.racer2Time += racer2secondLegTime;
        }

        def encryptAndTime(Algorithm racer, String data) {

            def keyPair = selectKeyPair(racer)
            String cipher = replaceCipherName(racer)

            def startTime = new Date()
            def encryptedData = EncryptDecryptService.encrypt(data, keyPair.getPublic(), cipher)
            def endTime = new Date()

            def returnPair = new Pair<Long, byte[]>(endTime.time - startTime.time, encryptedData)

            return returnPair
        }

        def decryptAndTime(Algorithm racer, byte[] data) {

            def keyPair = selectKeyPair(racer)
            String cipher = replaceCipherName(racer)

            def startTime = new Date()
            EncryptDecryptService.decrypt(data, keyPair.getPrivate(), cipher)
            def endTime = new Date()

            return (endTime.time - startTime.time)
        }

        def selectKeyPair(Algorithm racer) {
            return racer == Algorithm.RSA ? rsaKeypair : eccKeypair
        }

        def replaceCipherName(Algorithm racer) {
            return racer == Algorithm.ECC ? "ECIES" : "RSA"
        }

        def checkDataInput(String data) {
            return data == null ? " " : data
        }
}
