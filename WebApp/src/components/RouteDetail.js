import React, { Component } from 'react';

const RouteDetail = ({origin, destiny, distance}) =>
  <div className = "routeDetail">
    <p><b>Ruta entre</b></p>
    <p><i>{origin} </i><b> y </b> <i>{destiny}</i></p>
    <p>Distancia total: {distance} KM</p>
  </div>;

export default RouteDetail;
