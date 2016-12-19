<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Профиль</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/menu.css" rel="stylesheet">
    <link href="/css/profile.css" rel="stylesheet">

    <script src="/js/jquery.min.js"></script>
    <script src="/js/feed.js"></script>

    <script>
        $(document).ready(function () {
            var dolshnost = '${user.getDolshnost()}';
            var divDolshnost = $('#dolshnost');

            if (dolshnost == 'S') {
                divDolshnost.html('"Боец"');
            } else if (dolshnost == 'NProd') {
                divDolshnost.html('"Нач.Прод."')
            }
        })
    </script>
</head>
<body>
<div class="container">

<#include "header.ftl">
<#include "menu.ftl">

    <div class="center-content">
        <div class="container">
            <div class="title">Профиль</div>
            <div class="white-container">

                <img class="user-avatar" src="/upload/${user.getImage()}"/>

                <div class="user-info-text">
                    <div class="user-info">${user.getSurname()}</div>
                    <div class="user-info">${user.getName()}</div>
                    <div class="user-info">${user.getPatronymic()}</div>
                    <div class="user-info">${user.getOtryad()}</div>
                    <div class="user-info">${user.getPhoneNumber()}</div>
                    <div class="user-info">${user.getEmail()}</div>
                    <div class="user-info" id="dolshnost"></div>
                </div>
            </div>

            <form id="new_feed" action="" method="post">
                <input name="action" value="new_feed_item" type="hidden">
                <label>Ваша запись:
                    <textarea id="news_item_text" class="input_green" name="text"></textarea>
                </label>
                <input class="button1" type="submit"/>
            </form>

            <div id="news_container">

            </div>

</body>
</html>