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
            <form id="new_feed" class="news_item" action="" method="post">
                <input name="action" value="change_profile" type="hidden">
                <input placeholder="Фото" class="news_item_input" name="images"/>
                <input placeholder="Имя:" class="news_item_input" name="login" value="${user.getName()}"/>
                <input placeholder="Фамилия:" class="news_item_input" name="text"/>
                <input placeholder="Отчество:" class="news_item_input" name="text"/>
                <input placeholder="Отряд:" class="news_item_input" name="otryad" value="${user.getOtryad()}"/>
                <input placeholder="Телефон:" class="news_item_input" type="tel" name="tel" value="${user.getPhoneNumber()}"/>
                <input placeholder="@Mail:" class="news_item_input" name="mail" value="${user.getEmail()}"/>
            </form>
        </div>
    </div>

</body>

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

<#if error??>
    <h2>${error}</h2>
</#if>

</div>

</body>
</html>