import React, { useState } from 'react';
import './Form.css';

function VisualizarCaso() {
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
                <input type="text" name="nombre" value={victima.nombre}  />
              </td>
              <td>
                <label>Segundo Nombre:</label>
                </td>
              <td>
                <input type="text" name="s_nombre" value={victima.s_nombre}  />
              </td>
            </tr>
            <tr>
              <td>
                <label>Primer Apellido:</label>
                </td>
              <td>
                <input type="text" name="apellido" value={victima.apellido}  />
              </td>
              <td>
                <label>Segundo Apellido:</label>
                </td>
              <td>
                <input type="text" name="s_apellido" value={victima.s_apellido}  />
              </td>
            </tr>
            <tr>
              <td>
                <label>Cédula:</label>
                </td>
              <td>
                <input type="text" name="cedula" value={victima.cedula}  />
              </td>
              <td>
                <label>Sexo:</label>
              </td>
              <td>
                <input type="text" name="sexo" value={victima.sexo}  />
              </td>
            </tr>
            <tr>
              <td>
                <label>Fecha de Nacimiento:</label>
                </td>
              <td>
                <input type="text" name="fecha_nac" value={victima.fecha_nac}  />
              </td>
              
            </tr>
            <br></br><br></br><h3>Datos de Usuario</h3>
            <tr>
              <td>
                <label>Nombre de Usuario:</label>
                </td>
              <td>
                <input type="text" name="user" value={victima.user}  />
              </td>
              <td>
                <label>Contraseña:</label>
                </td>
              <td>
                <input type="text" name="password" value={victima.password}  />
              </td>
              
            </tr>
            <br></br><br></br><h3>Datos de Dispositivo</h3>
            <tr>
              <td>
                <label>Código Dispositivo:</label>
                </td>
              <td>
                <input type="text" name="cod" value={victima.cod}  />
              </td>
              <td>
                <label>Modelo de Teléfono:</label>
                </td>
              <td>
                <input type="text" name="modelo" value={victima.modelo}  />
              </td>
            </tr>
            <tr>
              <td>
                <label>Marca:</label>
                </td>
              <td>
                <input type="text" name="marca" value={victima.marca}  />
              </td>
              <td>
                <label>Teléfono:</label>
                </td>
              <td>
                <input type="text" name="tlf" value={victima.tlf}  />
              </td>
            </tr>
            <br></br><br></br><h3>Zonas de Seguridad</h3>
            <tr>
              <td>
                <label>Zona:</label>
                </td>
              <td>
                <input type="text" name="zona" value={victima.zona}  />
              </td>
              <td>
                <label>Latitud:</label>
              </td>
              <td>
                <input type="text" name="latitud" value={victima.latitud}  />
              </td>
            </tr>
            <tr>
              <td>
                <label>Longitud:</label>
                </td>
              <td>
                <input type="text" name="longitud" value={victima.longitud}  />
              </td>
            </tr>
          </tbody>
        </table>
        <br></br><br></br><h2>Datos del Agresor</h2>
        <table>
          <tbody>
            <br></br><h3>Datos Personales</h3>
            <tr>
              <td>
                <label>Primer Nombre:</label>
              </td>
              <td>
                <input type="text" name="nombre" value={agresor.nombre}  />
              </td>
              <td>
                <label>Segundo Nombre:</label>
                </td>
              <td>
                <input type="text" name="s_nombre" value={agresor.s_nombre}  />
              </td>
            </tr>
            <tr>
              <td>
                <label>Primer Apellido:</label>
                </td>
              <td>
                <input type="text" name="apellido" value={agresor.apellido}  />
              </td>
              <td>
                <label>Segundo Apellido:</label>
                </td>
              <td>
                <input type="text" name="s_apellido" value={agresor.s_apellido}  />
              </td>
            </tr>
            <tr>
              <td>
                <label>Cédula:</label>
                </td>
              <td>
                <input type="text" name="cedula" value={agresor.cedula}  />
              </td>
              <td>
                <label>Sexo:</label>
              </td>
              <td>
                <input type="text" name="sexo" value={agresor.sexo}  />
              </td>
            </tr>
            <tr>
              <td>
                <label>Fecha de Nacimiento:</label>
                </td>
              <td>
                <input type="text" name="fecha_nac" value={agresor.fecha_nac}  />
              </td>
              
            </tr>
            <br></br><br></br><h3>Datos de Usuario</h3>
            <tr>
              <td>
                <label>Nombre de Usuario:</label>
                </td>
              <td>
                <input type="text" name="user" value={agresor.user}  />
              </td>
              <td>
                <label>Contraseña:</label>
                </td>
              <td>
                <input type="text" name="password" value={agresor.password}  />
              </td>
              
            </tr>
            <br></br><br></br><h3>Datos de Dispositivo</h3>
            <tr>
              <td>
                <label>Código Dispositivo:</label>
                </td>
              <td>
                <input type="text" name="cod" value={agresor.cod}  />
              </td>
              <td>
                <label>Modelo de Teléfono:</label>
                </td>
              <td>
                <input type="text" name="modelo" value={agresor.modelo}  />
              </td>
            </tr>
            <tr>
              <td>
                <label>Marca:</label>
                </td>
              <td>
                <input type="text" name="marca" value={agresor.marca}  />
              </td>
              <td>
                <label>Teléfono:</label>
                </td>
              <td>
                <input type="text" name="tlf" value={agresor.tlf}  />
              </td>
            </tr>
          </tbody>
        </table>
        <br></br><br></br><h2>Datos del Caso</h2>
        <table>
          <tbody>
            <tr>
              <td>
                <label># del Caso:</label>
              </td>
              <td>
                <input type="text" name="id" value={caso.id}/>
              </td>
              <td>
                <label>Fecha:</label>
                </td>
              <td>
                <input type="date" name="fecha" value={caso.fecha}/>
              </td>
            </tr>
            <tr>
              <td>
                <label>Descripción:</label>
                </td>
              <td>
                <input type="text" name="descripcion" value={caso.descripcion} />
              </td>
              <td>
                <label>Cuenta Atras:</label>
                </td>
              <td>
                <input type="text" name="cuenta" value={caso.cuenta} />
              </td>
            </tr>
            <tr>
              <td>
                <label>Inamovilidad:</label>
                </td>
              <td>
                <input type="text" name="inamovilidad" value={caso.inamovilidad} />
              </td>
              <td>
                <label>Distancia de Alejamiento:</label>
              </td>
              <td>
                <input type="text" name="distancia" value={caso.distancia} />
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  }
                
export default VisualizarCaso;