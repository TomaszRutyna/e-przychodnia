package pl.sda.eprzychodnia

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.ModelResultMatchers

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

import spock.lang.Specification

@AutoConfigureMockMvc
@SpringBootTest(
        webEnvironment =
                SpringBootTest.WebEnvironment.RANDOM_PORT)
class DoctorsControllerSpec extends Specification {

    @Autowired
    private MockMvc mockMvc;

    def 'should get page with doctors'() {
        when:
        def result = mockMvc.perform(
                get("/doctor/get/OCULIST"))
                .andDo(print())
        then:
        result
            .andExpect(model().attribute("specialization",
                containsString("OCULIST")))
            .andExpect(status().isOk())
            .andExpect(content().string(
                containsString("Doktorzy w specjalizacji " +
                        "<span>OCULIST</span>")))
    }
}
