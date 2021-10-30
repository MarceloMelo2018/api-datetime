package br.com.diditalinnovation.apidatahora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/date-time") //http://localhost:8080//date-time
public class DateTimeController {

    @GetMapping
    public Map<String, Object> returnDateTime() {
        return Map.of("dateTime", "text" );
    }
}
