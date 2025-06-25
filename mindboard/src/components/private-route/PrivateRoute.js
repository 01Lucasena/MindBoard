// src/components/PrivateRoute.js
import { useContext }       from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { AuthContext }      from '../../context/AuthContext';

export default function PrivateRoute() {
  const { token } = useContext(AuthContext);
  return token
    ? <Outlet/>
    : <Navigate to="/login" replace />;
}
