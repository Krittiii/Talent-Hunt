import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { getCurrentUser } from '../services/auth';

const Layout = ({ children }) => {
  const user = getCurrentUser();
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    navigate('/login');
  };

  return (
    <div className="app-container">
      <header>
        <h1>Talent Hunt</h1>
        {user && (
          <nav>
            <span>Welcome, {user.name} ({user.role.toLowerCase()})</span>
            <button onClick={handleLogout}>Logout</button>
          </nav>
        )}
      </header>
      <main>{children}</main>
    </div>
  );
};

export default Layout;