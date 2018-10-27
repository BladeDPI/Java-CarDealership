<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Blog posts</title>

    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.css">
    <style>
        .navbar-brand {
            font-size: 30px;
        }

        .car-deals-title {
            font-size: 24px;
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
    </style>
</head>

<body>
<div class="container">

    <nav class="navbar navbar-dark bg-dark">
        <div class="navbar-brand">Car Deals</a></div>
    </nav>

        <#list carDeals as carDeal>
        <div class="car-deals">
            <h2 class="car-deals-title">${carDeal.title}</h2>
            <p class="car-deals-meta">${carDeal.uploadDate?datetime} by <a href="#">${carDeal.writer}</a></p>


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
        </div>
        </#list>

    <#--<h2>Add new car deal</h2>-->

    <#--<form method="POST">-->
        <#--<label for="title">Title:</label> <input type="text" name="title" required> <br>-->
        <#--<label for="writer">Writer:</label> <input type="text" name="writer" required> <br>-->
        <#--<label for="content">Content:</label> <input type="textarea" name="content" required> <br>-->
        <#--<button type="submit">Submit</button>-->
    <#--</form>-->
</div>
</body>
</html>
