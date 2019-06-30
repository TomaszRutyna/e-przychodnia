package pl.sda.eprzychodnia

import pl.sda.eprzychodnia.domain.DoctorService
import pl.sda.eprzychodnia.infrastructure.dto.DoctorDto
import pl.sda.eprzychodnia.infrastructure.entity.Doctor
import pl.sda.eprzychodnia.infrastructure.repository.DoctorRepository
import spock.lang.Specification
import spock.lang.Subject

class DoctorsServiceSpec extends Specification {

    def repository = Mock(DoctorRepository)

    @Subject
    def sut = new DoctorService(repository)

    def 'should create new doctor'() {
        given:
        def dto = DoctorDto.builder()
                .name("Adam")
                .surname("Malysz")
                .specialization("OCULIST")
                .build()
        when:
        sut.createOrUpdate(dto)
        then:
        1 * repository.save({
                it.name == "Adam" &&
                it.surname == "Malysz" &&
                it.specialization == "OCULIST"} as Doctor)
    }
}
