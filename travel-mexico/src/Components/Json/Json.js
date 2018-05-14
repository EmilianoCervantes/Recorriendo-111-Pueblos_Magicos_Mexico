/**
 * Clase json pasa el pueblo inicial y pueblo final para mandarlo visualmente en Mostrar Json.
 * Está implementada la llamada al Distance Matrix API
 * sin embargo, a la mejor se debe pasar a Grafo.
 */

import React, { Component } from 'react';
import axios from 'axios';

const origen = '';
const destinos = [];
class Json extends Component {
    constructor(props){
        super(props);
        this.state = { puebloInicial, puebloFinal, datosDMA };
    }
    //
    //Un string con todos los destinos como lo pide DMA
    //
    componentWillMount(){
        /**
         * Aqui se obteniene del Distantance Matrix API cada costo de un origen a los n destinos.
         */
        origen = this.props.match.params.origen;
        destinos = this.props.match.params.destinos;
        let urlDestinos = '';
        
        for(let i=0; i<destinos.length;i++){
            urlDestinos += destinos[i] + '|';
        }
        //EJ: https://maps.googleapis.com/maps/api/distancematrix/json?origins=cdmx&destinations=guadalajara|chihuahua|nuevo+leon&key=
        axios.get("https://maps.googleapis.com/maps/api/distancematrix/json?origins="+origen+"&destinations="+urlDestinos+"&key=AIzaSyB2vj6e3SsNUFPhGCEF9dazLKMWLAKYP3c")
        .then(res => {
            this.setState( { datosDMA:res.data } );
        }
        )

        console.log(datosDMA);
        console.log(datosDMA.rows[0].elements[0].distance.text); //Ej: "217 km" (Asi es tal cual el String)
        console.log(datosDMA.rows[0].elements[0].distance.value); //Ej: "217361" (esto es en metros)
        console.log(datosDMA.rows[0].elements[0].duration.text); //Ej: "2 h 20 min" (Asi es tal cual el String)
        console.log(datosDMA.rows[0].elements[0].duration.value); //Ej: "8381" (esto es en segundos)
    }

    //Tags pre y code sirven para mostrar un json
    render () {
        return (
            <pre className="json"><code></code></pre>
        );
    }

    componentDidMount(){
        //
    }
}

export default Json;