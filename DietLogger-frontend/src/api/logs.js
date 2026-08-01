import apiClient from './client';

export function logFood(foodItemId) {
  return apiClient.post('/logs', { foodItemId });
}

export function getTodayTotals() {
  return apiClient.get('/logs/today');
}

export function getHistory() {
  return apiClient.get('/logs/history');
}
