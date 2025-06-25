import { Link } from 'react-router-dom';

export default function Home() {
  return (
    <div style={{ textAlign: 'center', padding: 60 }}>
      <h1>Bem-vindo ao MindBoard</h1>
      <p>Escolha abaixo:</p>
      <div style={{ marginTop: 24 }}>
        <Link to="/login">
          <button>Fazer Login</button>
        </Link>
        <Link to="/signup" style={{ marginLeft: 12 }}>
          <button>Cadastrar-se</button>
        </Link>
      </div>
    </div>
  );
}