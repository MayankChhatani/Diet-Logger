import apiClient from './client';

export function signup(username, password) {
  return apiClient.post('/auth/signup', { username, password });
}

export function login(username, password) {
  return apiClient.post('/auth/login', { username, password });
}
