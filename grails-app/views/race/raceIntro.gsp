<!doctype html>
<html>
<head>
    <title>Asymmetric Pual</title>
</head>
<body>
    <div id="content" role="main">
        <section class="row colset-2-its">

            <h2>
                Select your racers
            </h2>

            <g:form action="save">

                <label>Racer 1 </label><br>
                <g:radioGroup name="racer1"
                              labels="['RSA','ECC']"
                              values="['RSA','ECIES']" >
                    <p>${it.label} ${it.radio}</p>
                </g:radioGroup>

                <label>Racer 2 </label><br>
                <g:radioGroup name="racer2"
                              labels="['RSA','ECC']"
                              values="['RSA','ECIES']" >
                    <p>${it.label} ${it.radio}</p>
                </g:radioGroup>

                <label>Data to encrypt: </label>
                <g:textField name="data"/><br/>
                <g:submitButton name="save" value="GO!"/>
            </g:form>

        </section>
    </div>

</body>
</html>
