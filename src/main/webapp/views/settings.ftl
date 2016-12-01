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
</head>
<body>
<div class="container">

<#include "header.ftl">
<#include "menu.ftl">
    <div class="center-content">
        <div class="container">
            <div class="title">Настройки профиля</div>
            <div style="margin: auto"><img src="../images/no_photo2.png"/></div>
            <form id="new_feed" class="news_item" action="" method="post">
                <input name="action" value="change_profile" type="hidden">
                    <input style="min-width: 65%; font-size: 18px; margin:-5.4cm 5cm 0.35cm 5.55cm" placeholder="Имя:" class="news_item_input" name="login" value="${user.getName()}"/>
                    <input style="min-width: 65%; font-size: 18px; margin-left: 210px" placeholder="Фамилия:" class="news_item_input" name="surname" value="${user.getSurname()}"/>
                    <input style="min-width: 65%; font-size: 18px; margin-left: 210px" placeholder="Отчество:" class="news_item_input" name="patronymic" value="${user.getPatronymic()}"/>
                    <input placeholder="Телефон:" class="news_item_input" type="tel" name="tel" value="${user.getPhoneNumber()}"/>
                    <input placeholder="@Mail:" class="news_item_input" name="mail" value="${user.getEmail()}"/>
                    <input placeholder="Пароль:" class="news_item_input" name="text"/>
                    <input placeholder="Повторите пароль:" class="news_item_input" name="text"/>

                <div>Должность:</div>
                <select id="dolshnost" class="news_item_input" name="dolshnost">
                    <option value="No">Должность...</option>
                    <option value="Kom">"Командир"</option>
                    <option value="ZKom">"Зам. Ком."</option>
                    <option value="ZSklad">"Зав.Складом"</option>
                    <option value="NProd">"Нач.Прод."</option>
                    <option value="S">"Старшина"</option>
                    <option value="E">"Ефрейтор"</option>
                    <option value="R">"Рядовой"</option>
                </select>

                <input class="button_add_news_item" type="submit" value="Сохранить"/>
                <input style="font-size: 15px; margin-left: 10px" class="button_add_news_item" type="submit" value="Добавить экспедицию"/>
                <input style="font-size: 15px; margin-left: 10px" class="button_add_news_item" type="button" value="Настройки сообщений"/>


            </form>
        </div>
    </div>

</body>
