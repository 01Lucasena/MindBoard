import axios from 'axios';

const api = axios.create({
  baseURL: process.env.REACT_APP_API_URL,
  headers: { 'Content-Type': 'application/json' },
});

// injeta token em todas as requisições se existir
api.interceptors.request.use((config) => {
  const token = localStorage.getItem('token');
  if (token) config.headers.Authorization = `Bearer ${token}`;
  return config;
});

export default api;

// usuários

export const listarUsuarios   = () => api.get('/usuarios');
export const criarUsuario     = data => api.post('/usuarios', data);
export const atualizarUsuario = (id, data) => api.put(`/usuarios/${id}`, data);
export const excluirUsuario   = id => api.delete(`/usuarios/${id}`);