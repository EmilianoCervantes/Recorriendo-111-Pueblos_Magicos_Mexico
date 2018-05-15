import React, { Component } from 'react';
import axios from 'axios';
import RouteDetail from './components/RouteDetail.js'
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {origin: "1", destiny: "1", time: 0, distance: 0, route: "abc"};
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleOrigin = this.handleOrigin.bind(this);
    this.handleDestiny = this.handleDestiny.bind(this);
  }

  handleSubmit(event) {
    //axios shit goes here
    /*
    
    axios.get("url").then(res => {
      this.setState({origin: res.origin, destiny: res.destiny, time: res.time, distance: res.distance, route: res.route});
    });

    */

    alert('Quihubo ' + this.state.origin + this.state.destiny);
  }

  handleOrigin(event) {
    this.setState({origin: event.target.value});
  }

  handleDestiny(event) {
    this.setState({destiny: event.target.value});
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

        <form className = "select" onSubmit={this.handleSubmit}>
          <h2>Pueblo origen</h2>
          <select value = {this.state.origin} onChange = {this.handleOrigin}>
            <option value="1">Pueblo 1</option>
            <option value="2">Pueblo 2</option>
            <option value="3">Pueblo 3</option>
          </select>

          <h2>Pueblo Destino</h2>
          <select value = {this.state.destiny} onChange = {this.handleDestiny}>
            <option value="1">Pueblo 1</option>
            <option value="2">Pueblo 2</option>
            <option value="3">Pueblo 3</option>
          </select>

          <input type="submit" value="Obtener ruta"/>
        </form >

        <RouteDetail origin = {this.state.origin} destiny = {this.state.destiny} time = {this.state.time} distance = {this.state.distance} route  = {this.state.route}/>

        <footer>
        <p>© Proyecto para la clase "Diseño y Arquitectura de Software" del Tec de Monterrey</p>
        </footer>
      </div>
    );
  }
}

export default App;
