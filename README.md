# 🥗 Diet Logger - Full Stack Diet Tracking Application

A full-stack web application that helps users track their daily food intake, calories, and nutritional information.

Users can register, login securely, add food items, maintain daily food logs, and monitor their calorie and macronutrient consumption through an interactive dashboard. 

---

## 🚀 Features

### 👤 Authentication
- User Registration
- User Login
- JWT based authentication
- Protected routes

### 🍎 Food Management
- Add food items
- View available food items
- Manage nutritional information
- Track calories, protein, carbohydrates, and fats

### 📊 Diet Tracking
- Add daily food logs
- Calculate daily calorie intake
- Track macronutrients
- View diet history
- Dashboard analytics

---

# 🏗️ Application Architecture

```
                 User
                  |
                  |
          React Frontend
                  |
                  |
             REST API
                  |
                  |
        Spring Boot Backend
                  |
                  |
          Service Layer
                  |
                  |
       Repository Layer
                  |
                  |
             Database
```

---

# 🛠️ Tech Stack

## Frontend
- React.js
- Vite
- Tailwind CSS
- Axios
- React Router

## Backend
- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- REST APIs

## Database
- MySQL

## Tools
- Maven
- Git & GitHub
- Postman
- IntelliJ IDEA
- VS Code

---

# 📂 Project Structure

```
DietLogger
│
├── DietLogger-frontend
│   ├── src
│   ├── package.json
│   └── vite.config.js
│
├── DietLogger-backend
│   ├── src
│   ├── pom.xml
│   └── application.properties
│
└── README.md
```

---

# 🔄 Request Flow

```
React Component
       |
       |
      Axios
       |
       |
Spring Boot Controller
       |
       |
Service Layer
       |
       |
Repository Layer
       |
       |
Database
```

---

# 🔐 Authentication Flow

```
User Login
    |
    |
Backend verifies credentials
    |
    |
JWT Token Generated
    |
    |
Token stored on Client
    |
    |
Protected APIs accessed using JWT
```

---

# 🔌 API Endpoints

## Authentication

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/auth/signup | Register new user |
| POST | /api/auth/login | User login |

---

## Food APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/foods | Get food items |
| POST | /api/foods | Add food item |

---

## Diet Log APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/logs | Add daily food log |
| GET | /api/logs | Get food history |

---

# ⚙️ Installation & Setup

## Clone Repository

```bash
git clone YOUR_REPOSITORY_URL
```

---

# Backend Setup

Navigate to backend:

```bash
cd DietLogger-backend
```

Run:

```bash
mvn spring-boot:run
```

Backend runs on:

```
http://localhost:8080
```

---

# Frontend Setup

Navigate to frontend:

```bash
cd DietLogger-frontend
```

Install dependencies:

```bash
npm install
```

Run application:

```bash
npm run dev
```

Frontend runs on:

```
http://localhost:5173
```

---

# 🧠 Concepts Implemented

- Full Stack Development
- REST API Design
- Layered Architecture
- MVC Pattern
- JWT Authentication
- CRUD Operations
- Frontend-Backend Integration
- Database Management

---

# 🔮 Future Improvements

- Deploy application on cloud
- Add AI based diet recommendations
- Add meal planning feature
- Add advanced analytics

---

# 👨‍💻 Author

**Mayank Chhatani**

GitHub:
https://github.com/MayankChhatani

LinkedIn:
www.linkedin.com/in/mayank-chhatani-369b82316
