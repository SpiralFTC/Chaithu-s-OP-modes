package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.LightSensor;


public class LightTest extends OpMode {
    LightSensor light;
    // OpticalDistanceSensor yo;
    @Override
    public void init() {
        light = hardwareMap.lightSensor.get("nxt");
    }

    @Override
    public void loop() {

        telemetry.addData("EOPD",light.getLightDetected());

    }

    @Override
    public void stop() {
        super.stop();
    }
}