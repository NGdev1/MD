<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Full Map</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/menu.css" rel="stylesheet">

    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>

<div id="map"></div>

<div class="container">

<#include "header.ftl">
<#include "menu.ftl">

    <script type="text/javascript" src="/js/map.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBbByzdPWzdq1FU3u9vrOWcjOUpPaGJfMA&callback=initMap"
            async defer></script>
</div>

</body>
</html>