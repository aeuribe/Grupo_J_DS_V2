import React, { useState } from 'react';
import { FaUser, FaLock } from "react-icons/fa";
import './LoginForm.css'
import { MdAdminPanelSettings } from "react-icons/md";

function LoginForm({ onLogin }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Aquí puedes agregar la lógica para verificar las credenciales
    // y llamar a la función `onLogin` si las credenciales son válidas
    if (email === 'a@g.com' && password === 'a') {
      onLogin();
    } else {
      alert('Credenciales inválidas');
    }
  };

  return (
    <div className='wrapper'>
        <form onSubmit={handleSubmit}>
            <h1>Inicio de Sesión</h1>
            <div className='input-boxi'>
                <input type= "text" placeholder='Administrador' readOnly/>
                <MdAdminPanelSettings className='icon'/>
            </div>
            <div className='input-box'>
                <input type= "email" value={email} placeholder='Correo Electrónico' onChange={handleEmailChange}  required />
                <FaUser className='icon'/>
            </div>
            <div className='input-box'>
                <input type= "password" value={password}  placeholder='Contraseña' onChange={handlePasswordChange} required />
                <FaLock className='icon'/>
            </div>
            <button type='submit'> Login</button>
        </form>
    </div>
  );
}

export default LoginForm;