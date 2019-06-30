package pl.sda.eprzychodnia.infrastructure.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.eprzychodnia.domain.DoctorFinder;
import pl.sda.eprzychodnia.domain.DoctorService;
import pl.sda.eprzychodnia.infrastructure.dto.DoctorDto;
import pl.sda.eprzychodnia.infrastructure.dto.SpecializationDto;
import pl.sda.eprzychodnia.infrastructure.type.Specialization;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
class DoctorsController {

    private final static Logger LOGGER = LoggerFactory.getLogger(DoctorsController.class);

    private final DoctorFinder doctorFinder;
    private final DoctorService doctorService;

    @GetMapping("/get/{specialization}")
    ModelAndView getDoctors(@PathVariable String specialization) {
        LOGGER.info("Trying to get doctors by specialization");


        ModelAndView modelAndView = new ModelAndView("doctors.html");
        modelAndView.addObject("specialization", specialization);
        modelAndView.addObject("doctors", doctorFinder.findBySpecialization(specialization));
        return modelAndView;
    }

    @GetMapping("/create")
    ModelAndView createDoctorView() {
        ModelAndView modelAndView = new ModelAndView("createDoctor.html");
        modelAndView.addObject("doctor", new DoctorDto());
        modelAndView.addObject("specializations",
                Arrays.stream(Specialization.values())
                    .map(spec -> new SpecializationDto(spec, spec.getLabel()))
                    .collect(Collectors.toList()));
        return modelAndView;
    }

    @PostMapping("/create")
    String createDoctor(@ModelAttribute DoctorDto doctor) {
        doctorService.createOrUpdate(doctor);

        return "redirect:/";
    }

    @GetMapping("/delete")
    String deleteDoctor(@RequestParam Long id) {
        doctorService.delete(id);

        return "redirect:/";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/edit")
    ModelAndView editDoctor(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("createDoctor.html");
        modelAndView.addObject("doctor", doctorFinder.findById(id));
        return modelAndView;
    }
}
