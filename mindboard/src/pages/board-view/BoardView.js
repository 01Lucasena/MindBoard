import React from 'react';
import { useAuth } from '../../context/AuthContext';
import ListColumn from '../../components/list-column/ListColumn';
import './BoardView.css';

const BoardView = () => {
  const { user } = useAuth();

  const listas = ['To Do', 'Doing', 'Done'];

  return (
    <div className="board-page">
      <h2>Olá, {user?.name || 'usuário'}</h2>
      <div className="board-columns">
        {listas.map((nome) => (
          <ListColumn key={nome} title={nome} />
        ))}
      </div>
    </div>
  );
};

export default BoardView;