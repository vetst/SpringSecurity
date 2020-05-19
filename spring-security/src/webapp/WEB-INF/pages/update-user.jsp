<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Обновить пользователя</h2><br>
<center>
    <form action="/logout" method="GET">
        <input type="submit" value="Logout"/>
    </form>
</center>
<form action="update" method="POST">
    <input type="hidden" name="id" value="${id}">
    <p><input type="text" value="${name}" name="name" placeholder="${name}" required></p>
    <p><input type="text" value="${surName}" name="surName" placeholder="${surName}" required></p>
    <p><input type="text" value="${password}" name="password" placeholder="${password}" required></p>
    <input type="submit" value="Обновить"/></form>
</body>
</html>