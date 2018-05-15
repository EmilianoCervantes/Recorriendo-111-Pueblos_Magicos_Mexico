import React, { Component } from 'react';

const RouteDetail = ({origin, destiny, time, distance, route}) =>
  <div className = "routeDetail">
    <p><b>Ruta entre {origin} y {destiny}</b></p>
    <ul>
      <li>Distancia: {distance} KM</li>
      <li>Tiempo total: {time} horas</li>
      <li>Ruta: {route}</li>
    </ul>
  </div>;

export default RouteDetail;
