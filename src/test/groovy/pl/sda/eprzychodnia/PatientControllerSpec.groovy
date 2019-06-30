package pl.sda.eprzychodnia

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Import
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import pl.sda.eprzychodnia.infrastructure.client.patients.dto.PatientDto
import spock.lang.Specification

@Import([PatientClientConfig])
@SpringBootTest(
        webEnvironment =
                SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatientControllerSpec extends Specification {

    @Autowired
    private TestRestTemplate restTemplate

    def "should get all patients"() {
        when:
            def result = restTemplate.exchange(
                    "/patient",
                    HttpMethod.GET,
                    new HttpEntity<Object>(),
                    new ParameterizedTypeReference<List<PatientDto>>() {})
        then:
            def patients = result.getBody()

            with (patients.first() as PatientDto) {
                firstName == "Adam"
                lastName == "Malysz"
                id == 1
            }
    }

    def "should create patient"() {
        given:
        def patientJSON = "{\"id\":1,\n" +
                "\"firstName\":\"Adam\",\n" +
                "\"lastName\":\"Malysz\",\n" +
                "\"pesel\":null}"
        def httpHeaders = new HttpHeaders()
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8)
        def httpEntity = new HttpEntity<String>(patientJSON, httpHeaders)
        when:
        def result = restTemplate.exchange(
                "/patient",
                HttpMethod.POST,
                httpEntity,
                Object)
        then:
        result.statusCodeValue == 201
    }

}


