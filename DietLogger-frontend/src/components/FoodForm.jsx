import { useState } from 'react';

export default function FoodForm({ onAdd }) {
  const [form, setForm] = useState({
    name: '',
    calories: '',
    protein: '',
    carbs: '',
    fats: '',
  });

  function handleChange(e) {
    setForm({ ...form, [e.target.name]: e.target.value });
  }

  async function handleSubmit(e) {
    e.preventDefault();
    const { name, calories, protein, carbs, fats } = form;

    if (!name.trim()) return;
    if ([calories, protein, carbs, fats].some((v) => v === '' || isNaN(v))) return;

    await onAdd({
      name: name.trim(),
      calories: parseInt(calories, 10),
      protein: parseInt(protein, 10),
      carbs: parseInt(carbs, 10),
      fats: parseInt(fats, 10),
    });

    setForm({ name: '', calories: '', protein: '', carbs: '', fats: '' });
  }

  return (
    <form className="food-form" onSubmit={handleSubmit}>
      <input
        type="text"
        name="name"
        placeholder="Food Name"
        value={form.name}
        onChange={handleChange}
      />
      <input
        type="number"
        name="calories"
        placeholder="Calories"
        value={form.calories}
        onChange={handleChange}
      />
      <input
        type="number"
        name="protein"
        placeholder="Protein"
        value={form.protein}
        onChange={handleChange}
      />
      <input
        type="number"
        name="carbs"
        placeholder="Carbs"
        value={form.carbs}
        onChange={handleChange}
      />
      <input
        type="number"
        name="fats"
        placeholder="Fats"
        value={form.fats}
        onChange={handleChange}
      />
      <button type="submit">Add Food</button>
    </form>
  );
}
