package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by SrinivasaRao on 11/21/2015.
 */
public class Linear_Auto_Methods extends LinearOpMode {
    DcMotor right;
    DcMotor left;

    @Override
    public void runOpMode() throws InterruptedException {

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