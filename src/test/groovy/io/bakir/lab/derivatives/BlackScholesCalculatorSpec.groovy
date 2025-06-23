package io.bakir.lab.derivatives

import io.bakir.lab.derivatives.model.OptionType
import io.bakir.lab.derivatives.pricing.BlackScholesCalculator
import spock.lang.Specification

class BlackScholesCalculatorSpec extends Specification {

    def "Black-Scholes call and put prices match known values"() {
        given:
        double S = 100.0
        double K = 100.0
        double T = 1.0
        double r = 0.05
        double sigma = 0.2

        when:
        def callPrice = BlackScholesCalculator.calcPrice(OptionType.CALL, S, K, T, r, sigma)
        def putPrice = BlackScholesCalculator.calcPrice(OptionType.PUT, S, K, T, r, sigma)

        then:
        Math.abs(callPrice - 10.4506) < 1e-4
        Math.abs(putPrice  - 5.5735)  < 1e-4
    }

    def "Black-Scholes Greeks match expected values"() {
        given:
        double S = 100.0
        double K = 100.0
        double T = 1.0
        double r = 0.05
        double sigma = 0.2

        when:
        def deltaC = BlackScholesCalculator.calcDelta(OptionType.CALL, S, K, T, r, sigma)
        def deltaP = BlackScholesCalculator.calcDelta(OptionType.PUT,  S, K, T, r, sigma)
        def gamma  = BlackScholesCalculator.calcGamma(S, K, T, r, sigma)
        def vega   = BlackScholesCalculator.calcVega(S, K, T, r, sigma)
        def thetaC = BlackScholesCalculator.calcTheta(OptionType.CALL, S, K, T, r, sigma)
        def thetaP = BlackScholesCalculator.calcTheta(OptionType.PUT,  S, K, T, r, sigma)
        def rhoC   = BlackScholesCalculator.calcRho(OptionType.CALL, S, K, T, r, sigma)
        def rhoP   = BlackScholesCalculator.calcRho(OptionType.PUT,  S, K, T, r, sigma)

        then:
        Math.abs(deltaC - 0.636831) < 1e-6
        Math.abs(deltaP + 0.363169) < 1e-6
        Math.abs(gamma  - 0.018762) < 1e-6
        Math.abs(vega   - 37.524035) < 1e-6
        Math.abs(thetaC + 6.414028) < 1e-6
        Math.abs(thetaP + 1.657881) < 1e-6
        Math.abs(rhoC   - 53.232483) < 1e-6
        Math.abs(rhoP + 41.890459) < 1e-6
    }
}