package ru.tusur.udo.server.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorsAggregationController {

    private static final Logger LOG = LoggerFactory.getLogger(SensorsAggregationController.class);


    @PostMapping(value = "/aggregate")
    public void aggregate(@RequestBody String nodeInfo) {
        LOG.info(nodeInfo);
    }

}
