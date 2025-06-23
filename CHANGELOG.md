# Changelog

All notable changes to this project are documented in this file.

## [2025-06-23]
### Added
- Gradle wrapper (Gradle 8.14.2) and build configuration for Spring Boot, Groovy, Spock, and multi-stage tests (unit, integration, end-to-end).
- `OptionType` enum in `io.bakir.lab.derivatives.model` and `BlackScholesCalculator` in `io.bakir.lab.derivatives.pricing` with implementations of price, delta, gamma, vega, theta, and rho.
- REST API under `/api/option` via `BlackScholesController`, with DTOs `OptionRequest` and `OptionResponse`.
- Health endpoint (`/`) via `HealthController`.
- Spock unit tests for pricing and controller behavior; Spock integration test for application context; Spock end-to-end tests for REST endpoints.
- GitHub Actions workflow (`.github/workflows/ci.yml`) enforcing `./gradlew clean check` on push/PR to `main`.
- Documentation updates:
  - README.md with build, test, API usage, contributing, and code of conduct sections.
  - CONTRIBUTING.md aligned to Gradle wrapper, Spock/Groovy, and test suite structure.
  - Added `CODE_OF_CONDUCT.md` reference in README.