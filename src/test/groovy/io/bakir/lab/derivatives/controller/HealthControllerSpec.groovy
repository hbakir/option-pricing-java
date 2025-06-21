package io.bakir.lab.derivatives.controller

import spock.lang.Specification

class HealthControllerSpec extends Specification {

    def controller = new HealthController()

    def "should return OK"() {
        expect:
        controller.health() == "OK"
    }
}