<!doctype html>
<html>
<head>
    <title>Asymmetric Pual</title>
</head>
<body>

    <div id="raceStart" align="center">
        <img src="@/assets/images/racestart.png">
        <p>
        <p>${race.racer1} is racing ${race.distance} against ${race.racer2}</p>
        <h2>
        Start your engines...RACE!
        </h2>
    </div>
    <div id="resultsButton" align="center">
        <g:link controller="race" action="getResults">See the results</g:link>
    </div>
</body>
</html>
