# Contributing to `option-pricing-java` 📈

First off, thank you for considering contributing to this project. Whether you’re fixing a bug, adding a feature, or simply sharing ideas — your input is welcome.

This project is part of a personal journey back into equity derivatives, with a focus on clean, usable tools for pricing and analytics. Contributions that respect code quality, clarity, and educational value are especially appreciated.

---

## 🧰 Project Goals

- Deliver a clean, tested Java implementation of Black-Scholes pricing.
- Make option pricing concepts accessible to developers and learners.
- Favor clarity and maintainability over micro-optimizations.

---

## 🚀 Getting Started

1. **Fork** the repository.
2. **Clone** your fork locally and checkout the `main` branch:

   ```bash
   git clone https://github.com/<your-username>/option-pricing-java.git
   cd option-pricing-java
   ```
3. Use the Gradle wrapper (`./gradlew`) as the primary build tool to compile and run tests:

   ```bash
   ./gradlew clean check
   ```

4. To launch the application locally:

   ```bash
   ./gradlew bootRun
   ```

## 🧪 Running Tests

All tests are written in Groovy using the Spock framework. To run specific suites:

```bash
# Unit tests
./gradlew test

# Integration tests
./gradlew integrationTest

# End-to-end tests
./gradlew e2eTest

# Or run them all (unit + integration + e2e)
./gradlew check
```

## 📝 Pull Request Guidelines

- Create feature branches from `main` (e.g., `feature/add-black-scholes`).
- Write clear, descriptive commit messages and reference any related issues.
- Ensure all tests pass before pushing: `./gradlew clean check`.
- Open a pull request targeting the `main` branch and describe your changes.