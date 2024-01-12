import React, { useState } from 'react';
import './Form.css';

function AgregarCaso() {
  const [victima, setVictima] = useState({
    nombre: '',
    cedula: '',
    s_nombre: '',
    apellido: '',
    s_apellido: '',
    sexo: '',
    fecha_nac: '',
    user: '',
    password: '',
    cod: '',
    modelo: '',
    marca: '',
    tlf: '',
    zona: '',
    latitud: '',
    longitud: ''
  });

  const [agresor, setAgresor] = useState({
    nombre: '',
    cedula: '',
    s_nombre: '',
    apellido: '',
    s_apellido: '',
    sexo: '',
    fecha_nac: '',
    user: '',
    password: '',
    cod: '',
    modelo: '',
    marca: '',
    tlf: '',
    zona: '',
    latitud: '',
    longitud: ''
  });

  const [caso, setCaso] = useState({
    id: '',
    fecha: '',
    descripcion: '',
    distancia: '',
    cuenta: '',
    inamovilidad: ''
  });

  const [step, setStep] = useState(1);

  const handleVictimaChange = (event) => {
    const { name, value } = event.target;
    setVictima((prevVictima) => ({
      ...prevVictima,
      [name]: value,
    }));
  };

  const handleAgresorChange = (event) => {
    const { name, value } = event.target;
    setAgresor((prevAgresor) => ({
      ...prevAgresor,
      [name]: value,
    }));
  };

  const handleCasoChange = (event) => {
    const { name, value } = event.target;
    setCaso((prevCaso) => ({
      ...prevCaso,
      [name]: value,
    }));
  };

  const handleContinuar = () => {
    setStep(2);
  };

  const handleContinuarr = () => {
    setStep(3);
  };

  const handleGuardar = () => {
    // Aquí puedes realizar la lógica para guardar los datos de la víctima y el agresor
    console.log('Victima:', victima);
    console.log('Agresor:', agresor);
    console.log('Caso', caso);
  };

  if (step === 1) {
    return (
      <div className='wrapper3' style={{ height: '500px', overflowY: 'scroll' }}>
        <h2>Datos de la víctima</h2>
        <table>
          <tbody>
            <br></br><h3>Datos Personales</h3>
            <tr>
              <td>
                <label>Primer Nombre:</label>
              </td>
              <td>
                <input type="text" name="nombre" value={victima.nombre} onChange={handleVictimaChange} />
              </td>
              <td>
                <label>Segundo Nombre:</label>
                </td>
              <td>
                <input type="text" name="s_nombre" value={victima.s_nombre} onChange={handleVictimaChange} />
              </td>
            </tr>
            <tr>
              <td>
                <label>Primer Apellido:</label>
                </td>
              <td>
                <input type="text" name="apellido" value={victima.apellido} onChange={handleVictimaChange} />
              </td>
              <td>
                <label>Segundo Apellido:</label>
                </td>
              <td>
                <input type="text" name="s_apellido" value={victima.s_apellido} onChange={handleVictimaChange} />
              </td>
            </tr>
            <tr>
              <td>
                <label>Cédula:</label>
                </td>
              <td>
                <input type="text" name="cedula" value={victima.cedula} onChange={handleVictimaChange} />
              </td>
              <td>
                <label>Sexo:</label>
              </td>
              <td>
                <input type="text" name="sexo" value={victima.sexo} onChange={handleVictimaChange} />
              </td>
            </tr>
            <tr>
              <td>
                <label>Fecha de Nacimiento:</label>
                </td>
              <td>
                <input type="text" name="fecha_nac" value={victima.fecha_nac} onChange={handleVictimaChange} />
              </td>
              
            </tr>
            <br></br><br></br><h3>Datos de Usuario</h3>
            <tr>
              <td>
                <label>Nombre de Usuario:</label>
                </td>
              <td>
                <input type="text" name="user" value={victima.user} onChange={handleVictimaChange} />
              </td>
              <td>
                <label>Contraseña:</label>
                </td>
              <td>
                <input type="text" name="password" value={victima.password} onChange={handleVictimaChange} />
              </td>
              
            </tr>
            <br></br><br></br><h3>Datos de Dispositivo</h3>
            <tr>
              <td>
                <label>Código Dispositivo:</label>
                </td>
              <td>
                <input type="text" name="cod" value={victima.cod} onChange={handleVictimaChange} />
              </td>
              <td>
                <label>Modelo de Teléfono:</label>
                </td>
              <td>
                <input type="text" name="modelo" value={victima.modelo} onChange={handleVictimaChange} />
              </td>
            </tr>
            <tr>
              <td>
                <label>Marca:</label>
                </td>
              <td>
                <input type="text" name="marca" value={victima.marca} onChange={handleVictimaChange} />
              </td>
              <td>
                <label>Teléfono:</label>
                </td>
              <td>
                <input type="text" name="tlf" value={victima.tlf} onChange={handleVictimaChange} />
              </td>
            </tr>
            <br></br><br></br><h3>Zonas de Seguridad</h3>
            <tr>
              <td>
                <label>Zona:</label>
                </td>
              <td>
                <input type="text" name="zona" value={victima.zona} onChange={handleVictimaChange} />
              </td>
              <td>
                <label>Latitud:</label>
              </td>
              <td>
                <input type="text" name="latitud" value={victima.latitud} onChange={handleVictimaChange} />
              </td>
            </tr>
            <tr>
              <td>
                <label>Longitud:</label>
                </td>
              <td>
                <input type="text" name="longitud" value={victima.longitud} onChange={handleVictimaChange} />
              </td><td></td>
              <td><button onClick={handleContinuar}>Continuar</button></td>
            </tr>
          </tbody>
        </table>
      </div>
    ); 
  } else if (step === 2) {
    return (
      <div className='wrapper3' style={{ height: '500px', overflowY: 'scroll' }}>
        <h2>Datos del Agresor</h2>
        <table>
          <tbody>
            <br></br><h3>Datos Personales</h3>
            <tr>
              <td>
                <label>Primer Nombre:</label>
              </td>
              <td>
                <input type="text" name="nombre" value={agresor.nombre} onChange={handleAgresorChange} />
              </td>
              <td>
                <label>Segundo Nombre:</label>
                </td>
              <td>
                <input type="text" name="s_nombre" value={agresor.s_nombre} onChange={handleAgresorChange} />
              </td>
            </tr>
            <tr>
              <td>
                <label>Primer Apellido:</label>
                </td>
              <td>
                <input type="text" name="apellido" value={agresor.apellido} onChange={handleAgresorChange} />
              </td>
              <td>
                <label>Segundo Apellido:</label>
                </td>
              <td>
                <input type="text" name="s_apellido" value={agresor.s_apellido} onChange={handleAgresorChange} />
              </td>
            </tr>
            <tr>
              <td>
                <label>Cédula:</label>
                </td>
              <td>
                <input type="text" name="cedula" value={agresor.cedula} onChange={handleAgresorChange} />
              </td>
              <td>
                <label>Sexo:</label>
              </td>
              <td>
                <input type="text" name="sexo" value={agresor.sexo} onChange={handleAgresorChange} />
              </td>
            </tr>
            <tr>
              <td>
                <label>Fecha de Nacimiento:</label>
                </td>
              <td>
                <input type="text" name="fecha_nac" value={agresor.fecha_nac} onChange={handleAgresorChange} />
              </td>
              
            </tr>
            <br></br><br></br><h3>Datos de Usuario</h3>
            <tr>
              <td>
                <label>Nombre de Usuario:</label>
                </td>
              <td>
                <input type="text" name="user" value={agresor.user} onChange={handleAgresorChange} />
              </td>
              <td>
                <label>Contraseña:</label>
                </td>
              <td>
                <input type="text" name="password" value={agresor.password} onChange={handleAgresorChange} />
              </td>
              
            </tr>
            <br></br><br></br><h3>Datos de Dispositivo</h3>
            <tr>
              <td>
                <label>Código Dispositivo:</label>
                </td>
              <td>
                <input type="text" name="cod" value={agresor.cod} onChange={handleAgresorChange} />
              </td>
              <td>
                <label>Modelo de Teléfono:</label>
                </td>
              <td>
                <input type="text" name="modelo" value={agresor.modelo} onChange={handleAgresorChange} />
              </td>
            </tr>
            <tr>
              <td>
                <label>Marca:</label>
                </td>
              <td>
                <input type="text" name="marca" value={agresor.marca} onChange={handleAgresorChange} />
              </td>
              <td>
                <label>Teléfono:</label>
                </td>
              <td>
                <input type="text" name="tlf" value={agresor.tlf} onChange={handleAgresorChange} />
              </td>
            </tr>
            
            <tr>
              <td></td>            
              <td></td><td></td>
              <td><button className="button" onClick={handleContinuarr}>Continuar</button></td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  } else if (step === 3) {
    return (
      <div className='wrapper3' style={{ height: '500px', overflowY: 'scroll' }}>
        <h2>Datos del Caso</h2>
        <table>
          <tbody>
            <tr>
              <td>
                <label># del Caso:</label>
              </td>
              <td>
                <input type="text" name="id" value={caso.id} onChange={handleCasoChange} />
              </td>
              <td>
                <label>Fecha:</label>
                </td>
              <td>
                <input type="date" name="fecha" value={caso.fecha} onChange={handleCasoChange} />
              </td>
            </tr>
            <tr>
              <td>
                <label>Descripción:</label>
                </td>
              <td>
                <input type="text" name="descripcion" value={caso.descripcion} onChange={handleCasoChange} />
              </td>
              <td>
                <label>Cuenta Atras:</label>
                </td>
              <td>
                <input type="text" name="cuenta" value={caso.cuenta} onChange={handleCasoChange} />
              </td>
            </tr>
            <tr>
              <td>
                <label>Inamovilidad:</label>
                </td>
              <td>
                <input type="text" name="inamovilidad" value={caso.inamovilidad} onChange={handleCasoChange} />
              </td>
              <td>
                <label>Distancia de Alejamiento:</label>
              </td>
              <td>
                <input type="text" name="distancia" value={caso.distancia} onChange={handleCasoChange} />
              </td>
            </tr>
            <tr>
              <td></td>
              <td></td><td></td>
              <td><button className="button" onClick={handleGuardar}>Guardar</button></td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  }} 
                
export default AgregarCaso;