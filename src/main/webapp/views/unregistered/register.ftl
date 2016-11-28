<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Регистрация</title>

    <link href="../../css/singin.css" rel="stylesheet">
    <link href="../../css/style.css" rel="stylesheet">

    <!-- jQuery -->
    <script src="../../js/jquery.min.js"></script>

    <script src="../../js/validation.js"></script>

</head>
<body>

<div class="container">

<#include "../header.ftl">

    <form class="form-center-content" action="/register" method="post">
        <div class="form-signin-heading">Регистрация</div>

        <input class="form-control" type="text" name="name" placeholder="Имя (Логин)"/>
        <div class="error_message" id="message" style="display: none">Введите имя</div>

            <input class="form-control" type="text" name="surname" placeholder="Фамилия"/>

            <input class="form-control" type="text" name="patronymic" placeholder="Отчество"/>

            <input class="form-control" type="text" name="mail" placeholder="@Mail, для обратной связи"/>

        <input class="form-control" type="text" name="phone" placeholder="Номер телефона"/>

        <label for="image">Фото</label>
        <input class="form-control" id="image" name="image" type="file"/>

        <input class="form-control" type="password" name="password" placeholder="Пароль"/>
        <input class="form-control" type="password" name="password2" placeholder="Повторите пароль"/>

        <label for="DOB">Дата рождения</label>
        <input id="DOB" class="form-control" type="date" name="DOB" placeholder="Дата рождения"/>

        <div>Город:</div>
        <select id="city" class="form-control" name="city">
            <option value="No">Город...</option>
            <option value="Kazan">Казань</option>
            <option value="Moscow">Москва</option>
            <option value="Spb">Санкт-Петербург</option>
            <option value="S">Самара</option>
            <option value="Yl">Ульяновск</option>
        </select>



        <div>Отряд:</div>
        <select id="otryad" class="form-control" name="otryad">
            <option value="No">Отряд...</option>
            <option value="Legion">"Легион" ТИСБИ г. Казань</option>
            <option value="Himik">"Химик" КНИТУ-КХТИ г. Казань</option>
            <option value="KP"> "Книга Памяти" КНИТУ-КАИ им.А.Н.Туполева г. Казань</option>
            <option value="SD">"Снежный десант" Казанского Федерального университета г. Казань</option>
            <option value="KS">"Красная стрела" ИЭУП г. Казань</option>
            <option value="Vozrozhdenie">"Возрождение" г. Казань</option>
            <option value="ZF">"Западный Фронт" г. Казань</option>
            <option value="PT">"Поисковая тропа" КГЭУ г.Казань</option>
            <option value="R">"Разведка" г. Казань</option>
            <option value="SKIF">"СКИФ" ТГГПУ г. Казань</option>
            <option value="R">"Поиск" МБОУ «Гимназия №96» г.Казань</option>
            <option value="R">"Юные патриоты России" г. Казань</option>
        </select>



        <div>Пол:</div>
        <div class="radio-group">
            <span>Средний</span>
            <input type="radio" placeholder="Пол" name="sex" value="male"/>
            <span>Женский</span>
            <input type="radio" placeholder="Пол" name="sex" value="female"/>
        </div>

        <label for="save">Запомнить меня</label>
        <input id="save" type="checkbox" name="save" checked="checked"/>

        <div id="error" class="text-danger"></div>

        <input id="submit" class="register-button" style="margin: 0;" type="submit" name="register"/>

        <div style="margin-top: 10px">Уже зарегистрированы?</div>
        <a class="register-button" style="background-color: cornflowerblue; margin: 0" href="/login">Вход</a>
    </form>
</div>

</body>
</html>