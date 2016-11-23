<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Вход</title>

    <link href="../../css/singin.css" rel="stylesheet">
    <link href="../../css/style.css" rel="stylesheet">

    <script src="../../js/jquery.min.js"></script>
</head>
<body>

<div class="container">

<#include "../header.ftl">

    <form class="form-center-content" action="/login" method="post">
        <div class="form-signin-heading">Вход</div>

        <input class="form-control" type="text" name="name" placeholder="Логин"/>
        <input class="form-control" type="password" name="password" placeholder="Пароль"/>

        <label for="save">Запомнить меня</label>
        <input id="save" type="checkbox" name="save" checked="checked"/>
    <#if error??>
        <div class="text-danger">${error}</div>
    </#if>

        <input class="login-button" type="submit" name="login" value="Войти"/>
        <a class="register-button" href="/register">Регистрация</a>
    </form>
</div>

</body>
</html>