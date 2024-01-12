import React, { useState } from 'react';
import { FcSearch } from "react-icons/fc";

import './Casos.css';

// Ejemplo de datos de Agresores
const AgresorData = [
  { cedulaAgresor: "22987098	", nombreAgresor: 'ANDRES URIBE', sexo: 'MASCULINO', id: "1", descripcion: 'Violador serial' },
  { cedulaAgresor: "27868399", nombreAgresor: 'CARLA MARIA', sexo: 'FEMENINO', id: 2, descripcion: 'Agresion'},
  { cedulaAgresor: "19729934", nombreAgresor: 'ALEX MARKET', sexo: 'MASCULINO', id: 3, descripcion: 'Acoso'}
];

function Agresores() {

  const [busqueda, setBusqueda] = useState('');

  const handleBuscar = (event) => {
    setBusqueda(event.target.value);
  };

  const filtrarAgresores = (Agresor) => {
    const terminoBusqueda = busqueda.toLowerCase();
    return (
      Agresor.cedulaAgresor.toLowerCase().includes(terminoBusqueda) ||
      Agresor.nombreAgresor.toLowerCase().includes(terminoBusqueda) ||
      Agresor.sexo.toLowerCase().includes(terminoBusqueda) ||
      Agresor.descripcion.toLowerCase().includes(terminoBusqueda)
    );
  };

  const AgresoresFiltrados = AgresorData.filter(filtrarAgresores);

  return (
    <div className='wrapper2'>
      <div className='search-wrapper'>
        <input type="text" value={busqueda} onChange={handleBuscar} placeholder="Buscar Agresores" />
        <FcSearch className="search-icon" title="Buscar"/>
      </div>
      <center>
        <h2>Lista de Agresores</h2>
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
          {AgresoresFiltrados.map((Agresor) => (
            <tr key={Agresor.id}>
              <td>{Agresor.cedulaAgresor}</td>
              <td>{Agresor.nombreAgresor}</td>
              <td>{Agresor.sexo}</td>
              <td>{Agresor.id}</td>
              <td>{Agresor.descripcion}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Agresores;