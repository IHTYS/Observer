package ru.tusur.udo.sensors.dto;

import java.util.List;

public class NodeInfo {

    private String nodeName;
    long timeStamp;
    List<SensorInfo> sensors;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<SensorInfo> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorInfo> sensors) {
        this.sensors = sensors;
    }
}
