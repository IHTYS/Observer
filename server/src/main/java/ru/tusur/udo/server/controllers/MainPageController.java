package ru.tusur.udo.server.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class MainPageController {

    @GetMapping
    public String index() {
        return "<h2>index page</h2>";
    }


    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map info() {
        return Collections.singletonMap("version", "1.0");
    }

}
