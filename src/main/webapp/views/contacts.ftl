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

    <nav role="navigation" class="navbar_messages">
        <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
        </button>

        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li id="VP"><a href="profile">
                    <div class="menu_button_text">Все поисковики</div></a></li>
                <li id="MF"><a href="feed">
                    <div class="menu_button_text">Мои друзья</div></a></li>
                <li id="MO"><a href="feed">
                    <div class="menu_button_text">Мой отряд</div></a></li>
            </ul>
        </div>
    </nav>

    <div class="center-content">
        <div class="container">
            <div class="title">Контакты</div>

            <div class="title">Поисковики</div>


        <#list Users as user>
            <div style="height: 250px;">
            ${user_index + 1})
                <div style="height: 0"><img src="../images/no_photo2.png" alt="${user.getName()}"/></div>
                <div style="font-size: 30px; margin-left: 250px">${user.getName()}
                </div>
                <div style="font-size: 30px; margin-left: 250px"> ${user.getDOB()}</div>
                <div style="font-size: 30px; margin-left: 250px"> ${user.getPhoneNumber()}</div>
                <div style="margin-left: 250px;"> ${user.getCity()}</div>
            </div>
        </#list>
        </div>
    </div>
</div>
</body>
</html>