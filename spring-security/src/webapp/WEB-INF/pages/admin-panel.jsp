<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Список пользователей</h2>

<center>
    <form action="/logout" method="GET">
        <input type="submit" value="Logout"/>
    </form>
</center>

<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <td><b>Id</b></td>
        <td><b>Name</b></td>
        <td><b>Surname</b></td>
        <td><b>Password</b></td>
        <td><b>Edit</b></td>
        <td><b>Delete</b></td>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surName}</td>
            <td>${user.password}</td>
            <td>
                <form action="update" method="GET">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="hidden" name="name" value="${user.name}">
                    <input type="hidden" name="surName" value="${user.surName}">
                    <input type="hidden" name="password" value="${user.password}">
                    <input type="submit" value="Редактировать"/>
                </form>
            </td>
            <td>
                <form action="delete" method="POST">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Удалить"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<h2>Добавить пользователя</h2>
<form action="panel" method="POST">
    <p><input type="text" name="name" placeholder="Name" required></p>
    <p><input type="text" name="surName" placeholder="Surname" required></p>
    <p><input type="text" name="password" placeholder="Password" required></p>
    <input type="submit" value="Добавить"/></form>
</body>
</html>