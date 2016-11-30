<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Профиль</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/menu.css" rel="stylesheet">
    <link href="/css/news_item.css" rel="stylesheet">

    <script src="/js/jquery.min.js"></script>
    <script src="/js/feed.js"></script>
</head>
<body>
<div class="container">

<#include "header.ftl">
<#include "menu.ftl">

    <div class="center-content">
        <div class="container">
            <div class="title">Профиль</div>
            <div style="margin: auto"><img src="../images/no_photo2.png"/></div>
            <form id="new_feed" class="news_item" action="" method="post">
                <input name="action" value="change_profile" type="hidden">
                <input style="min-width: 65%; font-size: 18px; margin:-5.4cm 5cm 0.35cm 5.55cm;"  placeholder="Фамилия:" class="news_item_input" name="surname" value="${user.getSurname()}"/>
                <input style="min-width: 65%; font-size: 18px; margin-left: 210px" placeholder="Имя:" class="news_item_input" name="login" value="${user.getName()}"/>
                <input style="min-width: 65%; font-size: 18px; margin-left: 210px" placeholder="Отчество:" class="news_item_input" name="patronymic" value="${user.getPatronymic()}"/>
                <input placeholder="Отряд:" class="news_item_input" name="otryad" value="${user.getOtryad()}"/>
                <input placeholder="Телефон:" class="news_item_input" type="tel" name="tel" value="${user.getPhoneNumber()}"/>
                <input placeholder="@Mail:" class="news_item_input" name="mail" value="${user.getEmail()}"/>
                <input placeholder="dolshnost:" class="news_item_input" name="dolshnost" value="${user.getDolshnost()}"/>
            </form>
        </div>
    </div>

    <div class="center-content">
        <div class="container">

            <form id="new_feed" class="news_item" action="" method="post">
                <input name="action" value="new_feed_item" type="hidden">
                <label>Ваша новость:
                    <textarea class="news_item_input" name="text"></textarea>
                </label>
                <input class="button_add_news_item" type="submit"/>
            </form>

            <div id="news_container">

            </div>
        </div>
    </div>

</body>
</html>