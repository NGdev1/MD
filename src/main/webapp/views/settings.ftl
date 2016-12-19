<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Настройки</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/menu.css" rel="stylesheet">
    <link href="/css/singin.css" rel="stylesheet">
    <link href="/css/profile.css" rel="stylesheet">
    <link href="/css/fullmap.css" rel="stylesheet">


    <script src="/js/jquery.min.js"></script>
    <script src="/js/settings.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#dolshnost option[value=${user.getDolshnost()}]').prop('selected', 'true');
        });

        var toggleTime = 400;

        function showChangePasswordForm() {
            $('#change_profile_form').hide(toggleTime);
            $('#add_expedition_form').hide(toggleTime);
            $('#change_password_form').show(toggleTime);
        }

        function showChangeProfileForm() {
            $('#add_expedition_form').hide(toggleTime);
            $('#change_password_form').hide(toggleTime);
            $('#change_profile_form').show(toggleTime);
        }

        function showAddExpeditionForm() {
            $('#change_profile_form').hide(toggleTime);
            $('#change_password_form').hide(toggleTime);
            $('#add_expedition_form').show(toggleTime);
        }
    </script>
</head>
<body>
<div class="container">

<#include "header.ftl">
<#include "menu.ftl">
    <div class="center-content">
        <div class="container">

            <div id="change_profile_form">
                <div class="title">Настройки профиля</div>
                <div class="white-container">

                    <form action="/image_load/${user.getId()}" method="post" enctype="multipart/form-data">

                        <div class="center">
                        <img class="user-avatar" style="float: none" src="/upload/${user.getImage()}"/>
                        </div>

                        <input class="center" name="image" type="file" accept="image/jpeg,image/png">

                        <input class="button center" type="submit" value="Отправить">
                    </form>

                    <form action="/settings" method="post">
                        <input name="action" value="change_profile" type="hidden">

                        <div class="user-info-text">
                            <input placeholder="Имя:"
                                   class="input_green" name="login" value="${user.getName()}"/>

                            <input placeholder="Фамилия:"
                                   class="input_green" name="surname" value="${user.getSurname()}"/>

                            <input placeholder="Отчество:"
                                   class="input_green" name="patronymic"
                                   value="${user.getPatronymic()}"/>

                            <input placeholder="Телефон:" class="input_green" type="tel" name="tel"
                                   value="${user.getPhoneNumber()}"/>

                            <input placeholder="@Mail:" class="input_green" name="mail" value="${user.getEmail()}"/>

                            <select id="dolshnost" class="input_green" name="dolshnost" title="">
                                <option value="No">Должность...</option>
                                <option value="Kom">"Командир"</option>
                                <option value="ZKom">"Зам. Ком."</option>
                                <option value="ZSklad">"Зав.Складом"</option>
                                <option value="NProd">"Нач.Прод."</option>
                                <option value="S">"Боец"</option>
                            </select>
                        </div>
                        <input class="button1" type="submit" value="Сохранить"/>
                    </form>
                </div>

            </div>

            <form id="change_password_form" action="/settings" method="post" style="display: none">
                <div class="title">Сменить пароль</div>

                <input placeholder="Пароль:" class="input_green" name="text"/>
                <input placeholder="Повторите пароль:" class="input_green" name="text"/>

                <input type="submit" class="button1" value="Сменить пароль"/>
            </form>

            <form id="add_expedition_form" action="/settings" method="post" style="display: none">
                <div class="title">Добавить экспедицию</div>

                <input class="input_green" type="text" name="name" placeholder="Название:"/>

                <div id="squads_container">

                </div>

                <input class="input_green" type="text" name="squads" placeholder="Отряды.."/>

                <div style="height: 0">
                    <div id="squads_offer_list_container" class="offer_list">

                    </div>
                </div>

                <input class="input_green" type="text" name="place" placeholder="место проведения экспедиции"/>

                <div id="participants_container">

                </div>

                <input class="input_green" type="text" name="participants" placeholder="Участники.."/>

                <div style="height: 0">
                    <div id="participants_offer_list_container" class="offer_list">

                    </div>
                </div>

                <input type="submit" class="button1" value="Добавить"/>
            </form>

            <br/>
            <br/>
            <button onclick="showChangeProfileForm()" class="button1">Профиль</button>
            <button onclick="showChangePasswordForm()" class="button1">Сменить пароль</button>
            <button onclick="showAddExpeditionForm()" class="button1">Добавить экспедицию</button>
        </div>
    </div>

    <script type="text/javascript">
        var squads = [];
        var participants = [];

        function find(array, value) {

            for (var i = 0; i < array.length; i++) {
                if (array[i] == value) return i;
            }

            return -1;
        }

        function removeParticipant(id) {
            delete participants[find(participants, id)];

            var containerParticipants = $('#participants_container');
            containerParticipants.find('div[participantid=' + id + ']').hide();
        }

        function removeSquad(id) {
            delete squads[find(squads, id)];

            var containerSquads = $('#squads_container');
            containerSquads.find('div[squadid=' + id + ']').hide();
        }

        function addSquad(id, name) {
            if (find(squads, id) != -1) return;

            squads.push(id);

            var containerSquads = $('#squads_container');

            var squad = $('<div/>', {
                text: name,
                squadId: id,
                'class': 'selected_item'
            });

            var removeButton = $('<button/>', {
                'class': 'removeButton',
                'onclick': 'removeSquad(' + id + ')',
                'type': 'button',
                text: 'x'
            });

            squad.prepend(removeButton);
            containerSquads.prepend(squad);
        }

        function addParticipant(id, name, image) {
            if (find(participants, id) != -1) return;

            participants.push(id);

            var containerParticipants = $('#participants_container');

            var jetton = $('<a/>', {
                'class': 'jetton_little',
                'href': '/user/' + id,
                text: name
            });

            var participant = $('<div/>', {
                participantid: id,
                'class': 'selected_item'
            });

            var avatarka = $('<img/>', {
                src: "/upload/" + image,
                'class': 'offer_list_image'
            });

            var removeButton = $('<button/>', {
                'class': 'removeButton',
                'onclick': 'removeParticipant(' + id + ')',
                'type': 'button',
                text: 'x'
            });

            participant.append(removeButton);
            participant.append(avatarka);
            participant.append(jetton);
            containerParticipants.prepend(participant);
        }

        $(document).ready(function () {
            var inputSquads = $('input[name=squads]');
            var inputParticipants = $('input[name=participants]');
            var listSquads = $('#squads_offer_list_container');
            var listParticipants = $('#participants_offer_list_container');

            listSquads.hide();
            listParticipants.hide();

            function updateListParticipants() {
                if (inputParticipants.val() == '') {
                    hideListParticipants();
                    return;
                }

                $.ajax({
                    url: "/getJson?action=get_users&query=" + inputParticipants.val()
                }).done(function (data) {
                    listParticipants.html('');

                    var result = JSON.parse(data);
                    var needToShow = false;

                    if (result.length == 0) {
                        listParticipants.hide(500);
                        return;
                    } else if (listParticipants.html() == '') {
                        needToShow = true;
                    }

                    for (var i = 0; i < result.length; i++) {
                        var line = $('<div/>', {
                            text: result[i].name,
                            onclick: 'addParticipant(' + result[i].id + ',\'' + result[i].name + '\',\'' + result[i].image + '\')',
                            'class': 'offer_list_item'
                        });

                        listParticipants.prepend(line);
                    }

                    if (needToShow) {
                        listParticipants.show(300);
                    }
                });
            }

            function updateListSquads() {
                if (inputSquads.val() == '') {
                    hideListSquads();
                    return;
                }

                $.ajax({
                    url: "/getJson?action=get_squads&query=" + inputSquads.val()
                }).done(function (data) {
                    listSquads.html('');

                    var result = JSON.parse(data);
                    var needToShow = false;

                    if (result.length == 0) {
                        listSquads.hide(500);
                        return;
                    } else if (listSquads.html() == '') {
                        needToShow = true;
                    }

                    for (var i = 0; i < result.length; i++) {
                        var line = $('<div/>', {
                            text: result[i].name,
                            onclick: 'addSquad(' + result[i].id + ',\'' + result[i].name + '\')',
                            'class': 'offer_list_item'
                        });

                        listSquads.prepend(line);
                    }

                    if (needToShow) {
                        listSquads.show(300);
                    }
                });
            }

            function hideListSquads() {
                listSquads.hide(400);
            }

            function hideListParticipants() {
                listParticipants.hide(400);
            }

            inputSquads.focusout(function (e) {
                hideListSquads();
                inputSquads.val('');
            });

            inputSquads.keyup(function (e) {
                updateListSquads();
            });

            inputParticipants.focusout(function (e) {
                hideListParticipants();
                inputParticipants.val('');
            });

            inputParticipants.keyup(function (e) {
                updateListParticipants();
            });
        });
    </script>
</body>
