/**
 * Clase json pasa el origen y destino(s)
 * Aqui se manda el url para el Distance Matrix API
 */

import React from 'react';

const orgien = '';
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
    let urlPeticion = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+orgien+"&destinations="+urlDestinos+"&key=AIzaSyB2vj6e3SsNUFPhGCEF9dazLKMWLAKYP3c";
    xmlHttp.onreadystatechange = () => {
        if (this.readyState === 4 && this.status === 200) {
            var myArr = JSON.parse(this.responseText);
        }
    }

    const respuesta = ;
    //Tag pre sirve para mostrar un json
    return (
        <pre className="json">respuesta</pre>
    )
}

export default ObtenerJson;