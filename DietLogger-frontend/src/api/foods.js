import apiClient from './client';

export function getFoodItems() {
  return apiClient.get('/foods');
}

export function addFoodItem(food) {
  return apiClient.post('/foods', food);
}

export function deleteFoodItem(id) {
  return apiClient.delete(`/foods/${id}`);
}
