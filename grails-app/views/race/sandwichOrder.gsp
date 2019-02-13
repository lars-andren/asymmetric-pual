<!doctype html>
<html>
<head>
    <title>Asymmetric Pual</title>
</head>
<body>
    <div id="content" role="main" align="center">
        <section class="row colset-2-its">

            <h2>
                Order your sandwich
            </h2>

            <img src="https://i.pinimg.com/564x/e1/f8/c9/e1f8c911c79270b25b79e1601e315ff6.jpg?b=t">

            <g:form action="saveSandwich">
                <p></p>
                <label>Sandwiches</label><br>
                <g:radioGroup name="sandwich"
                              labels="['Tuna', 'Other']"
                              values="['Tuna', 'Other']" >
                    <p>${it.label} ${it.radio}</p>
                </g:radioGroup>
                <g:submitButton name="saveSandwich" value="Select racers!"/>
            </g:form>

        </section>
    </div>

</body>
</html>
