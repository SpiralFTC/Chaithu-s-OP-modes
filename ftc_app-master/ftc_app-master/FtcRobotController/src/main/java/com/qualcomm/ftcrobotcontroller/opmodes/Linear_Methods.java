package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by SrinivasaRao on 11/21/2015.
 */
public class Linear_Methods extends LinearOpMode {
    DcMotor right;
    DcMotor left;
    Servo RightServo;
    Servo LeftServo;

    LightSensor lightSensor;

    @Override
    public void runOpMode() throws InterruptedException {
        right = hardwareMap.dcMotor.get("right");

        left = hardwareMap.dcMotor.get("left");
        left.setDirection(DcMotor.Direction.REVERSE);


        LeftServo = hardwareMap.servo.get("leftS");
        RightServo = hardwareMap.servo.get("arm");

        lightSensor = hardwareMap.lightSensor.get("LightSensor");
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

    public void Wait_10Sec(double power) {
        DriveForward(0);


    }

}
