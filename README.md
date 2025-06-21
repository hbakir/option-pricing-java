# Option Pricing in Java 📈

This project implements a core Black-Scholes pricing engine for European options in pure Java, along with Greek
calculators. It’s the first in a series of projects reconnecting with equity derivatives after 25 years — with a modern
tech mindset.

## Features

- ✅ Black-Scholes pricing for calls and puts
- ✅ Calculation of Greeks: delta, gamma, theta, vega, rho
- ✅ Implied volatility solver (coming soon)
- ✅ CLI or REST interface (planned)
- ✅ 100% unit tested

## Usage

```java
BlackScholesCalculator.calcPrice(
    OptionType.CALL,
    spotPrice,
    strikePrice,
    timeToMaturity,
    riskFreeRate,
    volatility
);
```

## Motivation

I worked on the exotic derivatives desk in the late 90s as a UI developer. This is my way of returning — not as a trader
or quant, but as an architect who can build the right tools for the domain.

## License

- MIT License

Copyright (c) 2025 Hicham BAKIR

📌 Note: This project is released under the MIT License. Attribution is appreciated. Use responsibly.

## Building and Testing

Use the Gradle Wrapper to build and test the project:

```bash
./gradlew clean check
```

Tests are organized into:

- **Unit tests** (src/test/groovy)
- **Integration tests** (src/integrationTest/groovy)
- **End-to-end tests** (src/e2eTest/groovy)

## Continuous Integration

A GitHub Actions workflow is configured in `.github/workflows/ci.yml` to run tests on push and pull requests to `main`. Merges to `main` should require passing this CI.

