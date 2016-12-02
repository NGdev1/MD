/**
 * Created by Михаил on 01.12.2016.
 */

    function initMap() {
        // Create a map object and specify the DOM element for display.
        var map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: 55.814331, lng:  49.103508},
            scrollwheel: false,
            zoom: 8
        });
    }

