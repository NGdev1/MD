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

            <form id="change_profile_form" class="news_item" action="/settings" method="post">
                <div class="title">Настройки профиля</div>
                <div style="height: 0"><img src="../images/no_photo2.png"/></div>

                <input name="action" value="change_profile" type="hidden">
                <input placeholder="Имя:"
                       class="input_green user-info-settings" name="login" value="${user.getName()}"/>

                <input placeholder="Фамилия:"
                       class="input_green user-info-settings" name="surname" value="${user.getSurname()}"/>

                <input placeholder="Отчество:"
                       class="input_green user-info-settings" name="patronymic" value="${user.getPatronymic()}"/>

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

                <input class="button1" type="submit" value="Сохранить"/>

            </form>

            <form id="change_password_form" class="news_item" action="/settings" method="post" style="display: none">
                <div class="title">Сменить пароль</div>

                <input placeholder="Пароль:" class="input_green" name="text"/>
                <input placeholder="Повторите пароль:" class="input_green" name="text"/>

                <input type="submit" class="button1" value="Сменить пароль"/>
            </form>

            <form id="add_expedition_form" class="news_item" action="/settings" method="post" style="display: none">
                <div class="title">Добавить экспедицию</div>

                <input class="input_green" type="text" name="name" placeholder="Название:"/>
                <input class="input_green" type="text" name="komandor" placeholder="Командир:"/>
                <input class="input_green" type="text" name="zam" placeholder="Зам. Командира"/>

                <!--select id="otryad" style="height: 260px" class="input_green" name="otryad" multiple="multiple" title="">
                    <option value="Legion">"Легион" ТИСБИ г. Казань</option>
                    <option value="Himik">"Химик" КНИТУ-КХТИ г. Казань</option>
                    <option value="KP"> "Книга Памяти" КНИТУ-КАИ им.А.Н.Туполева г. Казань</option>
                    <option value="SD">"Снежный десант" КФУ г. Казань</option>
                    <option value="KS">"Красная стрела" ИЭУП г. Казань</option>
                    <option value="Vozrozhdenie">"Возрождение" г. Казань</option>
                    <option value="ZF">"Западный Фронт" г. Казань</option>
                    <option value="PT">"Поисковая тропа" КГЭУ г.Казань</option>
                    <option value="R">"Разведка" г. Казань</option>
                    <option value="SKIF">"СКИФ" ТГГПУ г. Казань</option>
                    <option value="R">"Поиск" МБОУ «Гимназия №96» г.Казань</option>
                    <option value="R">"Юные патриоты России" г. Казань</option>
                </select-->

                <input class="input_green" type="text" name="squads" placeholder="Отряды"/>
                <div style="height: 0;">
                <div id="squads_container" class="offer_list">

                </div>
                </div>

                <input class="input_green" type="text" name="place" placeholder="место проведения экспедиции"/>

                <select id="dolshnost" class="input_green" name="dolshnost" title="">
                    <option value="No">Участники...</option>
                    <option value="No">${user.getSurname()}  ${user.getName()}
                    </option>
                </select>

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
        $(document).ready(function () {
            var inputSquads = $('input[name=squads]');

            inputSquads.keyup(function (e) {
                $.ajax({
                    url: "/getJson?action=get_squads&query=" + inputSquads.val()
                }).done(function (data) {
                    $('#squads_container').html('');

                    var result = JSON.parse(data);

                    for(var i = 0; i < result.length; i++){
                        var line = $('<div/>',{
                            text: result[i].name
                        });

                        $('#squads_container').prepend(line);
                    }
                });
            });
        });
    </script>
</body>
