<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%@include file="header.jsp"  %>

<div id="map"></div>
<p id="sum"></p>

	<form class="boutonIncident" action="home" class="formhome">
		<label for="competence1">Entrez ces champs pour signaler un incident</label>
               <select name="competence1" id="competence1">
    				<option value="1">Incendie</option>
    				<option value="2">Accident routier</option>
    				<option value="3">Accident fluvial</option>
    				<option value="4">Eboulement</option>
    				<option value="5">Invasion de serpent</option>
    				<option value="6"> Fuite de gaz</option>
    				<option value="7">Manifestation</option>
    				<option value="8"> Braquage</option>
    				<option value="9">Evasion d’un prisonnier</option>
				</select>
				<input id="lon" type="text"></input>
				<input id="lat" type="text"></input>
		<input type="submit" value="Déclarer un incident"></input>
	</form>

<script type="text/javascript">
var map = L.map('map');
map.setView([43.528327, 5.448446], 10);

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);

var theMarker = {};
var circle = {};
const radiusCircle = 5000;

map.on('click',function(e){
  lat = e.latlng.lat;
  lon = e.latlng.lng;
 
	if (theMarker != undefined) {
    	map.removeLayer(theMarker);
        //map.removeLayer(theCircle);
      };

   theMarker = L.marker([lat,lon]).addTo(map);
   //theCircle = L.circle(e.latlng, radiusCircle)addTo(map);
document.getElementById("lon").value = lon;
document.getElementById("lat").value = lat;
});
map.on('click', onMapClick);

</script>
</body>
</html>