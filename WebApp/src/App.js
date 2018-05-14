import React, { Component } from 'react';
import './App.css';

class App extends Component {
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

        <div className = "select">
          <h2>Pueblo origen</h2>
          <select>
            <option value="Pueblo 1">Pueblo 1</option>
            <option value="Pueblo 2">Pueblo 2</option>
            <option value="Pueblo 3">Pueblo 3</option>
          </select>
        </div>

        <div className = "select">
          <h2>Pueblo Destino</h2>
          <select>
            <option value="Pueblo 1">Pueblo 1</option>
            <option value="Pueblo 2">Pueblo 2</option>
            <option value="Pueblo 3">Pueblo 3</option>
          </select>
        </div>

        <button>Obtener Ruta</button>

        <footer>
        <p>© Proyecto para la clase "Diseño y Arquitectura de Software" del Tec de Monterrey</p>
        </footer>
      </div>
    );
  }
}

export default App;
