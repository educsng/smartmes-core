import axios from "axios";

export const authenticatedRequest = axios.create({
  baseURL: `${process.env.API_URL}`,
});

authenticatedRequest.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");

    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  (error) => {
    Promise.reject(error);
  }
);
