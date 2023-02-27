<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"  %>
<body>
<div id="map"></div>
<script type="text/javascript">var map = L.map('map');
map.setView([43.529742, 5.447427], 13);

L.tileLayer('https://tile.openstreetmap.org/%7Bz%7D/%7Bx%7D/%7By%7D.png', {
    maxZoom: 18,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright%22%3EOpenStreetMap</a>'
}).addTo(map);</script>
</body>
</html>