<%-- 
    Document   : login
    Created on : 7 Ιουλ 2019, 8:36:39 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: sans-serif;
            background: url("image/iron1.png") no-repeat;
 
        }

        .box {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 400px;
            padding: 40px;
            background: rgba(0, 0, 0, .8);
            box-sizing: border-box;
            box-shadow: 0 15px 25px rgba(0, 0, 0, .5);
            border-radius: 10px;
        }

        .box h2 {
            margin: 0 0 30px;
            padding: 0;
            color: #fff;
            color: #03a9f4;
            text-align: center;
        }

        .box .inputBox {
            position: relative;
        }

        .box .inputBox input {
            width: 100%;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            margin-bottom: 30px;
            border: none;
            border-bottom: 1px solid #fff;
            outline: none;
            background: transparent;
        }

        .box .inputBox label {
            position: absolute;
            top: 0;
            left: 0;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            pointer-events: none;
            transition: .5s;
        }

        .box .inputBox input:focus~label,
        .box .inputBox input:valid~label {
            top: -20px;
            left: 0;
            color: #03a9f4;
            font-size: 12px;
        }

        .box input[type="submit"] {
            background: transparent;
            border: none;
            outline: none;
            color: #fff;
            background: #03a9f4;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }
    </style>
</head>

    <body>
        <div class="box">
            <h2>Login</h2>
              <form name='f' action="login" method='POST'>
                <div class="inputBox">
                    <input type="text" name="username" required="">
                    <label>Username</label>
                </div>
                <div class="inputBox">
                    <input type="password" name="password" required="">
                    <label>Password</label>
                </div>
                <input type="submit" name="submit" value="submit">
            </form>
                    <a href="registerUser">Register</a>
        </div>


    </body>

</html>