import React from 'react';
import image from "./Assets/logo.png";
import './Menu.css'

function Menu({ onPageChange, onLogout }) {
  return (
    <>
    <nav>
      <a id="h1"><img src={image} width="50" height="50"/> AttackerVictimApp </a>
      <div>
        <ul id="navbar">
          <li><a  className="active"><button onClick={() => onPageChange('Casos')}>Casos</button></a></li>
          <li><a><button onClick={() => onPageChange('Victimas')}>Victimas</button></a></li>
          <li><a><button onClick={() => onPageChange('Agresores')}>Agresores</button></a></li>
          <li><a><button onClick={onLogout}>Salir</button></a></li>
        </ul>
      </div>
    </nav>
    </>
  );
}

export default Menu;