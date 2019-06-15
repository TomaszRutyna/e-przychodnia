package pl.sda.eprzychodnia.infrastructure.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
class MainViewController {

    @GetMapping
    ModelAndView mainView() {
        ModelAndView mav = new ModelAndView("index.html");
        mav.addObject("todayDate", LocalDate.now());
        return mav;
    }
}
