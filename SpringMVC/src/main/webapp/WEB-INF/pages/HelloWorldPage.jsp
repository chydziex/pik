<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

 <head>
         <title>Mapa Bydgoszczy- Hello World</title>
         <link rel="stylesheet" href="http://192.168.162.224:8080/geoserver/openlayers/theme/default/style.css" type="text/css">
         <style>
                 #map-id {
                         width: 828px;
                         height: 500px;
			border: 1px solid black;
                 }
         </style>
         <script src="http://openlayers.org/api/2.11/OpenLayers.js"></script>
 </head>
 <body>
	<h1>Spring MVC Hello World + Openlayers wyswietlajace mape Bygdoszczy Hello World</h1>

	<h2>${msg}</h2>


   
         <div id="map-id"></div>
         <script>
                 var bounds = new OpenLayers.Bounds(
                        1987636.5,6999269.0,2020152.625,7044662.5
                        
                 );

                 var options = {
                                 controls: [],
                                 maxExtent: bounds,
                                 maxResolution: 70.86181640625 ,
                                 projection: "EPSG:900913",
                                 units: 'm'
                 };

                 map = new OpenLayers.Map('map-id', options);

                 var ccounties = new OpenLayers.Layer.WMS(
                                 "Counties of Colorado - Untiled", "http://192.168.162.224:8080/geoserver/wms",
                                 {
                                         srs: 'EPSG:900913',
                                         layers: 'test',
                                         styles: '',
                                         format:'image/png'
                                 },
                                 {singleTile: true, ratio: 1}
                 );

                 map.addLayer(ccounties);

                 // build up all controls
                 map.addControl(new OpenLayers.Control.PanZoomBar({
                         position: new OpenLayers.Pixel(2, 15)
                 }));
                 map.addControl(new OpenLayers.Control.Navigation());
                 map.addControl(new OpenLayers.Control.Scale());
                 map.addControl(new OpenLayers.Control.MousePosition());
                 map.zoomToExtent(bounds);

         </script>
        </body>


</html>