<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.UsuarioJB"%>
<%@ page import="modelo.SenderoJB"%>
<%@ page import="modelo.EstacionJB"%>
<%@ page import="modelo.RecursoJB"%>
<%@ page import="java.util.ArrayList;"%>
<!DOCTYPE html>

<html>

<head>
	<title>SendinaUV</title>
</head>
	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<style>
 	.row {
 		height: 92vh; 
 	}
	
	.map_card{
		width: 300px;
		height:auto,
	}
	
	#map {
		height: 100%;
		width: 100%;
	}
	
	#info {
		overflow-y: scroll;
		height: 100%;
		scrollbar-width: thin; 
		scrollbar-color: #888 #f0f0f0;
      }
</style>

<body>

 	<%@ include file="header_01.jsp" %>
	
	<%
		int id_sendero = 0;
		String nombre = "Sendero nombre ejemplo";
		String sede = "Sendero sede ejemplo";
		int year = 2024;
		int zona = 1;
		String url_recursos = "Inserte URL aqui";
		
		SenderoJB sendero = (SenderoJB) request.getAttribute("sendero");
		if (sendero != null) {
			id_sendero = sendero.get_id_sendero();
			nombre = sendero.get_nombre();
			sede = sendero.get_sede();
			year = sendero.get_year();
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
		
		<%--<p> <b> <%=nombre%> </b> </p> --%>
	<div class="row container-fluid no-gutters full-height">
 		
		<div id="info" class="col-4">
		<% 
		if (estaciones != null && !estaciones.isEmpty()) {
                     for (EstacionJB estacion : estaciones) {  
		%>
			<div class="slide" style="display: none;">
<%-- 			<h3><%= estacion.get_nombre() %></h3> --%>
<%-- 			<p>Latitud: <%= estacion.get_latitud() %></p> --%>
<%-- 			<p>Longitud: <%= estacion.get_longitud() %></p> --%>
<%-- 			<p><%= estacion.get_descripcion() %></p> --%>
			    <%
			    List<RecursoJB> recursos = (List<RecursoJB>) estacion.get_recursos();
			    for (RecursoJB recurso : recursos) {
			    	if (recurso.get_tipo_recurso().equals("Imagen")){
			    %>
			    	<img src="<%= recurso.get_url() %>" style="width:100%; ">
			    <% 
			    	}
			    	if (recurso.get_tipo_recurso().equals("Video")){
			    %>
			    	<video controls>
						<source src="<%= recurso.get_url() %>" type="video/mp4">
					</video>
			    <%
			    	}
			    }
			    %>
			</div>
		<%     
			} 
		}
		%>
		</div>
 				
		<div id="map_container" class="col">
		
			<div id="map" class="container-fluid">
				<!--Aqui va el mapa --> 
			</div>
			
		</div>
    </div>
 
    		


<script>

  (g=>{var h,a,k,p="The Google Maps JavaScript API",c="google",l="importLibrary",q="__ib__",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement("script"));e.set("libraries",[...r]+"");for(k in g)e.set(k.replace(/[A-Z]/g,t=>"_"+t[0].toLowerCase()),g[k]);e.set("callback",c+".maps."+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+" could not load."));a.nonce=m.querySelector("script[nonce]")?.nonce||"";m.head.append(a)}));d[l]?console.warn(p+" only loads once. Ignoring:",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})({
    key: "AIzaSyANYrOfEcKN46yxrjSmY6JTjXLlpXKBK7w",
    v: "weekly",
  });
  
  
  
  let map;
  let infoWindows = [];
  let markers = [];
  let currentInfoWindow = null;
  var slideIndex = 0;

  //Cargamos las estaciones 
  const estaciones = [
      <% if (estaciones != null && !estaciones.isEmpty()) { %>
          <% for (int i = 0; i < estaciones.size(); i++) { 
              EstacionJB estacion = estaciones.get(i); %>
              {
                  nombre: "<%= estacion.get_nombre() %>",
                  numero: <%= estacion.get_numero() %>,
                  descripcion: "<%= estacion.get_descripcion() %>",
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
    const { AdvancedMarkerElement, PinElement  } = await google.maps.importLibrary("marker");

    // Configuracion del mapa
    const zoom = 20
    map = new Map(document.getElementById("map"), {
      zoom: zoom,
      minZoom: zoom - 1,
      maxZoom: zoom + 2,
      gestureHandling: "cooperative",
      zoomControlOptions: {
          position: google.maps.ControlPosition.TOP_RIGHT,
      },
      center: initialPosition,
      mapId: "DEMO_MAP_ID",
      //disableDefaultUI: true,
      fullscreenControl: false,
      streetViewControl: false,
      mapTypeControl: true,
      mapTypeControlOptions: {style: google.maps.MapTypeControlStyle.DROPDOWN_MENU},
      mapTypeId: 'terrain',
      zoomControl: true,
    });
    
    const pathCoordinates = [];

    estaciones.forEach(estacion => {
    	const content = document.createElement('div');
        content.className = 'map_card';
        content.innerHTML = `
            <h4 class="text-primary">${estacion.nombre}</h4>
            <p class="text-secondary">${estacion.descripcion}</p>
        `;
          
        const infoWindow = new google.maps.InfoWindow({
        	headerContent: `Estacion #${estacion.numero}`,
          	//headerDisabled:true,
        	content: content,
        	ariaLabel: estacion.nombre,
        });
        infoWindows.push(infoWindow);
        
        const pin = new PinElement({
            //glyph: `${estacion.numero}`,
            glyphColor: '#FF7F50',
            scale: 1.2,
            background: '#FFD700',
            borderColor: '#FF7F50',
            
          });
    	
    	
        const marker = new AdvancedMarkerElement({
            map: map,
            position: { lat: estacion.latitud, lng: estacion.longitud },
            title: estacion.nombre,
            content: pin.element,
            //content:priceTag,
        });
        
        marker.addListener('click', () => {
            infoWindow.open({anchor: marker});
          });
        
        markers.push(marker);
        
     	//Agregamos el punto al path para dibujar el sendero
        pathCoordinates.push({ lat: estacion.latitud, lng: estacion.longitud });
    });
    
    //A dibujar
    const lineSymbol = {
	  path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW,
	  scale: 3,
	  strokeColor: '#002D62'
	};
    
    const trailPath = new google.maps.Polyline({
        path: pathCoordinates,
        icons: [{
            icon: lineSymbol,
            offset: '100%',
            repeat: '50px' 
          }],
        geodesic: true,
        strokeColor: '#7CB9E8',
        strokeOpacity: 0.4,
        strokeWeight: 15,
    });
    trailPath.setMap(map);
    
	//Variable para el control del slide
	slideIndex = 1;
	cambia_slide(slideIndex);
	
	//Controles adicionales
	//const controlesDiv = document.createElement("div");
	
	//Boton para sig. estacion
	const sig_btn = document.createElement("button");
	sig_btn.className = "btn btn-primary m-3";
	sig_btn.textContent = "Siguiente";
	sig_btn.title = "Cambiar siguiente";
	sig_btn.type = "button";
	sig_btn.addEventListener("click", () => {
		aumenta_indice(1);
	});
	
	//Boton para ant. estacion
	const ant_btn = document.createElement("button");
	ant_btn.className = "btn btn-primary m-3";
	ant_btn.textContent = "Anterior";
	ant_btn.title = "Cambiar anterior";
	ant_btn.type = "button";
	ant_btn.addEventListener("click", () => {
		aumenta_indice(-1);
	});

	//Agrego los controles al mapa
	//controlesDiv.appendChild(ant_btn);
	//controlesDiv.appendChild(sig_btn);
	map.controls[google.maps.ControlPosition.RIGHT_BOTTOM].push(sig_btn);
	map.controls[google.maps.ControlPosition.LEFT_BOTTOM].push(ant_btn);

  }

  initMap();
 
 	//Funcion para centrar el mapa a un punto en especifico 
	function centrar_mapa(lat, lng) {
		map.panTo({ lat: lat, lng: lng });
	}

	//Funcion para aumentar el indice del slide
	function aumenta_indice(n) {
		cambia_slide(slideIndex += n);
	}
	
	//Funcion para ir a un indice del slide en especifico
	function marcar_indice(n) {
		cambia_slide(slideIndex = n);
	}

	//Funcion para mostrar la informacion del slide actual en
	//el div de informacion
	function cambia_slide(n) {
	var i;
	var x = document.getElementsByClassName("slide");
	if (n > x.length) {slideIndex = 1}
	if (n < 1) {slideIndex = x.length}
	for (i = 0; i < x.length; i++) {
		x[i].style.display = "none";  
	}
	
	x[slideIndex-1].style.display = "block";
    
	const estacion = estaciones[slideIndex - 1];
		centrar_mapa(estacion.latitud, estacion.longitud);
		if (currentInfoWindow) {
	         currentInfoWindow.close();
	     }
		currentInfoWindow = infoWindows[slideIndex - 1]
		infoWindows[slideIndex - 1].open(map, markers[slideIndex - 1]);
	}
</script>

	
	</body>
</html>