<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Asymmetric Pual</title>
</head>
<body>
    <div id="content" role="main">
        <section class="row colset-2-its">

            <h2>
                Select your racers
            </h2>

            <g:form controller="race" action="save">

                <label>Racer 1 </label><br>
                <g:radioGroup name="racerChoice1"
                              labels="['RSA','ECC']"
                              values="['RSA','ECC']" >
                    <p>${it.label} ${it.radio}</p>
                </g:radioGroup>

                <label>Racer 2 </label><br>
                <g:radioGroup name="racerChoice2"
                              labels="['RSA','ECC']"
                              values="['RSA','ECC']" >
                    <p>${it.label} ${it.radio}</p>
                </g:radioGroup>

                <label>Data to encrypt: </label>
                <g:textField name="data"/><br/>
                <g:actionSubmit value="GO!"/>
            </g:form>

        </section>
    </div>

</body>
</html>
