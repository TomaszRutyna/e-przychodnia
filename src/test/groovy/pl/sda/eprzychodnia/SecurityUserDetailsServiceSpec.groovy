package pl.sda.eprzychodnia

import org.springframework.security.core.userdetails.UsernameNotFoundException
import pl.sda.eprzychodnia.infrastructure.entity.User
import pl.sda.eprzychodnia.infrastructure.entity.UserRole
import pl.sda.eprzychodnia.infrastructure.repository.UserRepository
import pl.sda.eprzychodnia.infrastructure.security.SecurityUserDetailsService
import spock.lang.Specification
import spock.lang.Subject

class SecurityUserDetailsServiceSpec extends Specification {

    def userRepository = Mock(UserRepository)

    @Subject
    def sut = new SecurityUserDetailsService(userRepository)

    def "should map user when exist"() {
        when:
        def result = sut.loadUserByUsername("login")
        then:
        1 * userRepository.findByLogin("login") >>
                User.builder().id(1).login("login")
                    .password("asd")
                    .roles(new HashSet<UserRole>())
                    .build()
        and:
        result.username == "login"
        result.password == "asd"
        result.authorities.isEmpty()
    }

    def "should throw exception when user not exist"() {
        when:
        sut.loadUserByUsername("login")
        then:
        1 * userRepository.findByLogin("login") >> null
        thrown(UsernameNotFoundException)
    }
}
