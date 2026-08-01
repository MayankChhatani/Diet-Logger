export default function MacroSummary({ totals }) {
  return (
    <div className="macro-summary">
      <p>Total Calories: {totals.calories ?? 0}</p>
      <p>Total Protein (g): {totals.protein ?? 0}</p>
      <p>Total Carbs (g): {totals.carbs ?? 0}</p>
      <p>Total Fats (g): {totals.fats ?? 0}</p>
    </div>
  );
}
