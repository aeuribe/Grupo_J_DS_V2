import React, { useState } from 'react';
import { FcSearch } from "react-icons/fc";

import './Casos.css';

// Ejemplo de datos de Victimas
const victimaData = [
  { cedulaVictima: "27794036", nombreVictima: 'DANIELA ECHEZURIA', sexo: 'FEMENINO', id: "1", descripcion: 'Violador serial' },
  { cedulaVictima: "6164250", nombreVictima: 'EVA LOPEZ', sexo: 'FEMENINO', id: 2, descripcion: 'Agresion'},
  { cedulaVictima: "27319956", nombreVictima: 'RAY LOPEZ', sexo: 'FEMENINO', id: 3, descripcion: 'Acoso'}
];

function Victimas() {

  const [busqueda, setBusqueda] = useState('');

  const handleBuscar = (event) => {
    setBusqueda(event.target.value);
  };

  const filtrarVictimas = (victima) => {
    const terminoBusqueda = busqueda.toLowerCase();
    return (
      victima.cedulaVictima.toLowerCase().includes(terminoBusqueda) ||
      victima.nombreVictima.toLowerCase().includes(terminoBusqueda) ||
      victima.sexo.toLowerCase().includes(terminoBusqueda) ||
      victima.descripcion.toLowerCase().includes(terminoBusqueda)
    );
  };

  const VictimasFiltrados = victimaData.filter(filtrarVictimas);

  return (
    <div className='wrapper2'>
      <div className='search-wrapper'>
        <input type="text" value={busqueda} onChange={handleBuscar} placeholder="Buscar victimas" />
        <FcSearch className="search-icon" title="Buscar"/>
      </div>
      <center>
        <h2>Lista de Victimas</h2>
      </center>
      <table>
        <thead>
          <tr>
            <th>Cédula</th>
            <th>Nombre</th>
            <th>Sexo</th>
            <th># Caso</th>
            <th>Descripción</th>
          </tr>
        </thead>
        <tbody>
          {VictimasFiltrados.map((Victima) => (
            <tr key={Victima.id}>
              <td>{Victima.cedulaVictima}</td>
              <td>{Victima.nombreVictima}</td>
              <td>{Victima.sexo}</td>
              <td>{Victima.id}</td>
              <td>{Victima.descripcion}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Victimas;