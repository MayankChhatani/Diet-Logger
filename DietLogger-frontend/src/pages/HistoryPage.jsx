import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { getHistory } from '../api/logs';

export default function HistoryPage() {
  const [history, setHistory] = useState([]);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    getHistory().then((res) => {
      setHistory(res.data);
      setLoading(false);
    });
  }, []);

  return (
    <div className="page">
      <div className="top-bar">
        <h1>Diet Logger History</h1>
        <button className="secondary" onClick={() => navigate('/dashboard')}>
          Go Back
        </button>
      </div>

      {loading && <p>Loading...</p>}
      {!loading && history.length === 0 && <p>No history yet.</p>}

      {history.map((entry) => (
        <div className="history-item" key={entry.date}>
          <h2>{entry.date}</h2>
          <p>Total Calories: {entry.calories}</p>
          <p>Total Protein: {entry.protein}</p>
          <p>Total Carbs: {entry.carbs}</p>
          <p>Total Fats: {entry.fats}</p>
        </div>
      ))}
    </div>
  );
}
