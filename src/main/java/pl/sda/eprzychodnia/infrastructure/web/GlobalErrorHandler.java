package pl.sda.eprzychodnia.infrastructure.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Throwable.class)
    String handleError(Throwable ex) {
        return "error.html";
    }

}
