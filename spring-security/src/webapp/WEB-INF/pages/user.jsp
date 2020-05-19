<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Welcome ${user.name}!</h2><br>
<center>
    <form action="/logout" method="GET">
        <input type="submit" value="Logout"/>
    </form>
</center>
</body>
</html>