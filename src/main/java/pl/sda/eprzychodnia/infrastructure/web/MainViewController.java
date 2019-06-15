package pl.sda.eprzychodnia.infrastructure.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class MainViewController {

    @GetMapping
    String mainView() {
        return "index.html";
    }
}
