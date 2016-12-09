<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Новости</title>

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

            <form id="new_feed" class="news_item" action="" method="post">
                <input name="action" value="new_feed_item" type="hidden">
                <label>Ваша новость:
                    <textarea id="news_item_text" class="input_green" name="text"></textarea>
                </label>
                <input class="button1" type="submit"/>
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