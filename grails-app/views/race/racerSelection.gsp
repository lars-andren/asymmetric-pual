<!doctype html>
<html>
<head>
    <title>Asymmetric Pual</title>
</head>
<body>
    <div id="content" role="main" align="center">
        <section class="row colset-2-its">

            <h2>
                Select your racers
            </h2>


            <img src="http://lakefrontrow.com/gazebo/wp-content/uploads/2013/05/2-Fast-2-Furious.png">

            <g:form controller="race" action="save">

                <h2><label>Racer 1 </label><br></h2>
                <g:radioGroup name="racer1"
                              labels="['RSA','ECC']"
                              values="['RSA','ECC']" >
                    <p>${it.label} ${it.radio}</p>
                </g:radioGroup>

                <h2><label>Racer 2 </label><br></h2>
                <g:radioGroup name="racer2"
                              labels="['RSA','ECC']"
                              values="['RSA','ECC']" >
                    <p>${it.label} ${it.radio}</p>
                </g:radioGroup>

                <label>Data to encrypt: </label>
                <g:textField name="data"/><br/>
                <p></p>
                <g:submitButton name="save" value="Don't look back" />
            </g:form>

        </section>
    </div>

</body>
</html>
