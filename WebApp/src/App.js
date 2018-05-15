import React, { Component } from 'react';
import axios from 'axios';
import RouteDetail from './components/RouteDetail.js';
import TownCard from './components/TownCard.js';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {origin: "", originName:"", destiny: "", destinyName:"", distance: 0, route:[], towns: []};
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleOrigin = this.handleOrigin.bind(this);
    this.handleDestiny = this.handleDestiny.bind(this);
  }

  componentWillMount() {
    axios.get("http://localhost:8080/api/pueblos/").then(res => {
      this.setState({towns: res.data});
    });
  }

  handleSubmit() {
    //axios shit goes here
    axios.get("http://localhost:8080/api/pueblos/"+this.state.origin+"/"+this.state.destiny).then(res => {
      this.setState({distance: res.data.distanciaAcumulada, route: res.data.camino});
    });
  }

  handleOrigin(event) {
    this.setState({origin: event.target.value, originName: event.target.options[event.target.selectedIndex].text});
  }

  handleDestiny(event) {
    this.setState({destiny: event.target.value, destinyName: event.target.options[event.target.selectedIndex].text});
  }


  render() {
    return (
      <div className="App">
        <header className="App-header">
        <div className="layer">
          <h1 className="App-title">Rutas de <br/> pueblos mágicos</h1>
        </div>
        </header>
        <p className="App-intro">
          Para encontrar la ruta más rapida entre dos pueblos mágicos, elige los puntos de origen y destino, y depués haz click en "Obtener Ruta".
        </p>

        <form className = "select">
          <h2>Pueblo Origen</h2>
          <select value = {this.state.origin} onChange = {this.handleOrigin}>
            {this.state.towns.map((town, i) =>
              <option value={town.id} townname = {town.name} key = {i} >{town.nombre}, {town.estado}</option>
            )}
          </select>

          <h2>Pueblo Destino</h2>
          <select value = {this.state.destiny} onChange = {this.handleDestiny}>
            {this.state.towns.map((town, i) =>
              <option value={town.id} key = {i}>{town.nombre}, {town.estado}</option>
            )}
          </select>
        </form >
        <button onClick={this.handleSubmit}>Obtener ruta</button>

        <RouteDetail origin = {this.state.originName} destiny = {this.state.destinyName} distance = {this.state.distance}/>

        <div className="routes">
          {this.state.route.map((town, i) =>
            <TownCard key = {i} {...town}/>
          )}
        </div>

        <footer>
        <p>© Proyecto para la clase "Diseño y Arquitectura de Software" del Tec de Monterrey</p>
        </footer>
      </div>
    );
  }
}

export default App;
