<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Car dealer</title>

    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.css">
    <style>
        .navbar-brand {
            font-size: 30px;
        }

        .car-basic-information {
            background-color: aqua;
        }

        .car-options {
            background-color: chartreuse;
        }

        .car-deals-title {
            font-size: 16px;
            padding-top: 30px;
        }

        .car-deals-meta {
            color: #888888;
        }

        .car-deals {
            margin-bottom: 30px;
            border-bottom: 1px solid grey;
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

        button {
            background-color: #af7c35;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }
    </style>
</head>

<body>
<div class="container">

    <nav class="navbar navbar-dark bg-dark">
        <div class="navbar-brand">Car Deals</a></div>
    </nav>

    <a href="http://localhost:8080/car-dealer-web/login"><h2>${nickName}</h2></a>

        <#list carDeals as carDeal>
        <div class="car-deals">
            <h2 class="car-deals-title">${carDeal.title}</h2>
            <p class="car-deals-meta">${carDeal.uploadDate?datetime} by <a href="#">${carDeal.person.profileName}</a>
            </p>

            <h3 class="car-basic-information" style="text-align:center;">Basic Information</h3>

            <table id="t01">
                <tr>
                    <td><b>Price</b></td>
                    <td>${carDeal.price} EUR</td>
                </tr>
                <tr>
                    <td><b>Make</b></td>
                    <td>${carDeal.make}</td>
                </tr>
                <tr>
                    <td><b>Model</b></td>
                    <td>${carDeal.model}</td>
                </tr>
                <tr>
                    <td><b>Trim</b></td>
                    <td>${carDeal.trim}</td>
                </tr>
                <tr>
                    <td><b>Model</b></td>
                    <td>${carDeal.model}</td>
                </tr>
                <tr>
                    <td><b>Km</b></td>
                    <td>${carDeal.km}</td>
                </tr>
                <tr>
                    <td><b>Year</b></td>
                    <td>${carDeal.year}</td>
                </tr>
                <tr>
                    <td><b>Fuel Type</b></td>
                    <td>${carDeal.fuelType}</td>
                </tr>
                <tr>
                    <td><b>Body Type</b></td>
                    <td>${carDeal.bodyType}</td>
                </tr>

                <tr>
                    <td><b>Color</b></td>
                    <td>${carDeal.color}</td>
                </tr>

                <tr>
                    <td><b>City</b></td>
                    <td>${carDeal.city}</td>
                </tr>

                <tr>
                    <td><b>Power</b></td>
                    <td>${carDeal.power} Kw</td>
                </tr>

                <tr>
                    <td><b>Transmission</b></td>
                    <td>${carDeal.transmission}</td>
                </tr>
            </table>

            <h3 class="car-options" style="text-align:center;">Options</h3>

            <table id="t01">
                <tr>
                    <td>${carDeal.options.abs}</td>
                    <td>${carDeal.options.airbag}</td>
                    <td>${carDeal.options.alarm}</td>
                </tr>
                <tr>
                    <td>${carDeal.options.alloyWheels}</td>
                    <td>${carDeal.options.centralLocking}</td>
                    <td>${carDeal.options.cruiseControl}</td>
                </tr>
                <tr>
                    <td>${carDeal.options.electricMirrors}</td>
                    <td>${carDeal.options.electricWindows}</td>
                    <td>${carDeal.options.tripComputer}</td>
                </tr>
                <tr>
                    <td>${carDeal.options.leather}</td>
                    <td>${carDeal.options.powerSteering}</td>
                    <td></td>
                </tr>
            </table>
        </div>

        <form method="POST">
            <button type="submit" name="button" value="${carDeal.id}">BUY</button>
        </form>
        </#list>

    <h2>Find by ID</h2>

    <form method="POST">
        <label for="title">ID:</label> <input type="text" name="id" required> <br>
        <button type="submit" name="button" value="find">FIND</button>
    </form>
</div>
</body>
</html>
