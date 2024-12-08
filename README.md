# Spring Boot REST API for Product Management (DDD & Hexagonal Approximation)

This repository implements a REST API for managing a list of products, showcasing an approximation of Domain-Driven Design (DDD) and Hexagonal Architecture principles.

**Technologies:**

* Java 17
* Spring Boot
* JPA (for data persistence)
* H2 in memory database (for integration tests and application start)
* JUnit (for unit testing)
* Mockito (for mocking dependencies)
* Spring Test (for integration testing)
* OpenAPI (for API documentation)
* Maven openapi plugin for API code generation

**Project Structure:**

* **src/main/java:** Contains the application source code.
    * **domain:** Domain model entities and repositories (interfaces).
    * **application:** Use cases.
    * **infrastructure:** Infrastructure layer with data access implementations (repositories) and REST API controllers and request/response models.
* **src/test/java:** Unit and integration test cases.
* **pom.xml:** Project dependencies and configuration.

**DDD and Hexagonal Architecture Approximation:**

This project aims to follow DDD principles by separating concerns: domain logic, application logic, and infrastructure. Additionally, it loosely couples the business core policies from external frameworks with a focus on ports and adapters for integration.

**API Documentation with OpenAPI:**

This project integrates SpringDoc OpenAPI to automatically generate comprehensive API documentation in OpenAPI 3.0 format. This documentation serves also as a contract to endpoint API code generation

**Testing:**

* Unit tests cover most of the code
* Integration tests focus on repository interactions and overall API functionality.

**Running the Application:**

1. Ensure you have Java 17 and Maven (3.9.5) installed.
2. Clone the repository.
3. Run `mvn clean package`.
4. Run `mvn spring-boot:run`.