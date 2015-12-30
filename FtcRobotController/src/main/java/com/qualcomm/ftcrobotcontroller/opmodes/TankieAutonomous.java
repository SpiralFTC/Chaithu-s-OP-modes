package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


public class TankieAutonomous extends OpMode {

    OpticalDistanceSensor opticalDistanceSensor;
    TouchSensor touchSensor;
    DcMotor right;
    DcMotor left;
    ElapsedTime timer;

    double lightValue = 0.3;
    double darkValue = 0.1;
    double treshold = (lightValue + darkValue) / 2;


    double BACKUP_TIME = 0.8;
    double TURN_TIME = 1;


    @Override
    public void init() {

        right = hardwareMap.dcMotor.get("right");

        left = hardwareMap.dcMotor.get("left");
        left.setDirection(DcMotor.Direction.REVERSE);

        opticalDistanceSensor = hardwareMap.opticalDistanceSensor.get("ODS");

        touchSensor = hardwareMap.touchSensor.get("TS");


        timer = new ElapsedTime();
    }

    @Override
    public void loop() {
        double reflectance = opticalDistanceSensor.getLightDetected();
        if (reflectance > treshold) {
            right.setPower(0);
            left.setPower(0);

            timer.reset();
        } else {
            right.setPower(0.5);
            left.setPower(0.5);

        }
        /*double reflectance = opticalDistanceSensor.getLightDetected();
        if (reflectance > treshold) {
            right.setPower(0);
            left.setPower(0);

            timer.reset();
        } else {
            right.setPower(0.5);
            left.setPower(0.5);

        }


        right.setPower(-0.5);
        left.setPower(-0.5);

        if (timer.time() >= BACKUP_TIME) {

            timer.reset();
        }


        right.setPower(0.5);
        left.setPower(-0.5);

        if (timer.time() >= TURN_TIME) {

            timer.reset();
        }

        telemetry.addData("Reflectance", reflectance);


    }*/
    }
}