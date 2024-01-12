import React, { useState } from 'react';
import LoginForm from './Components/LoginForm';
import Menu from './Components/Menu';
import Casos from './Components/Casos';
import Victimas from './Components/Victimas';
import Agresores from './Components/Agresores';
import VisualizarCaso from './Components/VisualizarCaso';
import AgregarCaso from './Components/AgregarCaso';
import EditarCaso from './Components/EditarCaso';


function App() {
  const [isLoggedIn, setLoggedIn] = useState(false);
  const [currentPage, setCurrentPage] = useState('Casos');

  const handleLogin = () => {
    setLoggedIn(true);
  };

  const handleLogout = () => {
    setLoggedIn(false);
  };

  const handleMenuClick = (page) => {
    setCurrentPage(page);
  };

  const handleCasosClick = (page, Casos) => {
    setCurrentPage(page);
  };

  return (
    <div>
      {!isLoggedIn ? (
        <LoginForm onLogin={handleLogin} />
      ) : (
        <div>
          <Menu onPageChange={handleMenuClick} onLogout={handleLogout} />
          {currentPage === 'Casos' && <Casos onPageChange={handleCasosClick} />}
          {currentPage === 'Victimas' && <Victimas />}
          {currentPage === 'Agresores' && <Agresores />}
          {currentPage === 'AgregarCaso' && <AgregarCaso />}
          {currentPage === 'EditarCaso' && <EditarCaso />}
          {currentPage === 'VisualizarCaso' && <VisualizarCaso Casos={Casos}/>}
        </div>
      )}
    </div>
  );
}

export default App;