package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;



public class TankDrive extends OpMode {


    DcMotor right;
    DcMotor left;
    Servo RightServo;
    Servo LeftServo;
    double ServoPosition;

    public TankDrive() {
    }

    @Override
    public void init() {
        right = hardwareMap.dcMotor.get("right");//right forward
        left = hardwareMap.dcMotor.get("left");
        left.setDirection(DcMotor.Direction.REVERSE);
        RightServo = hardwareMap.servo.get("rightS");
        LeftServo = hardwareMap.servo.get("leftS");
        ServoPosition = .5;
        RightServo.setPosition(ServoPosition);
        LeftServo.setPosition(ServoPosition);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        RightServo.setPosition(ServoPosition);
        LeftServo.setPosition(ServoPosition);
        double rightPower = -gamepad1.left_stick_y;
        double leftPower = -gamepad1.right_stick_y;
        rightPower = Range.clip(rightPower, -1, 1);
        leftPower = Range.clip(leftPower, -1, 1);
        right.setPower(-leftPower);
        left.setPower(rightPower);
        if (gamepad1.a) {
            double ServoPosition = this.ServoPosition - .1;
            RightServo.setPosition(ServoPosition);
            LeftServo.setPosition(ServoPosition);

        }
        if (gamepad1.y) {
            double ServoPosition = this.ServoPosition + .1;
            RightServo.setPosition(ServoPosition);
            LeftServo.setPosition(ServoPosition);
        }

    }
}

