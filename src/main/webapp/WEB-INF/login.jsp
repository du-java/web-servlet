<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<form action="/local/login" method=post>
<input type=text name="username"><br>
<input type=password name="password"><br>
<input type=submit value="login">
</form>
</body>
</html>