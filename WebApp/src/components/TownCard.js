import React, { Component } from 'react';

const TownCard = ({nombre, estado, descripcion, ano, imagen}) =>
  <div className = "townCard">
    <img src={imagen} alt="thumbnail"/>
    <p>{nombre}, {estado}</p>
    <p>Descripción: {descripcion}</p>
    <p>Año de inclusión: {ano}</p>
  </div>;

export default TownCard;
