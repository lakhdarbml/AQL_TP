# TP3: Integration Testing with Testcontainers and Spring Boot

## Overview
This project implements integration tests for a Spring Boot application using Testcontainers and Docker, as part of TP3. The goal is to set up a MySQL database in a Docker container for reliable integration testing, replacing mocked or in-memory databases. The provided test verifies that the Spring Boot application context loads successfully with a MySQL container.

## Objectives
- Learn Docker fundamentals: images, containers, registries, and Docker Compose.
- Use Testcontainers to run integration tests with a MySQL container.
- Replace mocked/in-memory databases with a real database for robust testing.
- Document the setup, test execution, and observations in this README.

## Prerequisites
- Java 8 or higher
- IntelliJ IDEA
- Docker installed and running
- Maven
- Internet connection
- GitHub account for code sharing

## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/your-repo.git
   cd your-repo
   ```
2. **Install Dependencies**:
   
3. **Ensure Docker is Running**:
   - Install Docker: [Docker Installation](https://docs.docker.com/get-docker/).
   - Verify: `docker --version`.
4. **Run Tests**:
   ```bash
   mvn test
   ```

## Implementation Details
The integration test is implemented in `MyIntegrationTest.java` under the `org.example.tp3` package. Key components:

- **Testcontainers Setup**:
  - A MySQL 5.7 container is configured with:
    - Database name: `tp3db`
    - Username: `root`
    - Password: (empty)
  - Testcontainers automatically starts and stops the container.
- **Spring Boot Integration**:
  - Uses `@SpringBootTest` to load the `DemoApplication` context.
  - `@DynamicPropertySource` configures the Spring datasource with the MySQL container's JDBC URL, username, and password.
- **Test Case**:
  - The `contextLoads` test checks if the MySQL container is running, ensuring the application context loads correctly.


## Test Analysis
- **Original Approach** (assumed):
  - Previous tests likely used an in-memory database (e.g., H2) or mocked repositories.
  - **Limitations**:
    - In-memory databases do not replicate MySQL-specific behaviors (e.g., SQL syntax, transaction handling).
    - Mocks bypass real service interactions, reducing test reliability.
- **Testcontainers Approach**:
  - Uses a real MySQL 5.7 container for production-like testing.
  - **Advantages**:
    - Realistic database environment improves test accuracy.
    - Automated container management simplifies test setup.
    - Consistent results across different machines.
  - **Disadvantages**:
    - Slower test execution due to container startup (~5-10 seconds).
    - Requires Docker installation and configuration.
- **Coverage**:
  - The `contextLoads` test verifies container initialization and context loading.
  - Limited to basic setup; no application-specific logic (e.g., CRUD operations) is tested.
- **Maintainability**:
  - Code is simple and reusable for additional tests.
  - Easy to modify for different database versions or configurations.
- **Reliability**:
  - Real MySQL interactions ensure accurate testing of datasource configuration.

## Remarques
- **Empty Password**: The MySQL container is configured with an empty password (`.withPassword("")`). This may cause compatibility issues with MySQL 5.7, as it often requires a non-empty password. A secure password (e.g., `.withPassword("password")`) is recommended to avoid potential connection errors.
- **Limited Test Scope**: The implementation includes only a `contextLoads` test, which verifies the container and context setup but does not test application functionality (e.g., task management). TP3 expects tests for CRUD operations (create, read, update, delete tasks), as shown in the provided example. Expanding the test suite would better align with the assignment goals.
- **MySQL Version**: MySQL 5.7 is used, which is functional but outdated. MySQL 8.0, as referenced in TP3's dependency example (`mysql-connector-java:8.0.30`), would ensure compatibility with modern features and the connector.
- **Test Coverage**: The single test provides minimal coverage. Adding tests for task creation, retrieval, and deletion would improve coverage and demonstrate the task management functionality outlined in TP3.
- **Error Handling**: The test does not include error cases (e.g., invalid database configuration or connection failures). Including such tests would enhance robustness.
- **Code Organization**: The test is well-structured, but the package name (`org.example.tp3`) could be more specific (e.g., `org.example.taskmanager.test`) to reflect the task management focus.
