package asymmetric.pual

import grails.util.Pair

class RaceController {

        static rsaKeypair = RSAKeyGenerator.generateKeypair()
        static eccKeypair = ECCKeyGenerator.generateKeypair()

       // static allowedMethods = [save: 'POST', update: 'PUT', delete: 'DELETE']

        def index() {
            render view: 'sandwichOrder'
        }

        def save() {
            def Race race = new Race(params)
            def verified = checkDataInput(race.data)
            race.data = verified
            race.save(flush: true)
            doFullRace(race)
        }

        def saveSandwich() {
            render view: 'raceSelection'
        }

        def doFullRace(Race race) {

            race.startDate = new Date()

            raceBack(race, raceThere(race))

            def racer1time = race.racer1time
            def racer2time = race.racer2time

            race.winner = racer1time > racer2time ? race.racer2 : race.racer1

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
            race.racer1time = new Long(firstLegRacer1.aValue)

            Pair<Long, byte[]> firstLegRacer2 = encryptAndTime(race.racer2, data)
            race.racer2time = new Long(firstLegRacer2.aValue)

            def encryptedPair = new Pair<byte[], byte[]>(firstLegRacer1.bValue, firstLegRacer2.bValue)
            return encryptedPair
        }

        def raceBack(Race race, Pair<byte[], byte[]> encryptedData) {

            def racer1secondLegTime = decryptAndTime(race.racer1, encryptedData.aValue)
            def racer2secondLegTime = decryptAndTime(race.racer2, encryptedData.bValue)

            race.racer1time += racer1secondLegTime;
            race.racer2time += racer2secondLegTime;
        }

        def encryptAndTime(Algorithm racer, String data) {

            def keyPair = selectKeyPair(racer)

            def startTime = new Date()
            def encryptedData = EncryptDecryptService.encrypt(data, keyPair.getPublic(), racer.toString())
            def endTime = new Date()

            def returnPair = new Pair<Long, byte[]>(endTime.time - startTime.time, encryptedData)

            return returnPair
        }

        def decryptAndTime(Algorithm racer, byte[] data) {

            def keyPair = selectKeyPair(racer)

            def startTime = new Date()
            EncryptDecryptService.decrypt(data, keyPair.getPrivate(), racer.toString())
            def endTime = new Date()

            return (endTime.time - startTime.time)
        }

        def selectKeyPair(Algorithm racer) {
            return racer == Algorithm.RSA ? rsaKeypair : eccKeypair
        }

        def checkDataInput(String data) {
            return data == null ? " " : data
        }
}
