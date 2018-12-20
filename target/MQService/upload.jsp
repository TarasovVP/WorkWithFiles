<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sakila admin</title>
    <style><%@include file="base.css"%></style>
</head>
<body>
<div>
    <form method="post" enctype="multipart/form-data">
        <fieldset>
            <p>Введите имя и фамилию: </p>
            <div id="div2">
                <p id="p1"><label for="name">Имя: </label><input type="text" name = "name" id="name"></p>
                <p id="p2"><label for="surname">Фамилия: </label><input type="text" name = "surname" id="surname"></p>
            </div>
            <form action="upload" enctype="multipart/form-data" method="post">
                <input name="description" type="text"><br>
                <p><input type="file" name="file" multiple accept="application/doc,application/docx,application/pdf,application/excel,application/x-excel">
                    <input type="submit" name="submit" value="Отправить"></p>
            </form>
        </fieldset>
    </form>
</div>
</body>
</html>