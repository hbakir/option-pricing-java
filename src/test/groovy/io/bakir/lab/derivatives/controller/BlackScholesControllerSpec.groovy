package io.bakir.lab.derivatives.controller

import io.bakir.lab.derivatives.model.OptionType
import spock.lang.Specification


class BlackScholesControllerSpec extends Specification {

    def controller = new BlackScholesController()

    def "calculate returns correct price and Greeks for a call option"() {
        given:
        def req = new OptionRequest(
            type: OptionType.CALL,
            spot: 100.0,
            strike: 100.0,
            timeToMaturity: 1.0,
            riskFreeRate: 0.05,
            volatility: 0.2
        )

        when:
        def res = controller.calculate(req)

        then:
        Math.abs(res.price - 10.4506) < 1e-4
        Math.abs(res.delta - 0.636831) < 1e-6
        Math.abs(res.gamma  - 0.018762) < 1e-6
        Math.abs(res.vega   - 37.524035) < 1e-6
        Math.abs(res.theta  + 6.414028) < 1e-6
        Math.abs(res.rho    - 53.232483) < 1e-6
    }

    def "calculate returns correct price and Greeks for a put option"() {
        given:
        def req = new OptionRequest(
            type: OptionType.PUT,
            spot: 100.0,
            strike: 100.0,
            timeToMaturity: 1.0,
            riskFreeRate: 0.05,
            volatility: 0.2
        )

        when:
        def res = controller.calculate(req)

        then:
        Math.abs(res.price - 5.5735) < 1e-4
        Math.abs(res.delta + 0.363169) < 1e-6
        Math.abs(res.gamma  - 0.018762) < 1e-6
        Math.abs(res.vega   - 37.524035) < 1e-6
        Math.abs(res.theta  + 1.657881) < 1e-6
        Math.abs(res.rho    + 41.890459) < 1e-6
    }
}