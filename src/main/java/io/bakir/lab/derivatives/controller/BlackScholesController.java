package io.bakir.lab.derivatives.controller;

import io.bakir.lab.derivatives.model.OptionType;
import io.bakir.lab.derivatives.pricing.BlackScholesCalculator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller exposing Black-Scholes pricing and Greeks calculation endpoints.
 */
@RestController
@RequestMapping("/api/option")
public class BlackScholesController {

    /**
     * Calculates price and all standard Greeks for a European option.
     *
     * @param req option parameters payload
     * @return pricing and Greeks in the response body
     */
    @PostMapping
    public OptionResponse calculate(@RequestBody OptionRequest req) {
        OptionType type = req.getType();
        double S = req.getSpot();
        double K = req.getStrike();
        double T = req.getTimeToMaturity();
        double r = req.getRiskFreeRate();
        double sigma = req.getVolatility();

        double price = BlackScholesCalculator.calcPrice(type, S, K, T, r, sigma);
        double delta = BlackScholesCalculator.calcDelta(type, S, K, T, r, sigma);
        double gamma = BlackScholesCalculator.calcGamma(S, K, T, r, sigma);
        double vega = BlackScholesCalculator.calcVega(S, K, T, r, sigma);
        double theta = BlackScholesCalculator.calcTheta(type, S, K, T, r, sigma);
        double rho = BlackScholesCalculator.calcRho(type, S, K, T, r, sigma);

        return new OptionResponse(price, delta, gamma, vega, theta, rho);
    }
}