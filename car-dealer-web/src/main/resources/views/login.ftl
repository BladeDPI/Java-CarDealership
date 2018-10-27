<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        form {
            border: 3px solid #f1f1f1;
        }

        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }

        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
        }

        img.avatar {
            width: 20%;
            border-radius: 30%;
        }

        .container {
            padding: 16px;
        }

        span.psw {
            float: right;
            padding-top: 16px;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }

            .cancelbtn {
                width: 100%;
            }
        }
    </style>
</head>
<body>

<h2>${login}</h2>

<form method="POST">
    <div class="imgcontainer">
        <img src="data:image/jpeg;base64,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"
             alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <label for="userName"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="userName" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <div>
            <button type="submit" name="button" value="login">Login</button>
            <button type="submit" name="button" value="logout">Logout</button>
        </div>
    </div>
</form>

</body>
</html>
