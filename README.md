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
   git clone https://github.com/yourusername/expense-tracker.git
   cd expense-tracker
