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
import pl.sda.eprzychodnia.infrastructure.dto.VisitDto;
import pl.sda.eprzychodnia.infrastructure.type.Specialization;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/visit")
@RequiredArgsConstructor
class VisitController {

    private final static Logger LOGGER = LoggerFactory.getLogger(VisitController.class);

    private final DoctorFinder doctorFinder;
    private final DoctorService doctorService;

    @GetMapping("/create")
    ModelAndView createDoctorView() {
        ModelAndView modelAndView = new ModelAndView("createVisit.html");
        modelAndView.addObject("visit", new VisitDto());
        modelAndView.addObject("specializations",
                Arrays.stream(Specialization.values())
                    .map(spec -> new SpecializationDto(spec, spec.getLabel()))
                    .collect(Collectors.toList()));
        return modelAndView;
    }

    @PostMapping("/create")
    String createVisit(@ModelAttribute VisitDto visit) {
        //doctorService.createOrUpdate(doctor);

        System.out.println(visit);

        return "redirect:/";
    }
}
