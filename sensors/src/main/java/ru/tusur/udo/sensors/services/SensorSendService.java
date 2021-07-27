package ru.tusur.udo.sensors.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.tusur.udo.sensors.interfaces.SensorsRuntime;

import javax.annotation.PostConstruct;

@Service
public class SensorSendService extends Thread {

    private static final Logger LOG = LoggerFactory.getLogger(SensorSendService.class);

    @Value("${polling.interval}")
    private int pollingInterval;

    @Autowired
    SensorsRuntime sensorsRuntime;

    @Autowired
    NodeInfoService nodeInfoService;


    @PostConstruct
    public void init() {
        start();
    }

    public void run() {

        while(true) {
            send(nodeInfoService.serialize(sensorsRuntime.getSensors()));
            try {
                sleep(pollingInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void send(String payload) {
        LOG.warn(" ___NEED FOR SEND IMPLEMENTATION__");
        LOG.info(payload);
    }


}
