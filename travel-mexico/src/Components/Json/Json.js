/**
 * Clase json pasa el origen y destino(s)
 * Aqui se manda el url para el Distance Matrix API
 */

import React from 'react';

const origen = '';
const destinos = [];
const ObtenerJson = (props) => {
    //
    //Un string con todos los destinos como lo pide DMA
    //
    let urlDestinos = '';
    /*for (const destino in destinos) {
        urlDestinos += destino + '|';
    }*/
    for(let i=0; i<destinos.length;i++){
        urlDestinos += destinos[i] + '|';
    }
    //Peticion para obtener el json
    //Nota: xml no significa que solo sea para xml
    let xmlHttp = new XMLHttpRequest();
    let urlPeticion = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+origen+"&destinations="+urlDestinos+"&key=AIzaSyB2vj6e3SsNUFPhGCEF9dazLKMWLAKYP3c";
    let respuesta;
    let respuestaParse;
    xmlHttp.onreadystatechange = () => {
        if (this.readyState === 4 && this.status === 200) {
            respuesta = this.responseText;
            respuestaParse = JSON.parse(this.responseText);
        }
    };
    //XMLHttpRequest.open(method, url, async, user, password)
    xmlHttp.open("GET",urlPeticion,true);
    xmlHttp.send();

    /**
     * Aqui ya podemos manipular los campos de respuesta
     */
    console.log(respuesta);         //Esto trae el json entero
    //Asi se acceden a c/u de los datos
    console.log(respuestaParse.rows[0].elements[0].distance.text); //Ej: "217 km"
    console.log(respuestaParse.rows[0].elements[0].distance.value); //Ej: "217361" (esto es en metros)
    console.log(respuestaParse.rows[0].elements[0].duration.text); //Ej: "2 h 20 min"
    console.log(respuestaParse.rows[0].elements[0].duration.value); //Ej: "8381" (esto es en segundos)

    //Tags pre y code sirven para mostrar un json
    return (
        <pre className="json"><code></code></pre>
    )
}

export default ObtenerJson;