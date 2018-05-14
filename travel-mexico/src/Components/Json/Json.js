/**
 * Clase json pasa el origen y destino(s)
 * Aqui se manda el url para el Distance Matrix API
 */

import React, { Component } from 'react';

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
        origen = this.props.match.params.origen;
        destinos = this.props.match.params.destinos;
        let urlDestinos = '';
        /*for (const destino in destinos) {
            urlDestinos += destino + '|';
        }*/
        for(let i=0; i<destinos.length;i++){
            urlDestinos += destinos[i] + '|';
        }
        axios.get("https://maps.googleapis.com/maps/api/distancematrix/json?origins="+origen+"&destinations="+urlDestinos+"&key=AIzaSyB2vj6e3SsNUFPhGCEF9dazLKMWLAKYP3c")
        .then(res => {
            this.setState( { datosDMA:res.data } );
        }
        )

        console.log(datosDMA);
        console.log(datosDMA.rows[0].elements[0].distance.text); //Ej: "217 km"
        console.log(datosDMA.rows[0].elements[0].distance.value); //Ej: "217361" (esto es en metros)
        console.log(datosDMA.rows[0].elements[0].duration.text); //Ej: "2 h 20 min"
        console.log(datosDMA.rows[0].elements[0].duration.value); //Ej: "8381" (esto es en segundos)
    }

    //Tags pre y code sirven para mostrar un json
    render () {
        return (
            <pre className="json"><code></code></pre>
        );
    }
}

export default Json;