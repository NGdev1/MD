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


<#if userInfo??>
    <script>
        $(document).ready(function () {
            var dolshnost = '${userInfo.getDolshnost()}';
            var divDolshnost = $('#dolshnost');

            if (dolshnost == 'S') {
                divDolshnost.html('"Боец"');
            } else if (dolshnost == 'NProd') {
                divDolshnost.html('"Нач.Прод."')
            }
        })
    </script>
</#if>

</head>
<body>
<div class="container">

<#include "../header.ftl">
<#include "../menu.ftl">

    <div class="center-content">
        <div class="container">

            <div class="title">Профиль</div>

        <div class="user-info-container">


        <#if userInfo??>
            <img class="user-avatar" src="/images/avatars/no_photo2.png"/>

            <div class="user-info-text">
                <div class="user-info">${userInfo.getSurname()}</div>
                <div class="user-info">${userInfo.getName()}</div>
                <div class="user-info">${userInfo.getPatronymic()}</div>
                <div class="user-info">${userInfo.getOtryad()}</div>
                <div class="user-info">${userInfo.getPhoneNumber()}</div>
                <div class="user-info">${userInfo.getEmail()}</div>
                <div class="user-info" id="dolshnost"></div>
            </div>
        </div>
            <form id="new_feed" action="" method="post">
                <input name="action" value="new_feed_item" type="hidden">
                <label>Ваша новость:
                    <textarea id="news_item_text" class="input_green" name="text"></textarea>
                </label>
                <input class="button1" type="submit"/>
            </form>

            <div id="news_container">

            </div>

        <#else>
            <div class="title">Такого нет!</div>
        </#if>

</body>
</html>