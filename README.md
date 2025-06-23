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
## Prerequisites

- Java 17 or higher
- Git

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

## Running the application

You can start the Spring Boot service via the Gradle wrapper:

```bash
./gradlew bootRun
```

By default, the server listens on port 8080. Check health with:

```bash
curl http://localhost:8080/
# OK
```

## Pricing API

Retrieve option prices and Greeks via REST:

```bash
curl -X POST http://localhost:8080/api/option \
  -H "Content-Type: application/json" \
  -d '{
    "type":"CALL",
    "spot":100.0,
    "strike":100.0,
    "timeToMaturity":1.0,
    "riskFreeRate":0.05,
    "volatility":0.2
  }'
```

Sample JSON response:

```json
{
  "price":10.4506,
  "delta":0.636831,
  "gamma":0.018762,
  "vega":37.524035,
  "theta":-6.414028,
  "rho":53.232483
}
```

## Motivation

I worked on the exotic derivatives desk in the late 90s as a UI developer. This is my way of returning — not as a trader
or quant, but as an architect who can build the right tools for the domain.

## License

- MIT License

Copyright (c) 2025 Hicham BAKIR

📌 Note: This project is released under the MIT License. Attribution is appreciated. Use responsibly.

## Building and Testing

Use the included Gradle wrapper (`./gradlew`) as the main build tool to compile and test:

```bash
./gradlew clean check
```

Tests are written in Groovy using the Spock framework and organized into:

- **Unit tests** (`src/test/groovy`)
- **Integration tests** (`src/integrationTest/groovy`)
- **End-to-end tests** (`src/e2eTest/groovy`)

## Continuous Integration

A GitHub Actions workflow is configured in `.github/workflows/ci.yml` to run tests on push and pull requests to `main`. Merges to `main` should require passing this CI.

## Contributing & Code of Conduct

Contributions are welcome! Please review [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines on how to contribute, and [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) for community standards.

