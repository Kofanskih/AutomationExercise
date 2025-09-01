# Demo QA Automation Project

This repository is a demo project created to showcase my skills in test automation for both **UI** and **API** testing.  
It contains multiple independent modules, each demonstrating the use of a popular automation framework.

---

## 📂 Project Structure

### UI Testing
- **ui-selenium** – classic WebDriver-based UI tests
- **ui-selenide** – concise and readable UI tests using the Selenide framework
- **ui-playwright** – modern and fast UI tests with Microsoft Playwright

### API Testing
- **api-restassured** – automated API tests for REST endpoints

---

## 🛠️ Technologies Used

- **Java 17+**
- **Maven**
- **TestNG**
- **Selenium / Selenide / Playwright**
- **Rest-Assured**
- **Allure Report** for reporting
- **Jenkins (CI/CD)** – *planned integration*
- **Docker** – *planned integration*

---

## 🎯 Goals

The main goal of this project is to demonstrate:
- Strong knowledge of modern test automation tools
- Ability to design modular and maintainable test frameworks
- Skills in writing clean, readable, and reliable tests
- Experience with both UI and API automation approaches

---

## 🧩 Dependencies Overview

### 🔹 Common
- **TestNG** – testing framework
- **AspectJ Weaver** – AOP support (used by Allure & proxies)
- **Allure (testng / selenide / commons)** – reporting integration
- **DataFaker** – random test data generation
- **Lombok** – boilerplate code reduction
- **Owner** – configuration via properties

### 🔹 UI: Selenium
- **Selenium Java** – classic WebDriver API
- **WebDriverManager** – automatic driver management

### 🔹 UI: Selenide
- **Selenide** – simplified UI testing wrapper over Selenium

### 🔹 UI: Playwright
- **Playwright (Java)** – modern UI automation with high speed

### 🔹 API: Rest-Assured
- **Rest-Assured** – API testing library
- **Jackson (annotations + databind)** – JSON serialization/deserialization
- **Jsoup** – HTML parsing

---


## ▶️ How to Run

Each module is independent and can be executed separately.

Examples:

```bash
# Run UI tests
mvn test -pl ui-selenium
mvn test -pl ui-selenide
mvn test -pl ui-playwright

# Run API tests
mvn test -pl api-restassured
```

---

## 🚀 Roadmap

This project is actively evolving. Planned improvements include:

- Full CI/CD integration with Jenkins pipelines
- Dockerized test execution for easier setup
- Expanding test coverage with more complex scenarios
- Adding parallel execution for faster runs
- Experimenting with new automation tools and libraries

---

## 📌 Notes

This repository is a demo project and is continuously being updated.
Some parts may remain in progress as I explore and add new features.