<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="modelo.UsuarioJB"%>
<%@ page import="modelo.SenderoJB"%>
<%@ page import="modelo.EstacionJB"%>
<!DOCTYPE html>

<html>

	<head>
		<title>SendinaUV</title>
	</head>
	<style>
		#map {
	    	height: 400px; /* The height is 400 pixels */
	    	width: 100%; /* The width is the width of the web page */
		}
	</style>

	<body class="w3-theme-l4">

		<%@ include file="header_01.jsp" %>
		
		
		<%
			int id_sendero = 0;
			String nombre = "Sendero nombre ejemplo";
			String sede = "Sendero sede ejemplo";
			String year = "2024-04-11";
			int zona = 1;
			String url_recursos = "Inserte URL aqui";
			
			SenderoJB sendero = (SenderoJB) request.getAttribute("sendero");
			if (sendero != null) {
				id_sendero = sendero.get_id_sendero();
				nombre = sendero.get_nombre();
				sede = sendero.get_sede();
				
				Date date = sendero.get_year();
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        year = sdf.format(date);
		        
		        zona = sendero.get_id_zona();
				url_recursos = sendero.get_url_recursos();
				
			}
			
			
			@SuppressWarnings("unchecked")
			List<EstacionJB> estaciones = (List<EstacionJB>) request.getAttribute("estaciones");
			
			if (estaciones != null && !estaciones.isEmpty() ) {
				for (EstacionJB estacion : estaciones) {

					estacion.get_nombre();
					estacion.get_latitud();
					estacion.get_longitud();
				}
			}
			else {
				out.print("Este sendero no tiene estaciones");
			}

    	
		%>
		
		<div class="w3-container w3-content">
		


		
		<div class="w3-panel w3-white w3-card w3-display-container">
 		
 				<p> <%=nombre%> </p>
 				
 				<div id="map">
				<!--Aqui va el mapa -->
 				</div>
		
    	</div>
    		
    </div>


<script>
  (g=>{var h,a,k,p="The Google Maps JavaScript API",c="google",l="importLibrary",q="__ib__",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement("script"));e.set("libraries",[...r]+"");for(k in g)e.set(k.replace(/[A-Z]/g,t=>"_"+t[0].toLowerCase()),g[k]);e.set("callback",c+".maps."+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+" could not load."));a.nonce=m.querySelector("script[nonce]")?.nonce||"";m.head.append(a)}));d[l]?console.warn(p+" only loads once. Ignoring:",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})({
    key: "AIzaSyANYrOfEcKN46yxrjSmY6JTjXLlpXKBK7w",
    v: "weekly",
    // Use the 'v' parameter to indicate the version to use (weekly, beta, alpha, etc.).
    // Add other bootstrap parameters as needed, using camel case.
  });
  
  
  
  let map;

  const estaciones = [
      <% if (estaciones != null && !estaciones.isEmpty()) { %>
          <% for (int i = 0; i < estaciones.size(); i++) { 
              EstacionJB estacion = estaciones.get(i); %>
              {
                  nombre: "<%= estacion.get_nombre() %>",
                  latitud: <%= estacion.get_latitud() %>,
                  longitud: <%= estacion.get_longitud() %>
              }<%= (i < estaciones.size() - 1) ? "," : "" %>
          <% } %>
      <% } %>
  ];
  
  async function initMap() {
    // The location of Uluru
    const position = { lat: -25.344, lng: 131.031 };
    
    let initialPosition;
    if (estaciones.length > 0) {
        initialPosition = { lat: estaciones[0].latitud, lng: estaciones[0].longitud };
    } else {
        initialPosition = { lat: -25.344, lng: 131.031 };
    }
    
    // Request needed libraries.
    //@ts-ignore
    const { Map } = await google.maps.importLibrary("maps");
    const { AdvancedMarkerElement } = await google.maps.importLibrary("marker");

    // The map, centered at Uluru
    map = new Map(document.getElementById("map"), {
      zoom: 18,
      center: initialPosition,
      mapId: "DEMO_MAP_ID",
      //disableDefaultUI: true,
      streetViewControl: false,
      mapTypeControl: false,
      zoomControl: true,
    });

    estaciones.forEach(estacion => {
        new AdvancedMarkerElement({
            map: map,
            position: { lat: estacion.latitud, lng: estacion.longitud },
            title: estacion.nombre
        });
    });
  }

  initMap();

</script>

	
	</body>
</html>