import React, { useState } from 'react';
import { LuFileSearch } from "react-icons/lu";
import { RiFileEditLine } from "react-icons/ri";
import { FaTools } from "react-icons/fa";
import { FcSearch } from "react-icons/fc";
import { MdAssignmentAdd } from "react-icons/md";



import './Casos.css';

// Ejemplo de datos de casos
const casosData = [
  { id: 1, fecha: '03/01/2024', nombreVictima: 'DANIELA ECHEZURIA', cedulaVictima: "27794036", nombreAgresor: 'ANDRES URIBE', cedulaAgresor: "22987098", descripcion: 'Violador serial', cuenta: "10 s" },
  { id: 2, fecha: '04/01/2024', nombreVictima: 'EVA LOPEZ', cedulaVictima: "6164250", nombreAgresor: 'CARLA MARIA', cedulaAgresor: "27868399", descripcion: 'Agresion', cuenta: "15 s"},
  {id: 3, fecha: '05/01/2024', nombreVictima: 'RAY LOPEZ', cedulaVictima: "27319956", nombreAgresor: 'ALEX MARKET', cedulaAgresor: "19729934", descripcion: 'Acoso', cuenta: "19 s"}
];

function Casos({ onPageChange }) {
  const [busqueda, setBusqueda] = useState('');

  const handleBuscar = (event) => {
    setBusqueda(event.target.value);
  };

  const filtrarCasos = (caso) => {
    const terminoBusqueda = busqueda.toLowerCase();
    return (
      caso.fecha.toLowerCase().includes(terminoBusqueda) ||
      caso.nombreVictima.toLowerCase().includes(terminoBusqueda) ||
      caso.nombreAgresor.toLowerCase().includes(terminoBusqueda) ||
      caso.descripcion.toLowerCase().includes(terminoBusqueda)
    );
  };

  const casosFiltrados = casosData.filter(filtrarCasos);

  return (
    <div className='wrapper2'>
      <div className='search-wrapper'>
        <input type="text" value={busqueda} onChange={handleBuscar} placeholder="Buscar casos" />
        <FcSearch className="search-icon" title="Buscar Caso."/>
      </div>
      <br></br>
      <center>
        <h2>Lista de Casos</h2>
      </center>
      <button onClick={() => onPageChange('AgregarCaso')}><MdAssignmentAdd className="add-icon" title="Agregar Nuevo Caso." /></button>
      <br></br><br></br>
      <table>
        <thead>
          <tr>
            <th># Caso</th>
            <th>Fecha</th>
            <th>Víctima</th>
            <th>Agresor</th>
            <th>Descripción</th>
            <th>Cuenta Atras</th>
            <th><FaTools /></th>
          </tr>
        </thead>
        <tbody>
          {casosFiltrados.map((caso) => (
            <tr key={caso.id}>
              <td>{caso.id}</td>
              <td>{caso.fecha}</td>
              <td>{caso.nombreVictima}. C.I: {caso.cedulaVictima}</td>
              <td>{caso.nombreAgresor}. C.I: {caso.cedulaAgresor}</td>
              <td>{caso.descripcion}</td>
              <td>{caso.cuenta}</td>
              <td>
                <button title="Visualizar Caso." onClick={() => onPageChange('VisualizarCaso', caso)}><LuFileSearch /></button>
                <>  </>
                <button title="Modificar Caso." onClick={() => onPageChange('EditarCaso', caso)}><RiFileEditLine /></button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Casos;