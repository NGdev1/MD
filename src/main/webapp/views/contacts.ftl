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

    <script src="/js/jquery.min.js"></script>
</head>
<body>
<div class="container">


<#include "header.ftl">
<#include "menu.ftl">

    <div class="center-content">
        <div class="container">
            <div class="title">Контакты</div>

            <div class="title">Поисковики</div>
            <table>
                <tbody>

        <#list Users as user>
        <tr>
            <td style="margin-bottom: 10px;" id="${user.getId()}"> ${user_index + 1}) ${user.getName()}</td>

            <td class="contacts_" tel="${user.getPhoneNumber()}">
                    ${user.getPhoneNumber()}</td>

            <td class="contacts_DOB" tel="${user.getDOB()}">
            ${user.getDOB()}</td>

            <td class="contacts_" tel="${user.getCity()}">
            ${user.getCity()}</td>
</tr>

        </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>