import { fetchAPI } from './api';

export const login = async (emailid, password) => {
  try {
    const user = await fetchAPI('users/login', 'POST', { emailid, password });
    localStorage.setItem('user', JSON.stringify(user));
    return user;
  } catch (error) {
    throw new Error(error.message || 'Login failed');
  }
};

export const register = async (userData) => {
  try {
    const user = await fetchAPI('users/create', 'POST', {
      name: userData.name,
      emailid: userData.email,
      password: userData.password,
      role: userData.role
    });
    return user;
  } catch (error) {
    throw new Error(error.message || 'Registration failed');
  }
};

export const getCurrentUser = () => {
  const user = localStorage.getItem('user');
  return user ? JSON.parse(user) : null;
};

export const logout = () => {
  localStorage.removeItem('user');
};