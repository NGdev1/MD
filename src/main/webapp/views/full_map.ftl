<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

    <title>Full Map</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/menu.css" rel="stylesheet">

    <script type="text/javascript" src="/js/jquery.min.js"></script>

    <style>
        .map-control {
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 2px 2px rgba(33, 33, 33, 0.4);
            font-family: 'Roboto', 'sans-serif';
            margin: 10px;
            /* Hide the control initially, to prevent it from appearing
               before the map loads. */
            display: none;
        }

        /* Display the control once it is inside the map. */
        #map .map-control {
            display: block;
        }

        .selector-control {
            font-size: 14px;
            line-height: 30px;
            padding-left: 5px;
            padding-right: 5px;
        }
    </style>
</head>
<body>

<div id="map"></div>

<div class="container">

<#include "header.ftl">
<#include "menu.ftl">

    <script type="text/javascript" src="/js/map.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBbByzdPWzdq1FU3u9vrOWcjOUpPaGJfMA&signed_in=true&callback=initMap"
            async defer></script>
</div>

</body>
</html>