package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by SrinivasaRao on 11/21/2015.
 */
public class LinearMethods extends LinearOpMode {
    DcMotor right;
    DcMotor left;
    Servo RightServo;
    Servo LeftServo;

    LightSensor lightSensor;
    int repositionStep;
    double startTime;
    boolean runTimerStarted;

    @Override
    public void runOpMode() throws InterruptedException {
        right = hardwareMap.dcMotor.get("right");

        left = hardwareMap.dcMotor.get("left");
        left.setDirection(DcMotor.Direction.REVERSE);


        LeftServo = hardwareMap.servo.get("leftS");
        RightServo = hardwareMap.servo.get("arm");

        lightSensor = hardwareMap.lightSensor.get("LightSensor");
        repositionStep = 1;
        runTimerStarted = false;
    }

    public void driveForward(double power) {
        right.setPower(-power);
        left.setPower(-power);
    }

    public boolean driveForwardForTime(double power, double targetTime) {
        driveForward(power);
        return targetTimeReached(targetTime);
    }

    public boolean driveBackwardForTime(double power, double targetTime) {
        right.setPower(power);
        left.setPower(power);
        return targetTimeReached(targetTime);
    }

    public boolean turnRightForTime(double power, double targetTime) {
        right.setPower(power);
        left.setPower(-power);
        return targetTimeReached(targetTime);
    }

    public boolean turnLeftForTime(double power, double targetTime) {
        right.setPower(-power);
        left.setPower(power);
        return targetTimeReached(targetTime);
    }

    public boolean targetTimeReached(double targetTime) {

        if (!runTimerStarted) {
            runTimerStarted = true;
            startTime = getRuntime();
            return false;
        } else {
            boolean result = (getRuntime() - startTime) >= targetTime;
            if (result) {
                runTimerStarted = false;
                return result;
            }

        }


        return false;
    }
}
