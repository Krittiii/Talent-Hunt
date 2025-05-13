import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Login from './components/Auth/Login';
import Register from './components/Auth/Register';
import AdminDashboard from './components/Admin/AdminDashboard';
import JudgeDashboard from './components/Judge/JudgeDashboard';
import ParticipantDashboard from './components/Participant/ParticipantDashboard';
import { getCurrentUser } from './services/auth';

const PrivateRoute = ({ children, requiredRole }) => {
  const user = getCurrentUser();
  
  if (!user) {
    return <Navigate to="/login" />;
  }

  if (requiredRole && user.role !== requiredRole) {
    return <div>Unauthorized access</div>;
  }

  return children;
};

function App() {
  return (
    <Router>
      <div className="app">
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route 
            path="/admin" 
            element={
              <PrivateRoute requiredRole="ADMIN">
                <AdminDashboard />
              </PrivateRoute>
            } 
          />
          <Route 
            path="/judge" 
            element={
              <PrivateRoute requiredRole="JUDGE">
                <JudgeDashboard />
              </PrivateRoute>
            } 
          />
          <Route 
            path="/participant" 
            element={
              <PrivateRoute requiredRole="PARTICIPANT">
                <ParticipantDashboard />
              </PrivateRoute>
            } 
          />
          <Route path="/" element={<Navigate to="/login" />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;