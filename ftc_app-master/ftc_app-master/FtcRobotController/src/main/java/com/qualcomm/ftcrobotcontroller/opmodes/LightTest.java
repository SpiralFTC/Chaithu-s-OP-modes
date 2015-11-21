package com.qualcomm.ftcrobotcontroller.opmodes;

import android.graphics.Color;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;


public class LightTest extends OpMode {
    LightSensor light;
    DcMotor right;
    DcMotor left;

    // OpticalDistanceSensor yo;
    @Override
    public void init() {
        //light = hardwareMap.colorSensor.get("LightSensor");
        light = hardwareMap.lightSensor.get("LightSensor");

        right = hardwareMap.dcMotor.get("right");


        left = hardwareMap.dcMotor.get("left");
        left.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        light.enableLed(true);

       /* telemetry.addData("Value: ", light.red());
        telemetry.addData("Value: ", light.blue());
        telemetry.addData("Value: ", light.green());


*/
        telemetry.addData("Value: ",light.getLightDetected());
    }

    @Override
    public void stop() {
        super.stop();
    }
}