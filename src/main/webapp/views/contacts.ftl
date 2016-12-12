<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Телефон</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/contacts.css" rel="stylesheet">
    <link href="/css/profile.css" rel="stylesheet">
    <link href="/css/menu.css" rel="stylesheet">
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

            <div style="float: right; margin-left: 50px;">
                <div style="position: fixed">
                    <a href="#" class="button">
                        <div class="button_text">Друзья</div>
                    </a>
                    <a href="#" class="button">
                        <div class="button_text">Все</div>
                    </a>
                </div>
            </div>

        <#list Friends as user>
            <div style="overflow: hidden">
                <img class="user-avatar" src="../images/no_photo2.png" alt="${user.getName()}"/>

                <a class="jetton" href="/user/${user.getId()}">
                    <div class="user-info" style="font-size: 30px">${user.getName()}</div>
                    <div class="user-info" style="font-size: 20px">${user.getDOB()}</div>
                    <div class="user-info" style="font-size: 20px; float: right">${user.getPhoneNumber()}</div>
                    <div class="user-info"> ${user.getCity()}</div>
                </a>


                <a style="font-size: 15px; float: right; margin-top: 30px" class="button1">Добавить в
                    контакты</a>
            </div>
            <div class="divider"></div>
        </#list>

            <div style="margin-top: 30px; margin-bottom: 30px" class="title">Поисковики</div>

        <#list Users as user>

            <div style="overflow: hidden">
                <img class="user-avatar" src="../images/no_photo2.png" alt="${user.getName()}"/>

                <a class="jetton" href="/user/${user.getId()}">
                    <div class="user-info" style="font-size: 30px">${user.getName()}</div>
                    <div class="user-info" style="font-size: 20px">${user.getDOB()}</div>
                    <div class="user-info" style="font-size: 20px; float: right">${user.getPhoneNumber()}</div>
                    <div class="user-info"> ${user.getCity()}</div>
                </a>


                <a style="font-size: 15px; float: right; margin-top: 30px" class="button1">Добавить в
                    контакты</a>
            </div>
            <div class="divider"></div>

        </#list>
            <div style="text-align: center">На сайте ${Users?size} поисковиков</div>
        </div>
    </div>
</div>
</body>
</html>