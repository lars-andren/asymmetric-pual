<!doctype html>
<html>
<head>
    <title>Asymmetric Pual</title>
</head>
<body>
    <div id="content" role="main" align="center">

        <img src="https://pmcvariety.files.wordpress.com/2017/04/the-fast-and-the-furious.jpg?w=1000&h=562&crop=1">

            <h2>
                <p>Winner: ${race?.winner}</p>
                <p>
                    Winner's time:
                    <g:if test="${race.racer1Time > race.racer2Time}">
                        ${race.racer2Time} milliseconds
                    <p>
                        Loser's time: ${race.racer1Time}
                    </p>
                    </g:if>
                    <g:else>
                        ${race.racer1Time} milliseconds
                        <p>
                            Loser's time: ${race.racer2Time}
                        </p>
                    </g:else>
                </p>
                <p>Race Started at: ${race?.startDate}</p>
                <p>Race Finished at: ${race?.endDate}</p>
                <p>Distance: ${race?.distance}</p>
                <p>Data encrypted & decrypted: ${race?.data}</p>
            </h2>

        <img src="https://pbs.twimg.com/media/DE42k7hW0AMbuK1.jpg">

    </div>

</body>
</html>
