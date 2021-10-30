package br.com.diditalinnovation.apidatahora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;

@RestController
@RequestMapping("/date-time") //http://localhost:8080/date-time
public class DateTimeController {

    @GetMapping
    public Map<String, Object> returnDateTime(
            @RequestParam(value = "timezone", defaultValue = "America/Sao_Paulo") String timezone //QUERY PARAM
    ) {
        var zone = ZoneId.of(timezone);
        var dateTime = LocalDateTime.ofInstant(Instant.now(), zone);
        return Map.of("dateTime", dateTime);
    }
}