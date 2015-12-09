package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;


public class Gyro_Programs extends OpMode {
    public static DcMotor leftMotor;
    public static DcMotor rightMotor;
    public static GyroSensor gyroSensor;
    public static int a = 1;

    @Override
    public void init() {

    }

    @Override
    public void start() {
        // super.start();
    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {
        //super.stop();
    }

    public void gyroStraight(int b, double c) {
        //GyroSensor aa;
        //aa.equals(a);
        //this.b = b;
        if (gyroSensor.getHeading() < b && gyroSensor.getHeading() < 180) {
            int temp = gyroSensor.getHeading();
            leftMotor.setPower(c + (2 * (b - temp)));
            rightMotor.setPower(c - (2 * (b - temp)));
        }
        if (gyroSensor.getHeading() > b && gyroSensor.getHeading() > 1) {
            int temp = gyroSensor.getHeading();
            leftMotor.setPower(c - (2 * (temp - b)));
            rightMotor.setPower(c + (2 * (temp - b)));
        }
        if ((gyroSensor.getHeading()) < ((b + 360))) {
            int temp = gyroSensor.getHeading();
            leftMotor.setPower(c + (2 * (b - temp)));
            rightMotor.setPower(c - (2 * (b - temp)));

        }
        if (gyroSensor.getHeading() + 360 > b) {
            int temp = gyroSensor.getHeading();
            leftMotor.setPower(c - (2 * (temp - b)));
            rightMotor.setPower(c + (2 * (temp - b)));
        }
    }

}
