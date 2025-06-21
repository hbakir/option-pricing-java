package io.bakir.lab.derivatives

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.server.LocalServerPort
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationE2ESpec extends Specification {

    @LocalServerPort
    int port

    @Autowired
    TestRestTemplate restTemplate

    def "GET / returns OK"() {
        when:
        def entity = restTemplate.getForEntity("http://localhost:${port}/", String)

        then:
        entity.statusCode.value() == 200
        entity.body == "OK"
    }
}