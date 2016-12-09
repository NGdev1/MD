<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Сообщения</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/menu.css" rel="stylesheet">
    <link href="/css/messages.css" rel="stylesheet">
    <link href="/css/messages_ios.css" rel="stylesheet">
    <link href="/css/news_item.css" rel="stylesheet">
    <link href="/css/massages_menu.css" rel="stylesheet">

    <script src="/js/jquery.min.js"></script>

</head>
<body>
<div class="container">

<#include "header.ftl">


    <!--
<div class="center-content">
<div class="message-container1">
   привет)) как дела?
</div>

    <div class="message-container2">
      нормально, у тебя?
    </div>
</div>
-->
    <nav role="navigation" class="navbar_messages">
        <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
        </button>

        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li id="VS"><a href="profile">
                    <div class="menu_button_text">Все сообщения</div>
                </a></li>
                <li id="W"><a href="feed">
                    <div class="menu_button_text">Важные</div>
                </a></li>
            </ul>
        </div>
    </nav>

<#include "menu.ftl">

    <div class="center-content">
        <div class="container">
            <div class="bubble">привет)) как дела?привет)) как дела?привет)) как дела?привет)) как дела?привет)) как
                дела?привет)) как дела?привет)) как дела?
            </div>
            <div class="bubble bubble--alt">нормально, у тебя?</div>
            <form id="new_feed" class="news_item" action="" method="post">
                <input name="action" value="new_feed_item" type="hidden">
                <input placeholder="Введи сообщение:" class="input_green" name="text"/>
                <input class="button1" type="submit"/>
            </form>
        </div>
    </div>
</div>

</body>
</html>