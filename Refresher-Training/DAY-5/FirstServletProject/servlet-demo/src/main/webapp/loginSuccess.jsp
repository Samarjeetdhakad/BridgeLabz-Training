<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Success</title>
</head>

<body>
    <h2>Login Successful!</h2>
    <p>
        Welcome, <%= request.getAttribute("user") %>
    </p>
    <a href="login.html">Back to Login</a>
</body>
</html>