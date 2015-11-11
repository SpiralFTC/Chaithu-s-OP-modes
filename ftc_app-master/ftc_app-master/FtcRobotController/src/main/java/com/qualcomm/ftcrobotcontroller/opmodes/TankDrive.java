package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;



/**
 * Created by heel7_000 on 9/2/2015.
 */
public class TankDrive extends OpMode {

    DcMotor urmom;
    DcMotor yo;
    Servo Right;
    Servo Left;

    double RightPosition;
    double RightDelta = 0.1;
    double LeftPosition;
    double LeftDelta = 0.1;
    public TankDrive() {
    }

    @Override
    public void init() {
        urmom = hardwareMap.dcMotor.get("right");//right forward
        yo = hardwareMap.dcMotor.get("left");
        yo.setDirection(DcMotor.Direction.REVERSE);
        Right = hardwareMap.servo.get("right1");
        RightPosition = 0.2;
        Left = hardwareMap.servo.get("left2");
        LeftPosition = 0.2;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        double rightPower = -gamepad1.left_stick_y;
        double leftPower = -gamepad1.right_stick_y;

        rightPower = Range.clip(rightPower, -1, 1);
        leftPower = Range.clip(leftPower, -1, 1);
        urmom.setPower(-leftPower);
        yo.setPower(-rightPower);

        if(gamepad1.a){

        }

    }
}

