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
	    	height: 500px; /* The height is 400 pixels */
	    	width: 100%; /* The width is the width of the web page */
		}
		#info {
	    	height: 500px; /* The height is 400 pixels */
	    	width: 30%; /* The width is the width of the web page */
		}
		

		.mySlides {display:none}
		.w3-left, .w3-right, .w3-badge {cursor:pointer}
		.w3-badge {height:13px;width:13px;padding:0}


.price-tag {
  background-color: #4285F4;
  border-radius: 8px;
  color: #FFFFFF;
  font-size: 14px;
  padding: 10px 15px;
  position: relative;
}

.price-tag::after {
  content: "";
  position: absolute;
  left: 50%;
  top: 100%;
  transform: translate(-50%, 0);
  width: 0;
  height: 0;
  border-left: 8px solid transparent;
  border-right: 8px solid transparent;
  border-top: 8px solid #4285F4;
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
		
			<p> <b> <%=nombre%> </b> </p>
			
			<div class="w3-panel w3-white w3-card w3-display-container">
				<p></p>
				<div class="w3-cell-row">
	 		
	 				<div id="info" class="w3-container w3-light-grey w3-cell">
					<!--Aqui va la info -->
						<% if (estaciones != null && !estaciones.isEmpty()) { %>
	                        <% for (int i = 0; i < estaciones.size(); i++) { 
	                            EstacionJB estacion = estaciones.get(i); %>
	                            <div class="mySlides" style="display: none;">
	                                <h3><%= estacion.get_nombre() %></h3>
	                                <p>Latitud: <%= estacion.get_latitud() %></p>
	                                <p>Longitud: <%= estacion.get_longitud() %></p>
	                                <p>Descripción: <%= estacion.get_descripcion() %></p>
	                            </div>
	                        <% } %>
	                    <% } %>
	 				</div>
	 				
	 				<div class="w3-light-grey w3-cell">
	 					<div id="map" class="w3-container">
						<!--Aqui va el mapa --> 
	 					</div>
	 					<div id="navbar" class="w3-center w3-container w3-large w3-blue" style="width:100%">
<!-- 						  <div class=" " style="width:100%"> -->
						    <button class="w3-button w3-left" onclick="plusDivs(-1)">&#10094; Prev</button>
  							<button class="w3-button w3-right" onclick="plusDivs(1)">Next &#10095;</button>
  							<% for (int i = 0; i < estaciones.size(); i++) { %>
                            	<button class="w3-button demo" onclick="currentDiv(<%= i + 1 %>)"><%= i + 1 %></button>
                        	<% } %>
<!-- 						  </div> -->
	 					</div>
	 					
	 				</div>
	    		</div>
	    		<p></p>
	    	
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
  var slideIndex = 0;

  //Cargamos las estaciones 
  const estaciones = [
      <% if (estaciones != null && !estaciones.isEmpty()) { %>
          <% for (int i = 0; i < estaciones.size(); i++) { 
              EstacionJB estacion = estaciones.get(i); %>
              {
                  nombre: "<%= estacion.get_nombre() %>",
                  numero: <%= estacion.get_numero() %>,        
                  latitud: <%= estacion.get_latitud() %>,
                  longitud: <%= estacion.get_longitud() %>
              }<%= (i < estaciones.size() - 1) ? "," : "" %>
          <% } %>
      <% } %>
  ];
  
  async function initMap() {
    // The location of Uluru
    const position = { lat: -25.344, lng: 131.031 };
    
    //Si no hay senderos mostramos una posicion inicial predefinida
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

    // Configuracion del mapa
    const zoom = 18
    map = new Map(document.getElementById("map"), {

      zoom: zoom,
      minZoom: zoom - 1,
      maxZoom: zoom + 2,
      gestureHandling: "cooperative",

      center: initialPosition,
      mapId: "DEMO_MAP_ID",
      //disableDefaultUI: true,
      streetViewControl: false,
      mapTypeControl: true,
      zoomControl: true,

    });

    estaciones.forEach(estacion => {
    	
    	//const priceTag = document.createElement("div");
    	//priceTag.className = "price-tag";
    	//priceTag.textContent = "#"+estacion.numero;
        new AdvancedMarkerElement({
            map: map,
            position: { lat: estacion.latitud, lng: estacion.longitud },
            title: estacion.nombre,
            //content:priceTag,
        });
    });
    
	//Variable para el control del slide
	slideIndex = 1;
	showDivs(slideIndex);
  }

  initMap();
  
 
 	//Funcion para centrar el mapa a un punto en especifico 
	function centerMap(lat, lng) {
            map.panTo({ lat: lat, lng: lng });
    }

	//Funcion para aumentar el indice del slide
	function plusDivs(n) {
	  showDivs(slideIndex += n);
	}
	
	//Funcion para ir a un indice del slide en especifico
	function currentDiv(n) {
	  showDivs(slideIndex = n);
	}

	//Funcion para mostrar la informacion del slide actual en
	//el div de informacion
	function showDivs(n) {
	  var i;
	  var x = document.getElementsByClassName("mySlides");
	  var dots = document.getElementsByClassName("demo");
	  if (n > x.length) {slideIndex = 1}
	  if (n < 1) {slideIndex = x.length}
	  for (i = 0; i < x.length; i++) {
	    x[i].style.display = "none";  
	  }
	  for (i = 0; i < dots.length; i++) {
	    dots[i].className = dots[i].className.replace(" w3-white", "");
	  }
	  x[slideIndex-1].style.display = "block";  
	  dots[slideIndex-1].className += " w3-white";
	  
	  const estacion = estaciones[slideIndex - 1];
      centerMap(estacion.latitud, estacion.longitud);
	}
</script>

	
	</body>
</html>