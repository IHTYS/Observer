package ru.tusur.udo.sensors.emulator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.tusur.udo.sensors.interfaces.Sensor;
import ru.tusur.udo.sensors.interfaces.SensorsRuntime;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SensorsRuntimeEmulator extends Thread
                                    implements SensorsRuntime {

    private static final Logger LOG = LoggerFactory.getLogger(SensorsRuntimeEmulator.class);

    @Value("${runtime.interval}")
    private int runtimeInterval;

    @Autowired
    private Map<String, FakeSensor> sensors;

    @PostConstruct
    public void init() {
        start();
    }


    @Override
    public List<Sensor> getSensors() {
        return sensors
                .values()
                .stream()
                .map(fakeSensor -> new Sensor() {

                    @Override
                    public String getName() {
                        return fakeSensor.getName();
                    }

                    @Override
                    public int getValue() {
                        return fakeSensor.getValue();
                    }

                    @Override
                    public String getType() {
                        return fakeSensor.getType();
                    }
                }).collect(Collectors.toList());
    }

    public void run() {

        while(true) {
            emulate();
            try {
                sleep(runtimeInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private void emulate() {
        sensors.values().forEach(sensor -> sensor.emulate());
    }


}
