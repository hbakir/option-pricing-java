package io.bakir.lab.derivatives.controller;

import io.bakir.lab.derivatives.model.OptionType;

/**
 * DTO for Black-Scholes option pricing request.
 */
public class OptionRequest {
    private OptionType type;
    private double spot;
    private double strike;
    private double timeToMaturity;
    private double riskFreeRate;
    private double volatility;

    public OptionRequest() {
    }

    public OptionType getType() {
        return type;
    }

    public void setType(OptionType type) {
        this.type = type;
    }

    public double getSpot() {
        return spot;
    }

    public void setSpot(double spot) {
        this.spot = spot;
    }

    public double getStrike() {
        return strike;
    }

    public void setStrike(double strike) {
        this.strike = strike;
    }

    public double getTimeToMaturity() {
        return timeToMaturity;
    }

    public void setTimeToMaturity(double timeToMaturity) {
        this.timeToMaturity = timeToMaturity;
    }

    public double getRiskFreeRate() {
        return riskFreeRate;
    }

    public void setRiskFreeRate(double riskFreeRate) {
        this.riskFreeRate = riskFreeRate;
    }

    public double getVolatility() {
        return volatility;
    }

    public void setVolatility(double volatility) {
        this.volatility = volatility;
    }
}