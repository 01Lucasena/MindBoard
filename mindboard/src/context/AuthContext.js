import { createContext, useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { login as loginRequest } from '../services/authService';

export const AuthContext = createContext();

export function AuthProvider({ children }) {
  const [token, setToken] = useState(localStorage.getItem('token'));
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    if (token) localStorage.setItem('token', token);
    else localStorage.removeItem('token');
  }, [token]);

  const login = async (email, senha) => {
    setLoading(true);
    try {
      const { token: newToken } = await loginRequest({ email, senha });
      setToken(newToken);
      navigate('/usuarios');
    } catch (err) {
      throw err.response?.data?.error || err.message;
    } finally {
      setLoading(false);
    }
  };

  const logout = () => {
    setToken(null);
    navigate('/login');
  };

  return (
    <AuthContext.Provider value={{ token, login, logout, loading }}>
      {children}
    </AuthContext.Provider>
  );
}
