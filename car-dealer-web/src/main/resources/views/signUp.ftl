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
    input[type=text], input[type=password] {
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

</style>
<body>

<a href="http://localhost:8080/car-dealer-web/login"><h2>${login}</h2></a>

<form method="POST">
    <div class="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label for="profileName"><b>Profile Name</b></label>
        <input type="text" placeholder="Enter Profile Name" name="profileName" value=${profileName} required>

        <label for="firstName"><b>First Name</b></label>
        <input type="text" placeholder="Enter First Name" name="firstName" value=${firstName} required>

        <label for="secondName"><b>Second Name</b></label>
        <input type="text" placeholder="Enter Second Name" name="secondName" value=${secondName} required>

        <label for="idCardNumber"><b>ID Identity Card</b></label>
        <input type="text" placeholder="Enter The ID of your Identity Card" name="idCardNumber" value=${idCardNumber} required>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" value=${email} required>

        <label for="phoneNumber"><b>Phone Number</b></label>
        <input type="text" placeholder="Enter Phone Number" name="phoneNumber" value=${phoneNumber} required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="psw-repeat" required>

        <div class="clearfix">
            <button type="submit" class="signupbtn">Sign Up</button>
        </div>
    </div>
</form>

</body>
</html>
