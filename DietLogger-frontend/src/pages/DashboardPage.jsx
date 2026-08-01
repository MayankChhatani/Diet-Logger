import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import { getFoodItems, addFoodItem, deleteFoodItem } from '../api/foods';
import { logFood, getTodayTotals } from '../api/logs';
import FoodForm from '../components/FoodForm';
import FoodButtonGrid from '../components/FoodButtonGrid';
import MacroSummary from '../components/MacroSummary';

export default function DashboardPage() {
  const [foodItems, setFoodItems] = useState([]);
  const [totals, setTotals] = useState({ calories: 0, protein: 0, carbs: 0, fats: 0 });
  const [loading, setLoading] = useState(true);

  const { user, logoutUser } = useAuth();
  const navigate = useNavigate();

  useEffect(() => {
    loadData();
  }, []);

  async function loadData() {
    setLoading(true);
    const [foodsRes, totalsRes] = await Promise.all([getFoodItems(), getTodayTotals()]);
    setFoodItems(foodsRes.data);
    setTotals(totalsRes.data);
    setLoading(false);
  }

  async function handleAddFood(food) {
    const res = await addFoodItem(food);
    setFoodItems([...foodItems, res.data].sort((a, b) => a.name.localeCompare(b.name)));
  }

  async function handleDeleteFood(id) {
    await deleteFoodItem(id);
    setFoodItems(foodItems.filter((f) => f.id !== id));
  }

  async function handleLogFood(food) {
    const res = await logFood(food.id);
    setTotals(res.data);
  }

  function handleLogout() {
    logoutUser();
    navigate('/login');
  }

  if (loading) return <div className="page">Loading...</div>;

  return (
    <div className="page">
      <div className="top-bar">
        <h1>Hello, {user.userid}!</h1>
        <button className="secondary" onClick={handleLogout}>
          Log Out
        </button>
      </div>

      <h2>Create Food Item</h2>
      <FoodForm onAdd={handleAddFood} />

      <h2>Food Items</h2>
      <FoodButtonGrid foodItems={foodItems} onLog={handleLogFood} onDelete={handleDeleteFood} />

      <h2>Daily Macros Counter</h2>
      <MacroSummary totals={totals} />

      <button onClick={() => navigate('/history')}>View History</button>
    </div>
  );
}
