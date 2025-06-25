// src/pages/Login.js
import { useState, useContext, useEffect } from 'react';
import { useLocation }   from 'react-router-dom';
import { AuthContext }   from '../context/AuthContext';

export default function Login() {
  const [email, setEmail]     = useState('');
  const [senha, setSenha]     = useState('');
  const [error, setError]     = useState('');
  const { login, loading }    = useContext(AuthContext);
  const { state }             = useLocation();

  // se vier de signup, mostre um aviso
  const [showMsg, setShowMsg] = useState(false);
  useEffect(() => {
    if (state?.fromSignup) {
      setShowMsg(true);
      setTimeout(() => setShowMsg(false), 3000);
    }
  }, [state]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');
    try {
      await login(email, senha);
      // AuthContext já redireciona pra /board
    } catch (errMsg) {
      setError(errMsg);
    }
  };

  return (
    <div style={{ maxWidth: 360, margin: 'auto', padding: 20 }}>
      <h2>Login</h2>
      {showMsg && <p style={{ color: 'green' }}>Cadastro realizado! Faça login.</p>}
      <form onSubmit={handleSubmit}>
        <label>Email</label><br/>
        <input type="email"    value={email} onChange={e => setEmail(e.target.value)} required/>
        <br/><label>Senha</label><br/>
        <input type="password" value={senha} onChange={e => setSenha(e.target.value)} required/>
        <br/>
        <button type="submit" disabled={loading} style={{ marginTop: 12 }}>
          {loading ? 'Entrando…' : 'Entrar'}
        </button>
        {error && <p style={{ color: 'red', marginTop: 8 }}>{error}</p>}
      </form>
    </div>
  );
}
