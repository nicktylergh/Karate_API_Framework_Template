# Karate API Framework Template

This is a template version of a production-grade **Karate API testing framework**.  
All sensitive information has been removed. The template demonstrates structure, utilities, and best practices for scalable API automation.

---

## Tech Stack
- **Language**: Java
- **Framework**: Karate DSL
- **Build Tool**: Maven
- **Reporting**: Karate Reports (HTML, JSON)
- **CI/CD**: Jenkins (example pipeline ready)
- **Utilities**: Java helpers (DB, JSON, Data generation)

---

## Project Structure
Karate_API_Framework_Template/
├── src/
│ └── test/
│ ├── java/
│ │ ├── data.globalUserApiUS/ # Request body JSON files
│ │ ├── features/ # Main feature files (API test cases)
│ │ ├── helpers/ # Reusable helper features (auth, headers, test data)
│ │ ├── runners/ # Test runners (parallel execution, etc.)
│ │ └── utils/ # Java utility classes
│ │ ├── Constants.java
│ │ ├── DataGenerator.java
│ │ ├── DBUtils.java
│ │ └── JsonFileUtils.java
│ └── resources/
│ └── config/ # Configurations
│ ├── ApiServerData.json
│ ├── Environment.json
│ └── FilePath.json
├── pom.xml # Maven dependencies & build config
├── karate-config.js # Karate global configuration
└── README.md # Project documentation


---

## Utilities
- **Constants.java** – Stores global variables and config values.
- **DataGenerator.java** – Generates dynamic test data using Faker.
- **DBUtils.java** – Handles database connectivity and queries.
- **JsonFileUtils.java** – Reads, modifies, and updates JSON test data.

---

## Features
- **Feature files** define API tests directly in Gherkin syntax.
- **Helpers** provide reusable steps for authentication, headers, and test data.
- **Runners** allow tests to be executed in parallel for faster execution.

---

## Reporting
- Built-in **Karate Reports** provide HTML & JSON test execution summaries.
- Reports display request/response payloads, execution steps, and status (green = pass, red = fail).

---

## Purpose
This repo serves as a **clean template** for setting up API automation with Karate.  
It demonstrates:
- Organized folder structure
- Configuration management
- Utility-driven design
- Reusable feature files
- Clear reporting

Use this template to quickly bootstrap new Karate-based automation projects.
