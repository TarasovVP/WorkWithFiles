<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sakila admin</title>
    <style><%@include file="base.css"%></style>
</head>
<body>
<div>
    <form method="post">
        <fieldset>
            <p>Введите имя и фамилию: </p>
            <div id="div2">
                <p id="p1"><label for="name">Имя: </label><input type="text" name = "name" id="name"></p>
                <p id="p2"><label for="surname">Фамилия: </label><input type="text" name = "surname" id="surname"></p>
            </div>
            <form action="UploadServlet" enctype="multipart/form-data" method="post">
                <input name="description" type="text"><br>
                <p><input type="file" name="file" >
                    <input type="submit" value="Отправить"></p>
            </form>
        </fieldset>
    </form>
</div>
</body>
</html>