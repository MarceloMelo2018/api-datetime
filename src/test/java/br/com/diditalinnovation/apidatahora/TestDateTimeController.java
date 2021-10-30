package br.com.diditalinnovation.apidatahora;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestDateTimeController {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

    @Test
    void ReturnDateTimeWithTimezoneDefault() {
         var method = "GET";
         var endpoint = "/date-time";

         var response = when()
                 .request(method, endpoint)
                 .then()
                 .extract()
                 .response();

         var json = response.jsonPath();

         assertEquals(HttpStatus.OK.value(), response.getStatusCode());
         assertNotNull(json.get("dateTime"));
    }

    @Test
    void ReturnThrowInvalidTimezoneException() {
        var method = "GET";
        var endpoint = "/date-time?timezone=test";

        var response = when()
                .request(method, endpoint)
                .then()
                .extract()
                .response();

        var json = response.jsonPath();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
        assertEquals("Please, provide a valid timezone!" , json.get("message"));
    }
}