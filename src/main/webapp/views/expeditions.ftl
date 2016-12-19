<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Экспедиции</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/menu.css" rel="stylesheet">

    <script src="/js/jquery.min.js"></script>
</head>
<body>
<div class="container">

<#include "header.ftl">
<#include "menu.ftl">

    <div class="center-content">
        <div class="container">
        <#list expeditions as expedition>
        ${expedition.getName()}
            <#list expedition.getSquads() as squad>
                <div>${squad.getName()}</div>
            </#list>

            <#list expedition.getParticipants() as participant>
                <div>${participant.getName()}</div>
            </#list>
        </#list>
        </div>
    </div>

</div>

</body>
</html>