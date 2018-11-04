<!DOCTYPE html>
<html>
<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
    }

    * {
        box-sizing: border-box
    }

    /* Full-width input fields */
    input[type=text], input[type=password], input[type=number]{
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }

    input[type=text]:focus, input[type=password]:focus {
        background-color: #ddd;
        outline: none;
    }

    hr {
        border: 1px solid #f1f1f1;
        margin-bottom: 25px;
    }

    /* Set a style for all buttons */
    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }

    button:hover {
        opacity: 1;
    }

    /* Add padding to container elements */
    .container {
        padding: 16px;
    }

    /* Clear floats */
    .clearfix::after {
        content: "";
        clear: both;
        display: table;
    }

    table {
        width: 100%;
    }

    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }

    th, td {
        padding: 15px;
        text-align: left;
    }

    table#t01 tr:nth-child(even) {
        background-color: #eee;
    }

    table#t01 tr:nth-child(odd) {
        background-color: #fff;
    }

    table#t01 th {
        background-color: black;
        color: white;
    }

    a:link {
        color: green;
        background-color: transparent;
        text-decoration: none;
    }

    a:visited {
        color: pink;
        background-color: transparent;
        text-decoration: none;
    }

    a:hover {
        color: red;
        background-color: transparent;
        text-decoration: underline;
    }

    a:active {
        color: yellow;
        background-color: transparent;
        text-decoration: underline;
    }

</style>
<body>

<a href="http://localhost:8080/car-dealer-web/login"><h2>${login}</h2></a>

<form method="POST">
    <div class="container">
        <p>Please fill in this form to sel your car.</p>
        <hr>

        <label for="price"><b>Price in EURO</b></label>
        <input type="number" placeholder="Price in EURO" name="price" step="1"  value=${price} required/>

        <label for="make"><b>Make</b></label>
        <input type="text" placeholder="Make" name="make" value=${make} required>

        <label for="model"><b>Model</b></label>
        <input type="text" placeholder="Model" name="model" value=${model} required>

        <label for="trim"><b>Trim</b></label>
        <input type="text" placeholder="Trim" name="trim" value=${trim} required>

        <label for="km"><b>Km</b></label>
        <input type="number" placeholder="Km" name="km" step="1"  value=${km} required>

        <label for="year"><b>Year</b></label>
        <input type="number" placeholder="Year" name="year" min="1950" max="2050" step="1" value=${year} required>

        <label for="fuelType"><b>Fuel Type</b></label>
        <input type="text" placeholder="Fuel Type" name="fuelType" value=${fuelType} required>

        <label for="bodyType"><b>Body Type</b></label>
        <input type="text" placeholder="Body Type" name="bodyType" value=${bodyType}  required>

        <label for="color"><b>Color</b></label>
        <input type="text" placeholder="Color" name="color" value=${color}  required>

        <label for="city"><b>City</b></label>
        <input type="text" placeholder="City" name="city" value=${city}  required>

        <label for="power"><b>Power Kw</b></label>
        <input type="number" placeholder="Power Kw" name="power" step="1" value=${power}  required>

        <label for="transmission"><b>Transmission</b></label>
        <input type="text" placeholder="transmission" name="transmission" value=${transmission} required>

        <h3 class="car-options" style="text-align:center;">Options</h3>

        <table id="t01">
            <tr>
                <td><input type="checkbox" name="abs" value="abs" checked>Abs</td>
                <td><input type="checkbox" name="airbag" value="airbag" checked>Airbag</td>
                <td><input type="checkbox" name="alarm" value="alarm" checked>Alarm</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="alloyWheels" value="alloyWheels" checked>Alloy wheels</td>
                <td><input type="checkbox" name="centralLocking" value="centralLocking" checked>Central locking</td>
                <td><input type="checkbox" name="cruiseControl" value="cruiseControl" checked>Cruise Control</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="electricMirrors" value="electricMirrors" checked>Electric Mirrors</td>
                <td><input type="checkbox" name="electricWindows" value="electricWindows" checked>Electric Windows</td>
                <td><input type="checkbox" name="tripComputer" value="tripComputer" checked>Trip Computer</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="leather" value="leather" checked>Leather</td>
                <td><input type="checkbox" name="powerSteering" value="powerSteering" checked>Power Steering</td>
                <td></td>
            </tr>
        </table>

        <div class="clearfix">
            <button type="submit" class="signupbtn">Sell Car</button>
        </div>
    </div>
</form>

</body>
</html>
