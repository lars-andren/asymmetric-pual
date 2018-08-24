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

                <label>Racer 1: </label>
                <g:radio name="racer1" value="RSA"/><br/>
                <g:radio name="racer1" value="ECC"/><br/>

                <label>Racer 2: </label>
                <g:radio name="racer2" value="RSA"/><br/>
                <g:radio name="racer2" value="ECC"/><br/>

                <label>Data to encrypt: </label>
                <g:textField name="data"/><br/>
                <g:actionSubmit value="Save"/>
            </g:form>

        </section>
    </div>

</body>
</html>
