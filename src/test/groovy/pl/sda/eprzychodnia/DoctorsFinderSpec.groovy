package pl.sda.eprzychodnia

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.sda.eprzychodnia.domain.DoctorFinder
import pl.sda.eprzychodnia.infrastructure.dto.DoctorDto
import pl.sda.eprzychodnia.infrastructure.entity.Doctor
import pl.sda.eprzychodnia.infrastructure.repository.DoctorRepository
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@SpringBootTest
class DoctorsFinderSpec extends Specification {

    @Autowired
    private DoctorRepository doctorRepository

    @Subject
    @Autowired
    private DoctorFinder doctorFinder

    @Unroll
    def 'should find #count doctors by specialization = #specialization'() {
        given:
        def doc1 = Doctor.builder()
                .id(1).name("Adam").surname("Malysz")
                .specialization("OCULIST")
                .build()
        def doc2 = Doctor.builder()
                .id(2).name("Robert").surname("Lewandowski")
                .specialization("INTERNIST")
                .build()
        def doc3 = Doctor.builder()
                .id(3).name("Robert").surname("Kubica")
                .specialization("OCULIST")
                .build()
        doctorRepository.saveAll([doc1, doc2, doc3])
        when:
        def result = doctorFinder.findBySpecialization(specialization)
        then:
        result.size() == count
        where:
        specialization || count
        "OCULIST"      || 2
        "INTERNIST"    || 1
    }
}
