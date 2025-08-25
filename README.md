# Demo QA Automation Project

This repository is a **demo project** created to showcase my skills in **test automation** for both UI and API testing.  
It contains multiple independent modules, each demonstrating the use of a popular automation framework.

## Project Structure

- **UI Testing**
  - `ui-selenium` – classic WebDriver-based UI tests
  - `ui-selenide` – concise and readable UI tests using the Selenide framework
  - `ui-playwright` – modern and fast UI tests with Microsoft Playwright

- **API Testing**
  - `api-restassured` – automated API tests for REST endpoints

## Technologies Used

- **Java 17+**
- **Maven**
- **TestNG**
- **Selenium / Selenide / Playwright**
- **Rest-Assured**
- **Allure Report** for test reporting

## Goals

The main goal of this project is to demonstrate:
- Strong knowledge of modern test automation tools
- Ability to design modular and maintainable test frameworks
- Skills in writing clean, readable, and reliable tests
- Experience with both **UI** and **API** automation approaches

## How to Run

Each module is independent and can be executed separately.  
Examples:
```bash
# Run UI tests
mvn test -pl ui-selenium
mvn test -pl ui-selenide
mvn test -pl ui-playwright

# Run API tests
mvn test -pl api-restassured
