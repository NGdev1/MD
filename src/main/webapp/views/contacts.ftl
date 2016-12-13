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
                        friendsList.append(newFriend);

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
                        allUsersList.append(friendToDelete);

                        friendToDelete.show(animationTime);
                    })
                }
                else {
                    alert(data);
                }
            });
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

            <div id="friends_list">
            <#list Friends as user>
                <div id="Friend${user.getId()}">
                    <div style="overflow: hidden">
                        <div style="height: 0"><button style="margin: 0; float:right; font-size: 20px; background: none; border: none;" onclick="removeContact(${user.getId()})">x</button></div>

                        <img class="user-avatar" src="../images/no_photo2.png" alt="${user.getName()}"/>

                        <a class="jetton" href="/user/${user.getId()}">
                            <div class="user-info" style="font-size: 30px">${user.getName()}</div>
                            <div class="user-info" style="font-size: 20px">${user.getDOB()}</div>
                            <div class="user-info" style="font-size: 20px; float: right">${user.getPhoneNumber()}</div>
                            <div class="user-info"> ${user.getCity()}</div>
                        </a>

                        <button style="font-size: 15px; float: right; margin-top: 30px"
                                class="button1">Написать сообщение
                        </button>
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
                        <img class="user-avatar" src="../images/no_photo2.png" alt="${user.getName()}"/>

                        <a class="jetton" href="/user/${user.getId()}">
                            <div class="user-info" style="font-size: 30px">${user.getName()}</div>
                            <div class="user-info" style="font-size: 20px">${user.getDOB()}</div>
                            <div class="user-info" style="font-size: 20px; float: right">${user.getPhoneNumber()}</div>
                            <div class="user-info"> ${user.getCity()}</div>
                        </a>

                        <button onclick="addContact(${user.getId()})"
                                style="font-size: 15px; float: right; margin-top: 30px" class="button1">Добавить в
                            контакты
                        </button>
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