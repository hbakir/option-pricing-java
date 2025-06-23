package io.bakir.lab.derivatives.controller;

/**
 * DTO for Black-Scholes option pricing response, including price and Greeks.
 */
public class OptionResponse {
    private double price;
    private double delta;
    private double gamma;
    private double vega;
    private double theta;
    private double rho;

    public OptionResponse() {
    }

    public OptionResponse(double price,
                          double delta,
                          double gamma,
                          double vega,
                          double theta,
                          double rho) {
        this.price = price;
        this.delta = delta;
        this.gamma = gamma;
        this.vega = vega;
        this.theta = theta;
        this.rho = rho;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getGamma() {
        return gamma;
    }

    public void setGamma(double gamma) {
        this.gamma = gamma;
    }

    public double getVega() {
        return vega;
    }

    public void setVega(double vega) {
        this.vega = vega;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getRho() {
        return rho;
    }

    public void setRho(double rho) {
        this.rho = rho;
    }
}