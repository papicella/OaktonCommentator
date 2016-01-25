package com.ibm.bluemix.ctp.oakton.domain;

public class Rider
{
    private String riderId;
    private String cadence;
    private String speed;
    private String heartRate;

    public Rider()
    {
    }

    public Rider(String riderId, String cadence, String speed, String heartRate) {
        this.riderId = riderId;
        this.cadence = cadence;
        this.speed = speed;
        this.heartRate = heartRate;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

    public String getCadence() {
        return cadence;
    }

    public void setCadence(String cadence) {
        this.cadence = cadence;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "riderId='" + riderId + '\'' +
                ", cadence='" + cadence + '\'' +
                ", speed='" + speed + '\'' +
                ", heartRate='" + heartRate + '\'' +
                '}';
    }
}
