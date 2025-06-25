import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import PrivateRoute from './components/private-route/PrivateRoute';

import Home from './pages/home/Home';
import Login from './pages/login/Login';
import Signup from './pages/sign_up/Signup';
import BoardView from './pages/board-view/BoardView';

function App() {
  return (
    <BrowserRouter>
      <AuthProvider>
        <Routes>
          <Route path="/"        element={<Home />} />
          <Route path="/login"   element={<Login />} />
          <Route path="/signup"  element={<Signup />} />
          {/* Todas as rotas abaixo exigem token */}
          <Route element={<PrivateRoute />}>
            <Route path="/board" element={<BoardView />} />
          </Route>
          {/* redireciona tudo o mais pra Home */}
          <Route path="*"        element={<Navigate to="/" replace />} />
        </Routes>
      </AuthProvider>
    </BrowserRouter>
  );
}

export default App;
