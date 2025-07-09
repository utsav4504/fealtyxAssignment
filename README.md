# FealtyX - Student CRUD API with Ollama AI Summary (Spring Boot)

This project provides a fully functional RESTful API for managing student profiles with AI-powered summaries generated via the [Ollama](https://ollama.com) API.

---

## 🚀 Features

- ✅ CRUD operations on students (`POST`, `GET`, `PUT`, `DELETE`)
- 🧠 AI summary generation for each student using Ollama (e.g., Llama2 or Gemma models)
- 🗃️ In-memory storage using `ConcurrentHashMap`
- ✅ Input validation with Jakarta Bean Validation
- 📑 Swagger/OpenAPI documentation for all endpoints
- ⚙️ Thread-safe and concurrent ready

---

## 📦 Tech Stack

- Java 17+
- Spring Boot 3.5.3
- Maven
- Swagger (springdoc-openapi)
- Ollama (local AI model runner)

---

## 🧪 API Endpoints

| Method | Endpoint                     | Description                          |
|--------|------------------------------|--------------------------------------|
| POST   | `/students`                  | Create a new student                 |
| GET    | `/students`                  | Get all students                     |
| GET    | `/students/{id}`             | Get a student by ID                  |
| PUT    | `/students/{id}`             | Update a student by ID               |
| DELETE | `/students/{id}`             | Delete a student by ID               |
| GET    | `/students/{id}/summary`     | Generate AI summary for the student  |

---

## 📘 Sample Student JSON

```json
{
  "name": "Utsav Jain",
  "age": 21,
  "email": "utsav@example.com"
}
