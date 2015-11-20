package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


/**
 * Created by SrinivasaRao on 11/1/2015.
 */
public class MountainClimb_AUTO extends LinearOpMode {

    DcMotor right;
    DcMotor left;

    LightSensor lightSensor;


    @Override
    public void runOpMode() throws InterruptedException {
        right = hardwareMap.dcMotor.get("right");


        left = hardwareMap.dcMotor.get("left");
        left.setDirection(DcMotor.Direction.REVERSE);


        lightSensor = hardwareMap.lightSensor.get("LightSensor");

        waitForStart();

        while (opModeIsActive()) {
            lightSensor.enableLed(true);
            telemetry.addData("Light Value: ", lightSensor.getLightDetected());
            DriveForward(0.25);
            sleep(700);

            TurnRight(0.2);
            sleep(700);

            DriveForward(.5);
            sleep(1000);

            DriveForward(0.5);
            sleep(1000);

            if (lightSensor.getLightDetected() < 0.35) {
                DriveForward(0.5);
                sleep(500);

                TurnRight(0.1);
                sleep(50);

                DriveForward(1);


            } else{
                DriveForward(1);
            }


        }


    }


    public void DriveForward(double power) {
        right.setPower(-power);
        left.setPower(-power);
    }

    public void DriveBackward(double power) {
        right.setPower(power);
        left.setPower(power);
    }

    public void TurnRight(double power) {
        right.setPower(power);
        left.setPower(-power);
    }

    public void TurnLeft(double power) {
        right.setPower(-power);
        left.setPower(power);
    }

}