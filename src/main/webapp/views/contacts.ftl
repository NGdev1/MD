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

    <script type="text/javascript">
        var animationTime = 400;

        function addContact(id) {
            $.ajax({
                url: "/contacts",
                type: "POST",
                data: {
                    action: "add_friend",
                    friendId: id
                }
            }).done(function (data) {
                if (data == "success") {
                    var newFriend = $('#AllUsers' + id);

                    newFriend.hide(animationTime, function () {
                        var friendsList = $('#friends_list');
                        friendsList.prepend(newFriend);

                        changeBlockToFriend(newFriend, id);
                        newFriend.show(animationTime);
                    });
                }
                else {
                    alert(data);
                }
            });
        }

        function removeContact(id) {
            $.ajax({
                url: "/contacts",
                type: "POST",
                data: {
                    action: "remove_friend",
                    friendId: id
                }
            }).done(function (data) {
                if (data == "success") {
                    var friendToDelete = $('#Friend' + id);

                    friendToDelete.hide(animationTime, function () {
                        var allUsersList = $('#all_users_list');
                        allUsersList.prepend(friendToDelete);

                        changeBlockToUser(friendToDelete, id);
                        friendToDelete.show(animationTime);
                    })
                }
                else {
                    alert(data);
                }
            });
        }

        function changeBlockToUser(block, id) {
            block.find('.removeButton').remove(); //удалить крестик

            block.attr('id', 'AllUsers' + id);

            var addContactButton = block.find('.button1');
            addContactButton.html('Добавить в контакты');
            addContactButton.attr("onclick", "addContact(" + id + ")");
        }

        function changeBlockToFriend(block, id) {
            var removeContactButton = $('<button/>');

            removeContactButton.addClass("removeButton");
            removeContactButton.html("x");
            removeContactButton.on("click", function () {
               removeContact(id);
            });

            block.prepend(removeContactButton);
            block.attr('id', 'Friend' + id);

            var writeMessageButton = block.find('.button1');
            writeMessageButton.html('Написать сообщение');
            writeMessageButton.attr("onclick", "");
        }
    </script>
</head>
<body>
<div class="container">


<#include "header.ftl">
<#include "menu.ftl">


    <div class="center-content">
        <div class="container">

            <div class="title">Контакты</div>

            <div style="float: right; margin-right: -30px; background-color: white;">
                <div style="position: fixed">
                    <a href="#friends_list" class="button">
                        <div class="button_text">Друзья</div>
                    </a>
                    <a href="#all_users_list" class="button">
                        <div class="button_text">Все</div>
                    </a>
                </div>
            </div>

            <div id="friends_list">
            <#list Friends as user>
                <div id="Friend${user.getId()}">
                    <button class="removeButton" onclick="removeContact(${user.getId()})">x</button>
                    <div style="overflow: hidden">
                        <img class="user-avatar" src="../images/avatars/no_photo2.png" alt="${user.getName()}"/>

                        <a class="jetton" href="/user/${user.getId()}">
                            <div class="user-info" style="font-size: 30px">${user.getName()}</div>
                            <div class="user-info" style="font-size: 20px">${user.getDOB()}</div>
                            <div class="user-info"
                                 style="font-size: 20px; float: right">${user.getPhoneNumber()}</div>
                            <div class="user-info"> ${user.getCity()}</div>
                        </a>

                        <div style="float: right">
                            <button class="button1">Написать сообщение</button>
                        </div>
                    </div>
                    <div class="divider"></div>
                </div>
            </#list>
            </div>

            <div style="margin-top: 30px; margin-bottom: 30px" class="title">Поисковики</div>

            <div id="all_users_list">
            <#list Users as user>
                <div id="AllUsers${user.getId()}">
                    <div style="overflow: hidden">
                        <img class="user-avatar" src="../images/avatars/no_photo2.png" alt="${user.getName()}"/>

                        <a class="jetton" href="/user/${user.getId()}">
                            <div class="user-info" style="font-size: 30px">${user.getName()}</div>
                            <div class="user-info" style="font-size: 20px">${user.getDOB()}</div>
                            <div class="user-info" style="font-size: 20px; float: right">${user.getPhoneNumber()}</div>
                            <div class="user-info"> ${user.getCity()}</div>
                        </a>

                        <div style="float: right">
                            <button onclick="addContact(${user.getId()})" class="button1">Добавить в контакты</button>
                        </div>
                    </div>
                    <div class="divider"></div>
                </div>
            </#list>
            </div>
            <div style="text-align: center">На сайте ${Users?size} поисковиков</div>
        </div>
    </div>
</div>
</body>
</html>