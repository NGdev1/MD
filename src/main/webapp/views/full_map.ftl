<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

    <title>Full Map</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/menu.css" rel="stylesheet">
    <link href="/css/singin.css" rel="stylesheet">
    <link href="/css/fullmap.css" rel="stylesheet">

    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>

<div id="map"></div>

<div class="container">

<#include "header.ftl">
<#include "menu.ftl">

    <form id="add_point_form">
        <div class="title">Добавить точку</div>
        <label for="name">Название:</label>
        <input class="form-control" id="name" type="text" name="name">

        <label>Координаты:
        <input class="form-control" id="lat" type="text" name="lat">
        <input class="form-control" id="lon" type="text" name="lon">
        </label>
        <input style="margin-top: 15px" class="button" type="submit" value="Добавить">
    </form>

    <script type="text/javascript" src="/js/map.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBbByzdPWzdq1FU3u9vrOWcjOUpPaGJfMA&callback=initMap"
            async defer></script>
</div>

</body>
</html>