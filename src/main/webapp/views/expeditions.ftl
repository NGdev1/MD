<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Экспедиции</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/menu.css" rel="stylesheet">
    <link href="/css/profile.css" rel="stylesheet">

    <script src="/js/jquery.min.js"></script>
</head>
<body>
<div class="container">

<#include "header.ftl">
<#include "menu.ftl">

    <div class="center-content">
        <div class="container">
            <div class="title">Ваши экспедиции:</div>
            <div class="divider"></div>
        <#list expeditions as expedition>
            <div class="text center" style="font-size: 20px">
            ${expedition.getName()}
            </div>

            <div class="text">
                <div style="font-size: 20px">
                    Отряды:
                </div>
                <#list expedition.getSquads() as squad>
                    <div>${squad.getName()}</div>
                </#list>
            </div>

            <div class="text">
                <div style="font-size: 20px">
                    Участники:
                </div>
                <#list expedition.getParticipants() as participant>
                    <div style="display: block; overflow: hidden">
                        <img style="height: 60px; width: 60px; float: left" class="user-avatar" src="/upload/${participant.getImage()}">
                        <a style="margin: 10px 0 0 0; float: left;" href="/user/${participant.getId()}">${participant.getName()}</a>
                    </div>
                </#list>
            </div>

            <a class="center" href="/full_map/${expedition.getId()}">Перейти к карте</a>

            <div class="divider"></div>

        </#list>
        </div>
    </div>

</div>

</body>
</html>