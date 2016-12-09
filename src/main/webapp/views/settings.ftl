<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Настройки</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/menu.css" rel="stylesheet">
    <link href="/css/news_item.css" rel="stylesheet">

    <script src="/js/jquery.min.js"></script>

    <script>
        $(document).ready(function(){
            var dolshnost = '${user.getDolshnost()}';

            $('#dolshnost option[value=' + dolshnost + ']').attr('selected', 'true');
        });

        var toggleTime = 200;

        function showChangePasswordForm(){
            $('#change_profile_form').hide(toggleTime);
            $('#add_expedition_form').hide(toggleTime);
            $('#change_password_form').show(toggleTime);
        }

        function showChangeProfileForm(){
            $('#add_expedition_form').hide(toggleTime);
            $('#change_password_form').hide(toggleTime);
            $('#change_profile_form').show(toggleTime);
        }

        function showAddExpeditionForm(){
            $('#change_profile_form').hide(toggleTime);
            $('#change_password_form').hide(toggleTime);
            $('#add_expedition_form').show(toggleTime);
        }
    </script>
</head>
<body>
<div class="container">

<#include "header.ftl">
<#include "menu.ftl">
    <div class="center-content">
        <div class="container">

            <form id="change_profile_form" class="news_item" action="/settings" method="post">
                <div class="title">Настройки профиля</div>
                <img src="../images/no_photo2.png"/>

                <input name="action" value="change_profile" type="hidden">
                <input style="min-width: 65%; font-size: 18px; margin:-5.4cm 5cm 0.35cm 5.55cm" placeholder="Имя:"
                       class="input_green" name="login" value="${user.getName()}"/>
                <input style="min-width: 65%; font-size: 18px; margin-left: 210px" placeholder="Фамилия:"
                       class="input_green" name="surname" value="${user.getSurname()}"/>
                <input style="min-width: 65%; font-size: 18px; margin-left: 210px" placeholder="Отчество:"
                       class="input_green" name="patronymic" value="${user.getPatronymic()}"/>
                <input placeholder="Телефон:" class="input_green" type="tel" name="tel"
                       value="${user.getPhoneNumber()}"/>
                <input placeholder="@Mail:" class="input_green" name="mail" value="${user.getEmail()}"/>

                <select id="dolshnost" class="input_green" name="dolshnost" title="">
                    <option value="No">Должность...</option>
                    <option value="Kom">"Командир"</option>
                    <option value="ZKom">"Зам. Ком."</option>
                    <option value="ZSklad">"Зав.Складом"</option>
                    <option value="NProd">"Нач.Прод."</option>
                    <option value="S">"Боец"</option>
                </select>

                <input class="button1" type="submit" value="Сохранить"/>

            </form>

            <form id="change_password_form" class="news_item" action="/settings" method="post" style="display: none">
                <div class="title">Сменить пароль</div>

                <input placeholder="Пароль:" class="input_green" name="text"/>
                <input placeholder="Повторите пароль:" class="input_green" name="text"/>

                <input type="submit" class="button1" value="Сменить пароль"/>
            </form>

            <form id="add_expedition_form" class="news_item" action="/settings" method="post" style="display: none">
                <div class="title">Добавить экспедицию</div>

                <input placeholder="Телефон:" class="input_green" type="tel" name="tel"
                       value="${user.getPhoneNumber()}"/>
                <input placeholder="@Mail:" class="input_green" name="mail" value="${user.getEmail()}"/>

                <input type="submit" class="button1" value="Добавить"/>
            </form>

            <button onclick="showChangeProfileForm()" class="button1">Профиль</button>
            <button onclick="showChangePasswordForm()" class="button1">Сменить пароль</button>
            <button onclick="showAddExpeditionForm()" class="button1">Добавить экспедицию</button>
            <button class="button1">Настройки сообщений</button>
        </div>
    </div>
</body>
