package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


/**
 * Created by SrinivasaRao on 11/1/2015.
 */
public class MountainClimb_AUTO extends LinearOpMode {

    DcMotor right;
    DcMotor left;
    LightSensor lightSensor;
   /*
    Servo RightServo;
    Servo LeftServo;
    double ServoPosition;
    */

    @Override
    public void runOpMode() throws InterruptedException {
        right = hardwareMap.dcMotor.get("right");
        left = hardwareMap.dcMotor.get("left");
        left.setDirection(DcMotor.Direction.REVERSE);
        /**
        RightServo = hardwareMap.servo.get("rightS");
        LeftServo = hardwareMap.servo.get("leftS");
        ServoPosition = .5;
        RightServo.setPosition(ServoPosition);
        LeftServo.setPosition(ServoPosition);
        */


        lightSensor = hardwareMap.lightSensor.get("LightSensor");

        waitForStart();

        while (opModeIsActive()) {
            DriveForward(0.5);
            sleep(3000);

            TurnRight(1);
            sleep(2000);

            DriveForward(0.5);
            sleep(2000);

            if (lightSensor.getLightDetected() > 0.9) {
                DriveBackward(0.5);
                sleep(500);

                TurnRight(1);
                sleep(300);

                DriveForward(1);
                sleep(5000);

            }

        }
    }


    public void DriveForward(double power) {
        right.setPower(power);
        left.setPower(power);
    }

    public void DriveBackward(double power) {
        right.setPower(-power);
        left.setPower(-power);
    }

    public void TurnRight(double power) {
        right.setPower(-power);
        left.setPower(power);
    }

    public void TurnLeft(double power) {
        right.setPower(power);
        left.setPower(-power);
    }

}
