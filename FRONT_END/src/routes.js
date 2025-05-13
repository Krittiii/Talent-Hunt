import React from 'react';
import Login from './components/Auth/Login';
import Register from './components/Auth/Register';
import UsersList from './components/Admin/UsersList';
import CommentsList from './components/Judge/CommentsList';
import TalentsList from './components/Participant/TalentsList';
import { getCurrentUser } from './services/auth';

const PrivateRoute = ({ element: Element, requiredRole }) => {
  const user = getCurrentUser();
  
  if (!user) {
    return <Login />;
  }

  if (requiredRole && user.role !== requiredRole) {
    return <div>Unauthorized access</div>;
  }

  return <Element />;
};

const routes = [
  { path: '/login', element: <Login /> },
  { path: '/register', element: <Register /> },
  { 
    path: '/admin', 
    element: <PrivateRoute element={UsersList} requiredRole="ADMIN" /> 
  },
  { 
    path: '/judge', 
    element: <PrivateRoute element={CommentsList} requiredRole="JUDGE" /> 
  },
  { 
    path: '/participant', 
    element: <PrivateRoute element={TalentsList} requiredRole="PARTICIPANT" /> 
  },
  { path: '/', element: <Login /> },
];

export default routes;