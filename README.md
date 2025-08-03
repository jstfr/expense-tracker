# Expense Tracker

A simple **Expense Tracker** REST API built with **Spring Boot**, **Hibernate/JPA**, and **H2 database** for managing expenses and categories.

---

## Features

- Manage **Expenses** with description, amount, date, and multiple categories
- Manage **Categories** with unique names
- Create, read, update, and delete (CRUD) operations for expenses and categories
- Input validation with **Bean Validation** (`@Valid`)
- Pagination and sorting support on listing expenses
- Exception handling with custom error responses
- Uses **Lombok** to reduce boilerplate code

---

## Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- H2 in-memory database (for development/testing)
- Lombok
- Jakarta Bean Validation
- Maven

---

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Running the Application

1. Clone the repository:
   ```bash
   git clone git@github.com:jstfr/expense-tracker.git
   cd expense-tracker
   ```
 2. Build and run:
   ```bash
   mvn spring-boot:run
   ```
   The application will start on: 
   ```bash
   http://localhost:8080
   ```
---
### API Endpoints
| Method | Endpoint               | Description           |
| ------ | ---------------------- | --------------------- |
| GET    | `/api/categories`      | List all categories   |
| POST   | `/api/categories`      | Create new category   |
| DELETE | `/api/categories/{id}` | Delete category by ID |


| Method | Endpoint             | Description                   |
| ------ | -------------------- | ----------------------------- |
| GET    | `/api/expenses`      | List expenses with pagination |
| GET    | `/api/expenses/{id}` | Get expense by ID             |
| POST   | `/api/expenses`      | Create new expense            |
| PUT    | `/api/expenses/{id}` | Update expense by ID          |
| DELETE | `/api/expenses/{id}` | Delete expense by ID          |

---
### Validation & Error Handling
- All inputs are validated via @Valid and custom validation annotations.
- Validation errors return HTTP 400 with descriptive messages.
- Not found resources return HTTP 404 with error messages.
---
### H2 Console
Access the H2 database console at:
```bash
http://localhost:8080/h2-console
```
- JDBC URL: jdbc:h2:mem:testdb
- User: sa
- Password: (leave empty)
---
### Notes
- Default categories and expenses can be loaded via import.sql or manually through API.
- Make sure Lombok plugin is installed and enabled in your IDE.
---
### License
This project is licensed under the MIT License.

---
### Contact
Created by Justfer - justfer15@gmail.com

---
