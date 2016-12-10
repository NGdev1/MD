<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Телефон</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/contacts.css" rel="stylesheet">
    <link href="/css/menu.css" rel="stylesheet">
    <link href="/css/news_item.css" rel="stylesheet">
    <link href="/css/massages_menu.css" rel="stylesheet">


    <script src="/js/jquery.min.js"></script>
</head>
<body>
<div class="container">


<#include "header.ftl">
<#include "menu.ftl">


    <div class="center-content">
        <div class="container">

            <div class="title">Контакты</div>
        <#list Friends as user>
            <div style="height: 250px;">
            ${user_index + 1})
                <div style="height: 0"><img src="../images/no_photo2.png" alt="${user.getName()}"/></div>
                <div style="font-size: 30px; margin-left: 250px">${user.getName()}
                </div>
                <div style="font-size: 30px; margin-left: 250px"> ${user.getDOB()}</div>
                <div style="font-size: 30px; margin-left: 250px"> ${user.getPhoneNumber()}</div>
                <div style="margin-left: 250px;"> ${user.getCity()}</div>
                <a style="font-size: 15px; margin-left: 450px; margin-top: 30px;" class="button1">Написать сообщение</a>
                <div class="divider"></div>
            </div>
        </#list>

            <div style="margin-top: 30px; margin-bottom: 30px" class="title">Поисковики</div>

        <#list Users as user>
            <div style="height: 250px;">
            ${user_index + 1})
                <div style="height: 0"><img src="../images/no_photo2.png" alt="${user.getName()}"/></div>
                <div style="font-size: 30px; margin-left: 250px">${user.getName()}
                </div>
                <div style="font-size: 30px; margin-left: 250px"> ${user.getDOB()}</div>
                <div style="font-size: 30px; margin-left: 250px"> ${user.getPhoneNumber()}</div>
                <div style="margin-left: 250px;"> ${user.getCity()}</div>
                <a style="font-size: 15px; margin-left: 450px; margin-top: 30px;" class="button1">Добавить в друзья</a>
                <div class="divider"></div>
            </div>
        </#list>
            <div style="text-align: center">На сайте ${Users?size} поисковиков</div>
        </div>
        <div style="position: fixed; top: 90px; left: 1000px;">
            <a href="#" class="button"><div class="button_text">Друзья</div></a>
            <a href="#" class="button"><div class="button_text">Все</div></a>
        </div>
    </div>
</div>
</body>
</html>