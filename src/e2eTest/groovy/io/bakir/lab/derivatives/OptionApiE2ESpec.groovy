package io.bakir.lab.derivatives

import io.bakir.lab.derivatives.controller.OptionRequest
import io.bakir.lab.derivatives.controller.OptionResponse
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.boot.test.web.client.TestRestTemplate
import io.bakir.lab.derivatives.model.OptionType
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OptionApiE2ESpec extends Specification {

    @LocalServerPort
    int port

    TestRestTemplate restTemplate = new TestRestTemplate()

    def "POST /api/option returns price and Greeks"() {
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
        def entity = restTemplate.postForEntity(
            "http://localhost:${port}/api/option", req, OptionResponse)

        then:
        entity.statusCode.value() == 200
        Math.abs(entity.body.price - 10.4506) < 1e-4
        Math.abs(entity.body.delta - 0.636831) < 1e-6
        Math.abs(entity.body.gamma  - 0.018762) < 1e-6
        Math.abs(entity.body.vega   - 37.524035) < 1e-6
        Math.abs(entity.body.theta  + 6.414028) < 1e-6
        Math.abs(entity.body.rho    - 53.232483) < 1e-6
    }
}