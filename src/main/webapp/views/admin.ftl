<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Админ</title>

    <link href="/css/singin.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">

    <!-- jQuery -->
    <script src="/js/jquery.min.js"></script>

    <script type="text/javascript">
        function deleteUser(id) {
            $.ajax({
                url: "/admin?action=delete&id=" + id,
                type: "GET"
            }).done(function () {
                document.getElementById(id).remove();
            });
        }
    </script>
</head>
<body>

<div class="container">

<#include "header.ftl">
    <div class="center-content">
    <#list Users as user>
        <div style="margin-bottom: 10px" id="${user.getId()}" onclick="deleteUser(this.id)">${user_index + 1}) ${user}</div>
    </#list>
    </div>

</div>

</body>
</html>