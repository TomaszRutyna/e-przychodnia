package pl.sda.eprzychodnia

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.DataIntegrityViolationException
import pl.sda.eprzychodnia.infrastructure.entity.User
import pl.sda.eprzychodnia.infrastructure.repository.UserRepository
import spock.lang.Specification

@SpringBootTest
class UserRepositorySpec extends Specification {

    @Autowired
    private UserRepository userRepository

    def setup() {
        userRepository.deleteAll()
    }

    def 'should create user'() {
        given:
        def user = User.builder().login("asd")
                .password("asd").build()
        when:
        userRepository.save(user)
        then:
        userRepository.count() == 1
    }

    def 'should not create user when login exists'() {
        given:
        def existingUser = User.builder().login("asd")
                .password("asd").build()
        userRepository.save(existingUser)
        def user = User.builder().login("asd")
                .password("dsa").build()
        when:
        userRepository.save(user)
        then:
        def ex = thrown(DataIntegrityViolationException)
        userRepository.count() == 1
    }
}
