# User Registration and Fetch API

This assignment provides a RESTful API for registering and fetching user details using Spring Boot and MySQL.

## Prerequisites

- Java 8 or later
- MySQL installed and running
- Maven (for building the project)

## Setup

1. Clone the repository:

bash
git clone https://github.com/your-username/user-api.git

## Use
- you can the api using Postman
- curl http://localhost:8080/api/user/fetch?username=waghela
- curl -X POST -H "Content-Type: application/json" -d '{"username":"waghela","email":"waghela@example.com","password":"password123"}' http://localhost:8080/api/user/register
