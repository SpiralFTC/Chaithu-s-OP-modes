package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

/**
 * Created by SrinivasaRao on 11/24/2015.
 */
public class GryoTest extends LinearOpMode {
    DcMotor right;
    DcMotor left;
    GyroSensor gyroSensor;

    @Override
    public void runOpMode() throws InterruptedException {
        right = hardwareMap.dcMotor.get("right");

        left = hardwareMap.dcMotor.get("left");
        left.setDirection(DcMotor.Direction.REVERSE);

        gyroSensor = hardwareMap.gyroSensor.get("gyro");


       // gyroSensor.calibrate();
    }
}
