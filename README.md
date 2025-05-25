# AqlTp - Software Testing with JUnit, Mockito, and Testcontainers

## Overview
This project, `AqlTp`, implements a series of practical assignments (TP0, TP1, TP2, TP3) focused on software testing in a Spring Boot application. The TPs cover unit testing with JUnit 5, mocking with Mockito, and integration testing with Testcontainers and Docker. The goal is to develop and validate robust testing practices for a task management application, ensuring high code coverage and reliable behavior.

## Objectives
- **TP0**: Learn to set up and write basic unit tests using JUnit 5.
- **TP1**: Achieve advanced unit testing with code coverage analysis (lines, branches, conditions) and bug fixing.
- **TP2**: Apply mocking with Mockito to isolate components and test interactions.
- **TP3**: Implement integration tests using Testcontainers and Docker for a realistic database environment.

## Prerequisites
- Java 17
- IntelliJ IDEA
- Docker installed and running (for TP3)
- Maven
- Internet connection
- GitHub account for code sharing

**Run Tests**:
   ```bash
   mvn test
   ```

## Project Structure
```
AQL_TP/
├── .gitignore           # Git ignore configuration
├── pom.xml              # Maven configuration for dependencies and build
├── README.md            # Main project documentation covering TP0-TP3
├── tp0 /src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/
│   │           
│   └── test/
│       └── java/
│           └── org/example/
│── tp1 /src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/
│   │           
│   └── test/
│       └── java/
│           └── org/example/
── tp2 /src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/
│   │           
│   └── test/
│       └── java/
│           └── org/example/
── tp3 /src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/
│   │           
│   └── test/
│       └── java/
│           └── org/example/               
├── README_tp0.md        # TP0 documentation
├── README_tp1.md        # TP1 documentation
├── README_tp2.md        # TP2 documentation
└── README_tp3_partie2.md  # TP3 documentation
```

## TP Details

### TP0: Unit Testing with JUnit 5
- **Objective**: Learn to configure JUnit 5 and write basic unit tests.
- **Exercises**:
  - **Person**: Tested `getFullName()` and `isAdult()` for correct name concatenation and age checks.
  - **Stack**: Tested `push()`, `pop()`, `peek()`, `isEmpty()`, `size()`, and edge cases (empty/full stack).
  - **Fibonacci**: Tested `fibonacci(n)` for base cases, recursive cases, and negative inputs.
  - **Prime**: Tested `isPrime(n)` for prime, non-prime, and edge cases (0, 1, 2, negative).
  - **Factorial**: Tested `factorial(n)` for base case (0), normal cases, and negative inputs.
  - **Bonus**: Tested `BankAccount` (deposit, withdraw, transfer) and `Matrix` operations (add, multiply, transpose).
- **Key Features**:
  - Used JUnit 5 annotations (`@Test`, `@ParameterizedTest`) and assertions.
  - Configured Maven dependencies for JUnit 5.
- **Results**: All tests passed, covering basic functionality and edge cases.

### TP1: Advanced Unit Testing & Code Coverage
- **Objective**: Achieve 100% code coverage (lines, branches, conditions) and fix bugs.
- **Exercises**:
  - **Palindrome**: Fixed loop indices (`i--`, `j++`) for correct string comparison.
  - **Anagram**: Corrected loop bound (`i < length`) for valid character checks.
  - **BinarySearch**: Fixed loop condition (`low <= high`) for proper search.
  - **QuadraticEquation**: Corrected `delta` cases to return proper roots or `null`.
  - **RomanNumeral**: Fixed loop bound to prevent `ArrayIndexOutOfBoundsException`.
  - **FizzBuzz**: Corrected condition order and boundary (`n <= 1`) for proper outputs.
- **Key Features**:
  - Used IntelliJ’s coverage tool to verify 100% coverage for lines, branches, and conditions.
  - Tests written to fail on buggy versions, then passed after fixes.
- **Results**: Achieved 100% coverage across all exercises (see `README_tp1.md`).

### TP2: Unit Testing with JUnit 5 and Mockito
- **Objective**: Use Mockito to mock dependencies and test interactions.
- **Exercises**:
  - **Calculatrice**: Tested `additionner` method with mocked behavior.
  - **UserService**: Mocked `UtilisateurApi` to test user creation, exception handling, and ID return.
  - **Jeu**: Mocked `Joueur`, `Banque`, and `De` to test game scenarios (closed game, insolvent player, dice sum).
- **Key Features**:
  - Used Mockito’s `when()`, `verify()`, and `ArgumentCaptor` for interaction testing.
  - Tested state (e.g., game closed) and interactions (e.g., method calls).
  - Included real `BanqueConcrete` implementation for integrated testing.
- **Results**: All tests passed, validating isolated and integrated behaviors (see `README_tp2.md`).

### TP3: Integration Testing with Testcontainers
- **Objective**: Use Testcontainers and Docker for integration tests with a MySQL database.
- **Implementation**:
  - Test class: `MyIntegrationTest.java` in `org.example.tp3`.
  - Configures a MySQL 5.7 container (`tp3db`, `root`, empty password).
  - Uses `@SpringBootTest` and `@DynamicPropertySource` to integrate with Spring Boot.
  - Tests context loading to verify container initialization.
- 
## Running Tests
- Run all tests: `mvn test`.
- For TP1 coverage: In IntelliJ, right-click `src/test/java` and select “Run with Coverage.”
- Ensure Docker is running for TP3 tests (`docker ps`).

## Docker Usage (TP3)
- **Image**: `mysql:5.7` from Docker Hub.
- **Container**: Managed by Testcontainers, auto-started/stopped.
- **Future Work**: Add a `Dockerfile` for the Spring Boot app and use Docker Compose for multi-container setups.


## Conclusion
This project demonstrates a progression from basic unit testing (TP0) to advanced coverage (TP1), mocking (TP2), and integration testing with Testcontainers (TP3). While TP3’s implementation is minimal, it successfully integrates a MySQL container. Expanding TP3 with CRUD tests would fully align with the task management focus.

## Resources
- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)
- [Mockito Documentation](https://site.mockito.org/)
- [Testcontainers Documentation](https://java.testcontainers.org/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)

## Authors
-  (bouchemal_Lakhdar) SIAD
- Developed for software quality and testing coursework.