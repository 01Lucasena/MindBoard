// src/pages/Signup.js
import { useState }   from 'react';
import { useNavigate } from 'react-router-dom';
import { registerUser } from '../services/userService';

export default function Signup() {
  const [nome, setNome]       = useState('');
  const [email, setEmail]     = useState('');
  const [senha, setSenha]     = useState('');
  const [error, setError]     = useState('');
  const [loading, setLoading] = useState(false);
  const navigate               = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');
    if (!nome || !email || !senha) {
      setError('Preencha todos os campos');
      return;
    }

    setLoading(true);
    try {
      await registerUser({ nome, email, senha });
      // redireciona para login passando mensagem no state
      navigate('/login', {
        replace: true,
        state: { fromSignup: true }
      });
    } catch (err) {
      setError(
        err.response?.data?.message ||
        err.response?.data?.error   ||
        err.message
      );
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={{ maxWidth: 360, margin: 'auto', padding: 20 }}>
      <h2>Cadastro</h2>
      <form onSubmit={handleSubmit}>
        <label>Nome</label><br/>
        <input type="text"    value={nome} onChange={e => setNome(e.target.value)} required/>
        <br/><label>Email</label><br/>
        <input type="email"   value={email} onChange={e => setEmail(e.target.value)} required/>
        <br/><label>Senha</label><br/>
        <input type="password" value={senha} onChange={e => setSenha(e.target.value)} required minLength={4}/>
        <br/>
        <button type="submit" disabled={loading} style={{ marginTop: 12 }}>
          {loading ? 'Cadastrando…' : 'Cadastrar'}
        </button>
        {error && <p style={{ color: 'red', marginTop: 8 }}>{error}</p>}
      </form>
    </div>
  );
}
