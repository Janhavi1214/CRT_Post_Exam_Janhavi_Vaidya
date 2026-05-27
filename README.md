# ✈️ Flight Management System

A full-stack **Flight Management System** built as a post-exam project for Campus Recruitment Training (CRT). The application supports core flight operations — managing flights, passengers, and bookings — with a clean REST API backend and a responsive frontend interface.

---

## 📁 Project Structure

```
CRT_Post_Exam_Janhavi_Vaidya/
├── Flight/               # Spring Boot backend (REST API)
└── flight frontend/      # Frontend (HTML/CSS/JS)
```

---

## 🛠️ Tech Stack

| Layer      | Technology                          |
|------------|-------------------------------------|
| Backend    | Java, Spring Boot, Spring Data JPA  |
| Database   | MySQL / H2 (in-memory for dev)      |
| Frontend   | HTML, CSS, JavaScript               |
| Build Tool | Maven                               |
| API Style  | RESTful                             |

---

## 🚀 Features

- **Flight Management** — Add, update, delete, and view flight records
- **Passenger Management** — Register and manage passenger details
- **Booking System** — Book flights and track reservations
- **REST API** — Clean endpoints for all CRUD operations
- **Frontend UI** — Interact with the system via a browser-based interface

---

## ⚙️ Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+
- MySQL (or use the H2 in-memory DB for quick setup)
- A modern web browser

### Backend Setup

```bash
# Clone the repository
git clone https://github.com/Janhavi1214/CRT_Post_Exam_Janhavi_Vaidya.git
cd CRT_Post_Exam_Janhavi_Vaidya/Flight

# Configure your DB in src/main/resources/application.properties
# spring.datasource.url=jdbc:mysql://localhost:3306/flightdb
# spring.datasource.username=root
# spring.datasource.password=yourpassword

# Build and run
mvn spring-boot:run
```

The backend starts at `http://localhost:8080`.

### Frontend Setup

Open the `flight frontend/` folder in your browser:

```bash
cd "../flight frontend"
# Open index.html directly in a browser
# or serve it with VS Code Live Server
```

---

## 📡 API Endpoints (Sample)

| Method | Endpoint              | Description              |
|--------|-----------------------|--------------------------|
| GET    | `/flights`            | Get all flights          |
| POST   | `/flights`            | Add a new flight         |
| PUT    | `/flights/{id}`       | Update flight details    |
| DELETE | `/flights/{id}`       | Delete a flight          |
| GET    | `/bookings`           | Get all bookings         |
| POST   | `/bookings`           | Create a new booking     |

---

## 🎯 Purpose

This project was developed as part of the **CRT (Campus Recruitment Training) Post-Exam** assessment at Ramdeobaba College of Engineering and Management, Nagpur. It demonstrates practical skills in:

- RESTful API design with Spring Boot
- JPA-based data persistence
- Frontend-backend integration
- Full-stack application structuring

---

## 👩‍💻 Author

**Janhavi Vaidya**  
B.E. Computer Science Engineering, RCOEM Nagpur  
[GitHub](https://github.com/Janhavi1214)
