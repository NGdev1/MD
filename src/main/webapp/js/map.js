/**
 * Created by Михаил on 01.12.2016.
 */

var retro = [
    {elementType: 'geometry', stylers: [{color: '#ebe3cd'}]},
    {elementType: 'labels.text.fill', stylers: [{color: '#523735'}]},
    {elementType: 'labels.text.stroke', stylers: [{color: '#f5f1e6'}]},
    {
        featureType: 'administrative',
        elementType: 'geometry.stroke',
        stylers: [{color: '#c9b2a6'}]
    },
    {
        featureType: 'administrative.land_parcel',
        elementType: 'geometry.stroke',
        stylers: [{color: '#dcd2be'}]
    },
    {
        featureType: 'administrative.land_parcel',
        elementType: 'labels.text.fill',
        stylers: [{color: '#ae9e90'}]
    },
    {
        featureType: 'landscape.natural',
        elementType: 'geometry',
        stylers: [{color: '#dfd2ae'}]
    },
    {
        featureType: 'poi',
        elementType: 'geometry',
        stylers: [{color: '#dfd2ae'}]
    },
    {
        featureType: 'poi',
        elementType: 'labels.text.fill',
        stylers: [{color: '#93817c'}]
    },
    {
        featureType: 'poi.park',
        elementType: 'geometry.fill',
        stylers: [{color: '#a5b076'}]
    },
    {
        featureType: 'poi.park',
        elementType: 'labels.text.fill',
        stylers: [{color: '#447530'}]
    },
    {
        featureType: 'road',
        elementType: 'geometry',
        stylers: [{color: '#f5f1e6'}]
    },
    {
        featureType: 'road.arterial',
        elementType: 'geometry',
        stylers: [{color: '#fdfcf8'}]
    },
    {
        featureType: 'road.highway',
        elementType: 'geometry',
        stylers: [{color: '#f8c967'}]
    },
    {
        featureType: 'road.highway',
        elementType: 'geometry.stroke',
        stylers: [{color: '#e9bc62'}]
    },
    {
        featureType: 'road.highway.controlled_access',
        elementType: 'geometry',
        stylers: [{color: '#e98d58'}]
    },
    {
        featureType: 'road.highway.controlled_access',
        elementType: 'geometry.stroke',
        stylers: [{color: '#db8555'}]
    },
    {
        featureType: 'road.local',
        elementType: 'labels.text.fill',
        stylers: [{color: '#806b63'}]
    },
    {
        featureType: 'transit.line',
        elementType: 'geometry',
        stylers: [{color: '#dfd2ae'}]
    },
    {
        featureType: 'transit.line',
        elementType: 'labels.text.fill',
        stylers: [{color: '#8f7d77'}]
    },
    {
        featureType: 'transit.line',
        elementType: 'labels.text.stroke',
        stylers: [{color: '#ebe3cd'}]
    },
    {
        featureType: 'transit.station',
        elementType: 'geometry',
        stylers: [{color: '#dfd2ae'}]
    },
    {
        featureType: 'water',
        elementType: 'geometry.fill',
        stylers: [{color: '#b9d3c2'}]
    },
    {
        featureType: 'water',
        elementType: 'labels.text.fill',
        stylers: [{color: '#92998d'}]
    }
];

var marker;

function addLocation(lat, lng){
    alert(lat.toString() + " " + lng.toString())
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
        'Error: The Geolocation service failed.' :
        'Error: Your browser doesn\'t support geolocation.');
}

function initMap() {
    // Create a map object and specify the DOM element for display.
    var map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 55.814331, lng: 49.103508},
        scrollwheel: true,
        zoom: 10,
        mapTypeControlOptions: {
            mapTypeIds: [
                google.maps.MapTypeId.ROADMAP,
                google.maps.MapTypeId.SATELLITE
            ],
            position: google.maps.ControlPosition.BOTTOM_LEFT
        }
    });

    addUserLocationOnMap(map);

    map.setOptions({styles: retro});

    map.addListener('click', function (e) {

        if (marker != null) {
            marker.setMap(null);
            marker = null
        }

        marker = new google.maps.Marker({
            map: map,
            // Define the place with a location, and a query string.
            place: {
                location: e.latLng,
                query: 'Казань'

            },
            // Attributions help users find your site again.
            attribution: {
                source: 'Google Maps JavaScript API',
                webUrl: 'https://developers.google.com/maps/'
            }
        });

        // Construct a new InfoWindow.
        var infoWindow = new google.maps.InfoWindow({
            content: '<button onclick="addLocation' + e.latLng.toString() + '" class="button menu_button_text" style="margin: auto">Добавить точку</button>' +
            'Координаты:' +
            '<br/>' + e.latLng
        });

        // Opens the InfoWindow when marker is clicked.
        marker.addListener('click', function () {
            map.panTo(e.latLng);
            infoWindow.open(map, marker);
        });

        map.panTo(e.latLng);
        infoWindow.open(map, marker);
    });

    function addUserLocationOnMap(map){
        // Construct a new InfoWindow.

        // Try HTML5 geolocation.
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
                var pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };

                var markerUserLocation = new google.maps.Marker({
                    map: map,
                    // Define the place with a location, and a query string.
                    place: {
                        location: pos,
                        query: 'Казань'

                    },
                    // Attributions help users find your site again.
                    attribution: {
                        source: 'Google Maps JavaScript API',
                        webUrl: 'https://developers.google.com/maps/'
                    }
                });

                var infoWindow = new google.maps.InfoWindow({
                    content: 'Ваша позиция:<br/>' +
                    '<button onclick="addLocation' + pos.lat.toString() + '" class="button menu_button_text" style="margin: auto">Добавить точку</button>' +
                    'Координаты:' +
                    '<br/>' + e.latLng
                });

                // Opens the InfoWindow when marker is clicked.
                markerUserLocation.addListener('click', function () {
                    map.panTo(e.latLng);
                    infoWindow.open(map, markerUserLocation);
                });

                infoWindow.setPosition(pos);
                infoWindow.setContent('Location found.');
                map.setCenter(pos);
            }, function() {
                handleLocationError(true, infoWindow, map.getCenter());
            });
        } else {
            // Browser doesn't support Geolocation
            handleLocationError(false, infoWindow, map.getCenter());
        }
    }
}





