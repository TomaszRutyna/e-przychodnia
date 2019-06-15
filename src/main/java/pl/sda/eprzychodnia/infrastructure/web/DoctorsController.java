package pl.sda.eprzychodnia.infrastructure.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.eprzychodnia.domain.DoctorFinder;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
class DoctorsController {

    private final DoctorFinder doctorFinder;

    @GetMapping("/{specialization}")
    ModelAndView getDoctors(@PathVariable String specialization) {
        ModelAndView modelAndView = new ModelAndView("doctors.html");
        modelAndView.addObject("specialization", specialization);
        modelAndView.addObject("doctors", doctorFinder.findBySpecialization(specialization));
        return modelAndView;
    }

}
