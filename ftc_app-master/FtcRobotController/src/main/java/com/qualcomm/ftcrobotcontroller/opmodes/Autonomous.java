package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by heel7_000 on 12/4/2015.
 */
public class Autonomous extends Gyro {
    Servo one;
    Servo two;
    GyroSensor gyroSensor;


    @Override
    public void init() {
        one = hardwareMap.servo.get("arm");
        two = hardwareMap.servo.get("leftS");
        gyroSensor = hardwareMap.gyroSensor.get("gyro");
        gyroSensor.calibrate();
        if (gyroSensor.isCalibrating()) {
            sleep(400);
        }

        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {

        driveBackwardForTime(1, 10000);
    }

    @Override
    public void stop() {
        super.stop();
    }
}
