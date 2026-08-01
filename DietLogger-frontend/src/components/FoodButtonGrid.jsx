export default function FoodButtonGrid({ foodItems, onLog, onDelete }) {
  if (foodItems.length === 0) {
    return <p>No food items yet — add one above.</p>;
  }

  return (
    <div className="food-buttons">
      {foodItems.map((food) => (
        <button key={food.id} onClick={() => onLog(food)} title={`Log ${food.name}`}>
          {food.name}
          <span
            className="delete-x"
            onClick={(e) => {
              e.stopPropagation();
              onDelete(food.id);
            }}
            title={`Delete ${food.name}`}
          >
            ✕
          </span>
        </button>
      ))}
    </div>
  );
}
